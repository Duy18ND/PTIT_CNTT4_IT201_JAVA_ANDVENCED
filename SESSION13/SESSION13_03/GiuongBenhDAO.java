package SESSION13.SESSION13_03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GiuongBenhDAO {

    public void giaiPhongGiuong(Connection conn, int maBenhNhan) throws SQLException {
        String sql = "UPDATE GiuongBenh SET trang_thai = 'TRONG' WHERE ma_benh_nhan = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maBenhNhan);

            int rowAffected = ps.executeUpdate();
            if (rowAffected == 0) {
                throw new SQLException("Giải phóng giường thất bại: Không tìm thấy giường của bệnh nhân này.");
            }
        }
    }
}