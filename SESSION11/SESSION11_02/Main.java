package SESSION11.SESSION11_02;

import java.sql.*;

public class Main {
//Phần 1: Nếu sử dụng điều kiện if-else không đủ xử lý duyệt danh sách vì if-else chỉ kiểm tra một lần và trả  về kết quả đầu tiên
//Phần 2 - Thực thi: Sửa lại mã nguồn, sử dụng vòng lặp phù hợp để in ra bảng danh mục thuốc gồm: Tên thuốc và Số lượng tồn kho.

    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            if (con != null) {
                stmt = con.createStatement();

                rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy");

                System.out.println("========= DANH MỤC THUỐC KIỂM KÊ =========");
                System.out.printf("%-20s | %-10s\n", "Tên thuốc", "Số lượng tồn");
                System.out.println("------------------------------------------");

                boolean hasData = false;
                while (rs.next()) {
                    hasData = true;
                    String name = rs.getString("medicine_name");
                    int stockQuantity = rs.getInt("stock");

                    System.out.printf("%-20s | %-10d\n", name, stockQuantity);
                }

                if (!hasData) {
                    System.out.println("Thông báo: Hiện không có thuốc nào trong kho.");
                }
                System.out.println("==========================================");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi hệ thống khi truy xuất kho thuốc: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/My_db1", "root", "123456");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Kết nối thất bại: " + e.getMessage());
        }
        return conn;
    }
}