package SESSION11.Demo_CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public List<Product> getProduct() {
        List<Product> products = new ArrayList<>();
        Connection conn = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM products";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProId(rs.getInt("product_id"));
                p.setProName(rs.getString("product_name"));
                p.setProducer(rs.getString("producer"));
                p.setYear_making(rs.getInt("year_making"));
                p.setExpiryDate(rs.getDate("expire_date"));
                p.setPrice(rs.getDouble("price"));
                products.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtility.closeAll(conn, pstmt, rs);
        }
        return products;
    }

    @Override
    public boolean addProduct(Product product) {
        Connection con = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        try {
            // Dùng dấu ? làm tham số giữ chỗ
            String sql = "INSERT INTO products(product_name, producer, year_making, expire_date, price) VALUES(?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);

            // Truyền dữ liệu vào các dấu ?
            pstmt.setString(1, product.getProName());
            pstmt.setString(2, product.getProducer());
            pstmt.setInt(3, product.getYear_making());
            // Lưu ý: Chuyển java.util.Date sang java.sql.Date
            pstmt.setDate(4, new java.sql.Date(product.getExpiryDate().getTime()));
            pstmt.setDouble(5, product.getPrice());

            int row = pstmt.executeUpdate(); // Trả về số dòng bị tác động
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtility.closeAll(con, pstmt, null);
        }
    }

    @Override
    public boolean edit(Integer proId, Product product) {
        Connection con = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE products SET product_name = ?, producer = ?, year_making = ?, expire_date = ?, price = ? WHERE product_id = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, product.getProName());
            pstmt.setString(2, product.getProducer());
            pstmt.setInt(3, product.getYear_making());
            pstmt.setDate(4, new java.sql.Date(product.getExpiryDate().getTime()));
            pstmt.setDouble(5, product.getPrice());
            pstmt.setInt(6, proId); // ID dùng để xác định dòng cần sửa

            int row = pstmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtility.closeAll(con, pstmt, null);
        }
    }

    @Override
    public boolean delete(Integer proId) {
        Connection con = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "DELETE FROM products WHERE product_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, proId);

            int row = pstmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtility.closeAll(con, pstmt, null);
        }
    }
}