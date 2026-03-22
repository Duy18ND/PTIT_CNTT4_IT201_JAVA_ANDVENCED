package SESSION11.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KhoiTaoConnect {
    //Cách 1:
    public static Connection connectMySql(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db1", "root", "123456");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void main(String[] args) {
        System.out.println(connectMySql());
    }
}
