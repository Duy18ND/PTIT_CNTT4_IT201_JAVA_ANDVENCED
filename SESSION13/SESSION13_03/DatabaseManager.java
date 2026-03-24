package SESSION13.SESSION13_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/session12";
    private static final String USER = "root";
    private static final String PASS = "123456";

    // Hàm lấy kết nối
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối Database: Sai thông tin URL, Username hoặc Password!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return conn;
    }

    // Hàm test thử kết nối chạy độc lập
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Kết nối Database thành công tuyệt đối!");
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}