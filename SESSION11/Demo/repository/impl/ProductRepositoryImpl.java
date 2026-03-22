package SESSION11.Demo.repository.impl;

import SESSION11.Demo.entity.Product;
import SESSION11.Demo.repository.ProductRepository;
import SESSION11.Demo.utility.DBUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Connection conn = DBUtility.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        if (conn == null) return products;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM products");
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
            DBUtility.closeAll(conn, stmt, rs);
        }
        return products;
    }
}