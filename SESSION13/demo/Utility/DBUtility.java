package SESSION13.demo.Utility;

import java.sql.*;

public class DBUtility {
    private static DBUtility instance;
    private static final String DB_NAME = "session12";
    private static final String USER = "root";
    private static final String PASS = "123456";
    private Connection conn;

    private DBUtility(){
        //Kết nối 1 lần khi gọi
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ DB_NAME, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Không thể kết nối trong Database: "+ e.getMessage());
        }
    }

    public static DBUtility getInstance() {
        if(instance == null){
            instance = new DBUtility();
        }
        return instance;
    }

    public static Connection getConnection() {
        return getInstance().conn;
    }

    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
