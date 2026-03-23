package SESSION12.SESSION12_04;

public class Main {
    public static void main(String[] args) {
      /*
        Hiện trạng & Nỗi đau: Vào buổi sáng, bệnh viện cần nạp hàng ngàn kết quả xét nghiệm máu từ máy phân tích vào Database.

        Mã nguồn lỗi (Chạy cực chậm):
            for(TestResult tr: list){
               String sql = "insert int Result(data) values('" + tr.getData() + "')";
               Statement stmt = conn.createStatement();
               stmt.executeUpdate(sql); // Tạo mới Statement và biên dịch lại 1000 lần
            }

        Yêu cầu nộp bài:
        Phần 1: Phân tích sự lãng phí tài nguyên của Database Server khi phải phân tích (Parse) và lập kế hoạch thực thi (Execution Plan) 1.000 lần cho cùng một cấu trúc câu lệnh.
            Hard Parser biên dịch cứng dùng trong Statement:
            Nguyên nhân: Việc cộng chuỗi khiến mỗi vòng lặp sinh ra một câu lệnh SQL có nội dung khác nhau
            Vấn đề: Database biên dịch mỗi lần chạy gây tốn kém từng câu lệnh: Phân tích -> Lập kế hoạch -> Thực thi
            Hậu quả: CPU tính toán lại khi mỗi lần biên dịch bắt kiệt CPU

        Phần 2: Sử dụng PreparedStatement để tối ưu hóa: Khởi tạo bên ngoài vòng lặp, nạp tham số và thực thi bên trong vòng lặp. Đánh giá sự khác biệt về tốc độ.
            Mã sửa:
            for(TestResult tr: list){
               String sql = "insert int Result(data) values(?)";
               PreparedStatement pstmt = conn.prepareStatement(sql);
               pstmt.setString(1, tr.getData());
               pstmt.executeUpdate();
            }
        */
    }
}
