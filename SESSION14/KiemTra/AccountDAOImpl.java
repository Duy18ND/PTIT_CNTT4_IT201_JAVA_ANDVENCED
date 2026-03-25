package SESSION14.KiemTra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAOImpl implements AccountDAO {

    public boolean findById(String id) {
        Connection con = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from Accounts where AccountId = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Accounts accounts = new Accounts();
                accounts.setAccounts(rs.getString("AccountId"));
                accounts.setFullName(rs.getString("FullName"));
                accounts.setBalance(rs.getDouble("Balance"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(con, pstmt, rs);
        }
    }

    public boolean transfer(String fromAccountId, String toAccountId, double amount) {
        if(findById(fromAccountId)){
            System.err.println("Lỗi: Tài khoản nguồn không tồn tại.");
            return false;
        }
        if(findById(toAccountId)){
            System.err.println("Lỗi: Tài khoản đích không tồn tại.");
            return false;
        }
        if (amount <= 0) {
            System.err.println("Lỗi: Số tiền chuyển phải là số dương.");
            return false;
        }

        Connection conn = null;
        PreparedStatement psDebit = null;
        PreparedStatement psCredit = null;

        // Câu lệnh SQL để trừ tiền
        String debitSql = "UPDATE Accounts SET Balance = Balance - ? WHERE AccountId = ?";
        // Câu lệnh SQL để cộng tiền
        String creditSql = "UPDATE Accounts SET Balance = Balance + ? WHERE AccountId = ?";

        try {
            conn = DBUtility.getConnection();
            // Bắt đầu giao dịch
            conn.setAutoCommit(false);

            // Trừ tiền tk
            System.out.println("Chuẩn bị trừ " + amount + " từ tài khoản " + fromAccountId);
            psDebit = conn.prepareStatement(debitSql);
            psDebit.setDouble(1, amount);
            psDebit.setString(2, fromAccountId);
            int rowsDebit = psDebit.executeUpdate();

            // Cộng tiền
            System.out.println("Chuẩn bị cộng " + amount + " vào tài khoản " + toAccountId);
            psCredit = conn.prepareStatement(creditSql);
            psCredit.setDouble(1, amount);
            psCredit.setString(2, toAccountId);
            int rowsCredit = psCredit.executeUpdate();

            // Kiểm tra & commit
            if (rowsDebit > 0 && rowsCredit > 0) {
                conn.commit();
                System.out.println("Giao dịch thành công!");
                return true;
            } else {
                System.err.println("Giao dịch thất bại, một trong hai tài khoản không tồn tại.");
                conn.rollback();
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Lỗi SQL, giao dịch đang được rollback.");
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        } finally {
            DBUtility.closeAll(null, psDebit, null);
            DBUtility.closeAll(conn, psCredit, null);
        }
    }
}
