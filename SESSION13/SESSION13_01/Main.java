package SESSION13.SESSION13_01;

public class Main {
    public static void main(String[] args) {
       /*

        - Mã nguồn lỗi

         public void capPhatThuoc ( int medicineId, int patienId){
            Connection con = null;
            try {
                con = DatebaseManager.getConnection();
                String sqlUpdateInventory = "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE medicine_id = ?";
                PreparedStatement psl = con.prereStatement(sqlUpdateInventory);
                psl.setInt(1, medicineId);
                psl.executeUpdate();

                //Giả lập sự cố lỗi Database xảy ra ngay tại đây
                int x = 10 / 0; //Gây ra lỗi RuntimeExcetion bất ngờ

                //Thao tác 2: Ghi vào lịch sử bệnh án (Không bao giờ chạy tới do lỗi ở trên)
                String sqlInsertHistory = "INSERT INTO Prescription_History (patient_id, medicine_id, date) VALUES (?, ?, GETDATE())";
                PreparedStatement ps2 = con.prepareStatement(sqlInsertHistory);
                ps2.setInt(1, patientId);
                ps2.setInt(2, medicineId);
                ps2.executeUpdate();

                System.out.println("Cấp phát thuốc thành công!");
            }catch (Exception e){
                System.out.println("Có xảy ra lỗi: "+ e.getMessage());
            }finally {
                //Code đóng kết nối ở đây (Đã ẩn để rút gọn)
            }

       4. Yêu cầu nộp bài
        Phần 1 - Phân tích logic: Dựa vào kiến thức về nguyên lý hoạt động của Transaction (Lesson 01) và chế độ Auto-Commit mặc định
        của JDBC (Lesson 02), hãy giải thích tại sao khi xảy ra lỗi ở giữa dòng code, thuốc trong kho vẫn bị trừ mà dữ liệu không bị hủy bỏ?
            - Bản chất của Commit-auto luôn được bật true điều này khiến câu lệnh executeUpdate() được coi là 1 giao dịch độc lập

            - Vấn đề code:
                + Lệnh psl.executeUpdate() chạy xong, thuốc trong kho (Medicine_Inventory) bị trừ đi 1. Do Auto-Commit đang bật, Database lưu luôn kết quả này vào ổ cứng.
                + Ngay sau đó, lỗi int x = 10 / 0; (chia cho 0) ném ra một RuntimeException.
                + Luồng chương trình lập tức bị ngắt, văng thẳng xuống khối catch. Lệnh ghi lịch sử (Prescription_History) hoàn toàn bị bỏ qua.

        Phần 2 - Thực thi: Sửa lại đoạn code trên. Hãy sử dụng các phương thức tắt Auto-Commit và chủ động Commit dữ liệu để đảm bảo tính toàn vẹn của nghiệp vụ
            MÃ SỬA:
        public void capPhatThuoc(int medicineId, int patientId) {
        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            con = DatabaseManager.getConnection();

            // 1. TẮT AUTO-COMMIT: Bắt đầu một Transaction mới
            con.setAutoCommit(false);

            // Thao tác 1: Trừ kho
            String sqlUpdateInventory = "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE medicine_id = ?";
            ps1 = con.prepareStatement(sqlUpdateInventory);
            ps1.setInt(1, medicineId);
            ps1.executeUpdate();

            // Giả lập sự cố lỗi bất ngờ
            // int x = 10 / 0;

            // Thao tác 2: Ghi vào lịch sử bệnh án
            String sqlInsertHistory = "INSERT INTO Prescription_History (patient_id, medicine_id, date) VALUES (?, ?, GETDATE())";
            ps2 = con.prepareStatement(sqlInsertHistory);
            ps2.setInt(1, patientId);
            ps2.setInt(2, medicineId);
            ps2.executeUpdate();

            // 2. CHỐT GIAO DỊCH: Lưu toàn bộ xuống DB nếu không có lỗi nào xảy ra
            con.commit();
            System.out.println("Cấp phát thuốc thành công! Cả 2 thao tác đã được lưu.");

        } catch (Exception e) {
            System.out.println("Xảy ra lỗi trong quá trình cấp phát: " + e.getMessage());

            // 3. HOÀN TÁC GIAO DỊCH (ROLLBACK): Nếu có lỗi, phục hồi dữ liệu về trạng thái ban đầu
            if (con != null) {
                try {
                    System.out.println("Đang hoàn tác (Rollback) lại số lượng thuốc trong kho...");
                    con.rollback();
                } catch (SQLException ex) {
                    System.out.println("Lỗi nghiêm trọng khi Rollback: " + ex.getMessage());
                }
            }
        } finally {
            // 4. DỌN DẸP TÀI NGUYÊN
            try {
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    */
    }
}

