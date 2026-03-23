package SESSION12.SESSION12_05.Repositon.ipml;

import SESSION12.SESSION12_05.Entity.Bneed;
import SESSION12.SESSION12_05.Repositon.BneedReposition;
import SESSION12.SESSION12_05.Utility.DBUitility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BneedImpl implements BneedReposition {
    private DBUitility DBUtility;

    @Override
    public List<Bneed> getBneed() {
        List<Bneed> bneedList = new ArrayList<>();
        Connection con = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from Bneed";
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Bneed bneed = new Bneed();
                bneed.setBneed_id(rs.getString("bneed_id"));
                bneed.setName(rs.getString("name"));
                bneed.setAge(rs.getInt("age"));
                bneed.setTreatment(rs.getString("treatment"));

                bneedList.add(bneed);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bneedList;
    }

    @Override
    public boolean addBneed(Bneed bneed) {
        Connection con = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "insert into Bneed(bneed_id, name, age, treatment) values(?, ?, ?, ?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bneed.getBneed_id());
            pstmt.setString(2, bneed.getName());
            pstmt.setInt(3, bneed.getAge());
            pstmt.setString(4, bneed.getTreatment());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateBneed(Bneed bneed) {
        Connection con = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "update Bneed set name = ?, age = ?, treatment = ? where bneed_id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bneed.getName());
            pstmt.setInt(2, bneed.getAge());
            pstmt.setString(3, bneed.getTreatment());
            pstmt.setString(4, bneed.getBneed_id());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean dischargePatient(String id) {
        Connection con = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "delete from Bneed where bneed_id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double calculateFee(String id) {
       double fee = 0;
       String sql = "{call CALCULATE_DISCHARGE_FEE(?,?)}";
       Connection con = DBUtility.getConnection();
        try {
            CallableStatement cstmt = con.prepareCall(sql);
            cstmt.setString(1, id);
            cstmt.registerOutParameter(2, Types.DECIMAL);
            cstmt.execute();
            fee = cstmt.getDouble(2);
        } catch (SQLException e) {
            System.out.println("Lỗi tính chi phí");
            throw new RuntimeException(e);
        }
        return fee;
    }

    @Override
    public Bneed findById(String id) {
        Connection con = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from Bneed where bneed_id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Bneed bneed = new Bneed();
                bneed.setBneed_id(rs.getString("bneed_id"));
                bneed.setName(rs.getString("name"));
                bneed.setAge(rs.getInt("age"));
                bneed.setTreatment(rs.getString("treatment"));
                return bneed;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
