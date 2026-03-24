package SESSION13.SESSION13_03;
import java.sql.Connection;
import java.sql.SQLException;

public class HospitalService {
    private final BenhNhanDAO benhNhanDAO = new BenhNhanDAO();
    private final GiuongBenhDAO giuongBenhDAO = new GiuongBenhDAO();

    public boolean xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {
        Connection conn = null;

        try {
            //MỞ KẾT NỐI VÀ TẮT AUTO-COMMIT
            conn = DatabaseManager.getConnection();
            conn.setAutoCommit(false);

            double soDu = benhNhanDAO.getSoDu(conn, maBenhNhan);
            if (soDu < tienVienPhi) {
                throw new SQLException("Số dư không đủ. Có: " + soDu + ", Cần: " + tienVienPhi);
            }

            benhNhanDAO.truTien(conn, maBenhNhan, tienVienPhi);
            giuongBenhDAO.giaiPhongGiuong(conn, maBenhNhan);
            benhNhanDAO.capNhatTrangThai(conn, maBenhNhan, "DA_XUAT_VIEN");

            //CHỐT GIAO DỊCH
            conn.commit();
            System.out.println("Thủ tục xuất viện hoàn tất cho bệnh nhân: " + maBenhNhan);
            return true;

        } catch (SQLException e) {
            // NẾU CÓ BẤT KỲ LỖI NÀO TỪ DAO NÉM LÊN -> ROLLBACK
            System.out.println("Lỗi quy trình xuất viện: " + e.getMessage());
            if (conn != null) {
                try {
                    System.out.println("Đang hoàn tác (Rollback) toàn bộ hệ thống...");
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("Lỗi nghiêm trọng khi Rollback: " + ex.getMessage());
                }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}