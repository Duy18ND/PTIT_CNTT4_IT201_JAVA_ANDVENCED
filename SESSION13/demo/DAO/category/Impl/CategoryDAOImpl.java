package SESSION13.demo.DAO.category.Impl;

import SESSION13.demo.DAO.category.CategoryDAO;
import SESSION13.demo.Utility.DBUtility;
import SESSION13.demo.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    @Override
    public List<Category> displayCategory() {
        List<Category> categoryList = new ArrayList<>();
        if (categoryList.isEmpty()) {
            System.out.println("Danh sách trống!");
        }
        Connection con = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from Category";
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCate_id(rs.getString("cate_id"));
                category.setCate_name(rs.getString("cate_name"));
                category.setStatus(rs.getBoolean("status"));
                categoryList.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(con, pstmt, rs);
        }
        return categoryList;
    }

    @Override
    public boolean addCategory(Category category) {
        if (category == null || category.getCate_id() == null || category.getCate_id().trim().isEmpty()) {
            System.out.println("Lỗi: Mã danh mục không được để trống hoặc null!");
            return false;
        }

        if (findById(category.getCate_id()) != null) {
            System.out.println("Lỗi: Mã danh mục này đã tồn tại trong hệ thống!");
            return false;
        }
        Connection con = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into Category(cate_id, cate_name, status) values(?,?,?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, category.getCate_id());
            pstmt.setString(2, category.getCate_name());
            pstmt.setBoolean(3, category.isStatus());
            if (pstmt.executeUpdate() > 0) {
                System.out.println("Thêm thành công");
                return true;
            } else {
                System.out.println("Thêm thất bại");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(con, pstmt, null);
        }
    }

    @Override
    public boolean updateCategory(Category category) {
        if (category == null || category.getCate_id() == null || category.getCate_id().trim().isEmpty()) {
            System.out.println("Lỗi: Mã danh mục không được để trống hoặc null!");
            return false;
        }

        if (findById(category.getCate_id()) == null) {
            System.out.println("Lỗi: Không tìm thấy danh mục này để cập nhật!");
            return false;
        }
        Connection conn = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        String sql = "update Category set cate_name = ?, status = ? where cate_id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category.getCate_name());
            pstmt.setBoolean(2, category.isStatus());
            pstmt.setString(3, category.getCate_id());
            if (pstmt.executeUpdate() > 0) {
                System.out.println("Cập nhật thành công");
                return true;
            } else {
                System.out.println("Cập nhật thất bại");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(conn, pstmt, null);
        }
    }

    @Override
    public boolean deleteCategory(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("Lỗi: Mã danh mục cần xóa không được để trống!");
            return false;
        }

        if (findById(id) == null) {
            System.out.println("Lỗi: Không tìm thấy danh mục này để xóa!");
            return false;
        }
        Connection conn = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        String sql = "update Category set status = false where cate_id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            if (pstmt.executeUpdate() > 0) {
                System.out.println("Xóa thành công");
                return true;
            } else {
                System.out.println("Xóa thất bại");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtility.closeAll(conn, pstmt, null);
        }
    }

    @Override
    public List<Category> searchCategory(String name) {
        List<Category> categoryList = new ArrayList<>();
        Connection conn = DBUtility.getConnection();
        PreparedStatement sptmt = null;
        ResultSet rs = null;
        String sql = "select * from Category where cate_name LIKE ?";
        try {
            sptmt = conn.prepareStatement(sql);
            sptmt.setString(1, "%" + name + "%");
            rs = sptmt.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCate_id(rs.getString("cate_id"));
                category.setCate_name(rs.getString("cate_name"));
                category.setStatus(rs.getBoolean("status"));
                categoryList.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtility.closeAll(conn, sptmt, rs);
        }

        return categoryList;
    }

    @Override
    public List<Category> sortCategory(boolean isAsc) {
        List<Category> categoryList = new ArrayList<>();
        String sql = "SELECT * FROM Category ORDER BY cate_name " + (isAsc ? "ASC" : "DESC");
        try (Connection conn = DBUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Category category = new Category();
                category.setCate_id(rs.getString("cate_id"));
                category.setCate_name(rs.getString("cate_name"));
                category.setStatus(rs.getBoolean("status"));
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    //FindID
    public Category findById(String id) {
        Connection con = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from Category where cate_id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Category category = new Category();
                category.setCate_id(rs.getString("cate_id"));
                category.setCate_name(rs.getString("cate_name"));
                category.setStatus(rs.getBoolean("status"));
                return category;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(con, pstmt, rs);
        }
        return null;
    }
}
