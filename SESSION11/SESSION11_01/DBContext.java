package SESSION11.SESSION11_01;

import java.sql.*;

public class DBContext {
//Hiện tượng rò rỉ kết nối (Connection Leak): Mỗi khi phương thức getHospitalConn() được gọi, một "đường ống" kết nối thực tế
// được thiết lập tới MySQL.Nếu không đóng, các đường ống này sẽ tích tụ dần cho đến khi vắt kiệt tài nguyên RAM và cổng mạng của máy chủ.

//Làm sập hệ thống (System Crash): Các hệ quản trị CSDL như MySQL có giới hạn số lượng kết nối tối đa (ví dụ: max_connections).
// Khi đạt ngưỡng này, hệ thống sẽ từ chối mọi yêu cầu mới, dẫn đến lỗi "Communications link failure" và khiến toàn bộ phần mềm bị "treo".

//Rủi ro trong nghiệp vụ y tế: Với hệ thống bệnh viện, việc không thể truy xuất hồ sơ bệnh nhân kịp thời do phần mềm lỗi có thể
// dẫn đến việc bác sĩ thiếu thông tin về nhóm máu, tiền sử dị ứng trong các ca cấp cứu, gây nguy hiểm trực tiếp đến tính mạng con người.
    private static final String URL = "jdbc:mysql://192.168.1.10:3306/Hospital_DB";
    private static final String USER = "admin";
    private static final String PASS = "med123";

    public Connection getHospitalConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void getPatientDetails() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getHospitalConn();
            if (conn != null) {
                String sql = "SELECT * FROM Patients";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                System.out.println("Kết nối đã được đóng an toàn.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}