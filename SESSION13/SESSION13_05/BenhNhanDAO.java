package SESSION13.SESSION13_05;

import java.sql.*;

public class BenhNhanDAO {
    public void layDanhSachGiuongTrong() {
        String sql = "SELECT * FROM giuongbenh WHERE trang_thai = 'trong'";
        try (Connection conn = DBUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("--- DANH SÁCH GIƯỜNG TRỐNG ---");
            boolean hasBed = false;
            while (rs.next()) {
                hasBed = true;
                System.out.println("Mã giường: " + rs.getInt("ma_giuong") + " - Tên: " + rs.getString("ten_giuong"));
            }
            if (!hasBed) System.out.println("Hiện tại không còn giường trống nào!");
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối CSDL: " + e.getMessage());
        }
    }

    public boolean tiepNhanBenhNhan(String tenBN, int tuoi, int maGiuong, double tienTamUng) {
        Connection conn = null;
        PreparedStatement psBenhNhan = null;
        PreparedStatement psGiuong = null;
        PreparedStatement psTaiChinh = null;
        ResultSet rsKeys = null;

        try {
            conn = DBUtility.getConnection();
            conn.setAutoCommit(false);

            String sqlInsertBN = "INSERT INTO benhnhan(ten_benh_nhan, tuoi, so_du_tam_ung) VALUES (?, ?, ?)";
            psBenhNhan = conn.prepareStatement(sqlInsertBN, Statement.RETURN_GENERATED_KEYS);
            psBenhNhan.setString(1, tenBN);
            psBenhNhan.setInt(2, tuoi);
            psBenhNhan.setDouble(3, tienTamUng);
            psBenhNhan.executeUpdate();

            rsKeys = psBenhNhan.getGeneratedKeys();
            int maBenhNhanMoi = 0;
            if (rsKeys.next()) {
                maBenhNhanMoi = rsKeys.getInt(1);
            } else {
                throw new SQLException("Không thể tạo hồ sơ bệnh nhân mới.");
            }

            String sqlUpdateGiuong = "UPDATE giuongbenh SET trang_thai = 'co_nguoi', ma_benh_nhan = ? WHERE ma_giuong = ? AND trang_thai = 'trong'";
            psGiuong = conn.prepareStatement(sqlUpdateGiuong);
            psGiuong.setInt(1, maBenhNhanMoi);
            psGiuong.setInt(2, maGiuong);
            int rowGiuong = psGiuong.executeUpdate();

            if (rowGiuong == 0) {
                throw new SQLException("Giường số '" + maGiuong + "' không tồn tại hoặc đã có người đăng ký. Vui lòng chọn giường khác!");
            }

            String sqlInsertTaiChinh = "INSERT INTO taichinh(ma_benh_nhan, so_tien_tam_ung) VALUES (?, ?)";
            psTaiChinh = conn.prepareStatement(sqlInsertTaiChinh);
            psTaiChinh.setInt(1, maBenhNhanMoi);
            psTaiChinh.setDouble(2, tienTamUng);
            psTaiChinh.executeUpdate();

            conn.commit();
            return true;

        } catch (SQLException e) {
            System.out.println("\n[!] LỖI HỆ THỐNG: " + e.getMessage());
            if (conn != null) {
                try {
                    System.out.println("[!] Đang hoàn tác (Rollback) toàn bộ thao tác...");
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        } finally {
            try {
                if (rsKeys != null) rsKeys.close();
                if (psBenhNhan != null) psBenhNhan.close();
                if (psGiuong != null) psGiuong.close();
                if (psTaiChinh != null) psTaiChinh.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}