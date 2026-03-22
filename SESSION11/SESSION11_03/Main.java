package SESSION11.SESSION11_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/My_db1";
    private static final String USER = "root";
    private static final String PASS = "123456";

    public static void main(String[] args) {
        /* Phần 1 - Phân tích:
            - Phương thức executeUpdate() không trả về ResultSet như executeQuery(),
              mà nó trả về một số nguyên (int).
            - Số nguyên này đại diện cho số lượng dòng (rows) dữ liệu đã bị thay đổi (thêm, sửa, xóa) trong Database.
            - Bằng cách kiểm tra giá trị này (vd: > 0), ta biết được lệnh có thực sự tác động lên dữ liệu hay không.
        */

        String inputId = "Bed_001";

        String sql = "UPDATE Beds SET bed_status = 'Occupied' WHERE bed_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, inputId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("=> Đã cập nhật giường bệnh thành công! Trạng thái: Đang sử dụng.");
            } else {
                System.err.println("=> Lỗi: Cập nhật thất bại. Mã giường '" + inputId + "' không tồn tại trong hệ thống!");
            }

        } catch (SQLException e) {
            System.err.println("Lỗi cơ sở dữ liệu: " + e.getMessage());
        }
    }
}