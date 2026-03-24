package SESSION13.SESSION13_03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BenhNhanDAO {

    public double getSoDu(Connection conn, int maBenhNhan) throws SQLException {
        String sql = "SELECT so_du_tam_ung FROM BenhNhan WHERE ma_benh_nhan = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maBenhNhan);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("so_du_tam_ung");
                }
                throw new SQLException("Không tìm thấy dữ liệu bệnh nhân mã: " + maBenhNhan);
            }
        }
    }

    public void truTien(Connection conn, int maBenhNhan, double soTien) throws SQLException {
        String sql = "UPDATE BenhNhan SET so_du_tam_ung = so_du_tam_ung - ? WHERE ma_benh_nhan = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, soTien);
            ps.setInt(2, maBenhNhan);

            int rowAffected = ps.executeUpdate();
            if (rowAffected == 0) {
                throw new SQLException("Trừ tiền thất bại: Bệnh nhân không tồn tại.");
            }
        }
    }

    public void capNhatTrangThai(Connection conn, int maBenhNhan, String trangThai) throws SQLException {
        String sql = "UPDATE BenhNhan SET trang_thai = ? WHERE ma_benh_nhan = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, trangThai);
            ps.setInt(2, maBenhNhan);

            int rowAffected = ps.executeUpdate();
            if (rowAffected == 0) {
                throw new SQLException("Cập nhật trạng thái thất bại.");
            }
        }
    }
}