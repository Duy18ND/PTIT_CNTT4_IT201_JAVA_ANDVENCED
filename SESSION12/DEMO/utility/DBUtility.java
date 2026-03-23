package SESSION12.DEMO.utility;

import java.sql.*;

public class DBUtility {
    private final static String DB_NAME = "session12";
    private final static String USER = "root";
    private final static String PASS = "123456";
    public static Connection getConnect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/+" + DB_NAME, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    static void main(String[] args) {
        System.out.println(getConnect());
    }

    static void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs){
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
