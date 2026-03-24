package SESSION13.SESSION13_02;

public class Main {
    static void main(String[] args) {
        /*
    3. Mã nguồn lỗi
    public void thanhToanVienPhi(int patientId, int invoiceId, double amount) {
        try (Connection conn = DatabaseManager.getConnection()) {

            // Tắt tự động lưu giao dịch
            conn.setAutoCommit(false);

            // Thao tác 1: Trừ tiền trong ví
            String sqlDeductWallet = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sqlDeductWallet);
            ps1.setDouble(1, amount);
            ps1.setInt(2, patientId);
            ps1.executeUpdate(); // Chạy thành công

            // Thao tác 2: Cập nhật trạng thái hóa đơn
            // LỖI LOGIC: Cố tình viết sai tên bảng từ Invoices thành Invoicesss để tạo Exception
            String sqlUpdateInvoice = "UPDATE Invoicesss SET status = 'PAID' WHERE invoice_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sqlUpdateInvoice);
            ps2.setInt(1, invoiceId);
            ps2.executeUpdate(); // Sẽ ném ra lỗi SQLException ngay tại đây

            // Xác nhận giao dịch
            conn.commit();
            System.out.println("Thanh toán hoàn tất!");

        } catch (SQLException e) {
            // BẪY DỮ LIỆU ĐANG NẰM Ở ĐÂY!
            System.out.println("Lỗi hệ thống: Không thể hoàn tất thanh toán. Chi tiết: " + e.getMessage());
            // Lập trình viên chỉ in ra lỗi chứ không có hành động can thiệp vào Database
        }
    }

    4. Yêu cầu
    Phần 1 - Phân tích: Tại sao việc chỉ dùng System.out.println() để in ra lỗi trong khối catch là
    vi phạm nguyên tắc của Transaction? Hành động thiết yếu nào đã bị lập trình viên bỏ quên khi xảy ra SQLException?

    Trả lời:
    Lỗi Logic: Khối catch chỉ in ra thông báo lỗi mà bỏ quên lệnh conn.rollback().
    Khi lệnh số 2 bị lỗi, lệnh số 1 (trừ tiền) vẫn kẹt trong bộ nhớ đệm, gây treo (lock) cơ sở dữ liệu.

    Lỗi Cú pháp: Lập trình viên dùng try-with-resources try (Connection conn = ... ). Cú pháp này sẽ tự
    động đóng kết nối ngay trước khi nhảy vào khối catch. Do đó, nếu có gọi conn.rollback() trong catch
    cũng sẽ bị báo lỗi "Connection is closed".

    Phần 2 - Thực thi: Sửa lại đoạn code trên. Hãy bổ sung dòng lệnh bắt buộc phải có trong khối catch để đảm bảo cơ sở dữ
    liệu được khôi phục về trạng thái an toàn trước khi xảy ra lỗi. (Lưu ý: Nhớ bọc try-catch cẩn thận cho chính câu lệnh sửa lỗi đó)
        MÃ SỬA:
        public void thanhToanVienPhi(int patientId, int invoiceId, double amount) {
            Connection conn = null;
            PreparedStatement ps1 = null;
            PreparedStatement ps2 = null;

            try {
                conn = DatabaseManager.getConnection();
                conn.setAutoCommit(false);

                String sqlDeductWallet = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
                ps1 = conn.prepareStatement(sqlDeductWallet);
                ps1.setDouble(1, amount);
                ps1.setInt(2, patientId);
                ps1.executeUpdate();

                String sqlUpdateInvoice = "UPDATE Invoicesss SET status = 'PAID' WHERE invoice_id = ?";
                ps2 = conn.prepareStatement(sqlUpdateInvoice);
                ps2.setInt(1, invoiceId);
                ps2.executeUpdate();

                conn.commit();
                System.out.println("Thanh toán hoàn tất!");

            } catch (SQLException e) {
                System.out.println("Lỗi hệ thống: " + e.getMessage());

                if (conn != null) {
                    try {
                        conn.rollback();
                    } catch (SQLException ex) {
                        System.out.println("Lỗi Rollback: " + ex.getMessage());
                    }
                }
            } finally {
                try {
                    if (ps1 != null) ps1.close();
                    if (ps2 != null) ps2.close();
                    if (conn != null) {
                        conn.setAutoCommit(true);
                        conn.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }`
    */
    }
}
