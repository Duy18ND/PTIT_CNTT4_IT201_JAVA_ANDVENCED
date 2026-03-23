package SESSION12.SESSION12_02;

public class Main {
    static void main(String[] args) {
//Bối cảnh & Nghiệp vụ: Y tá cần cập nhật Nhiệt độ (double) và Nhịp tim (int) định kỳ cho bệnh nhân tại phòng hồi sức cấp cứu.
//Vấn đề hiện tại: Khi dùng Statement nối chuỗi, nếu nhiệt độ nhập vào là 37.5 (dùng dấu chấm) nhưng máy tính cài đặt
// vùng miền (Locale) kiểu Pháp/Việt lại dùng dấu phẩy 37,5, câu lệnh SQL sẽ bị lỗi cú pháp ngay lập tức.
        /*
            Giải thích:
             Stetament dùng nối chuỗi bản chất của nó là số double và int bị ép kiểu thành String
         */
//        Yêu cầu nộp bài:
//        Phần 1 - Phân tích: Tại sao các phương thức setDouble(), setInt() của PreparedStatement lại giúp lập trình viên không cần lo lắng về định dạng dấu chấm hay dấu phẩy của hệ điều hành?

        //Mã lỗi:
//        double temp = 37.5;
//        String sql = "update vitals set temperature = "+ temp + "where p_id" + patientId;
//        stmt.executeUpdate(sql);

//        Phần 2 - Thực thi: Viết code cập nhật các chỉ số sinh tồn của bệnh nhân bằng PreparedStatement.
        //Mã sửa:
//        double temp = 37.5;
//        String sql = "update vitals set temperature = ? where p_id = ?";
//        PreparedStatement pstmt = con.prepareStatement(sql);
//        pstmt.setDouble(1, temp);
//        pstmt.setInt(2, patientId);
//        pstmt.executeUpdate();
    }
}
