package SESSION12.SESSION12_01;

public class Main {
    public static void main(String[] args) {
/*
Phần 1 - Phân tích: Tại sao PreparedStatement lại được coi là "tấm khiên" chống lại SQL Injection? Cơ chế "Pre-compiled"
 (biên dịch trước) giúp ích gì trong việc bảo vệ tham số đầu vào?
        + Khóa cấu trúc: Khi khởi tạo câu lệnh chứa ? được gửi xuống Database để biên dịch trước. Database khóa lại chỗ ? là chỗ chứa dữ liệu
        + Truyền dữ liệu an toàn: Khi set giá trị vào ? và thực thi, Database coi mọi thứ truyền vào chỉ là DỮ LIỆU THÔ, SQL tuyệt đối không biên dịch lại
 */

        //Mã lỗi:
//        String sql = "select * from Doctor where code = '" + code "' and password = '" + password + "'"
//                + password + "'";
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery(sql);

        //Phần 2 - Thực thi: Viết lại đoạn code đăng nhập bằng PreparedStatement với các dấu hỏi chấm (?) để đảm bảo an toàn tuyệt đối.
//        String sql = "select * from Doctor where code = ? and password = ?";
//        PreparedStatement pstmt = con.prepareStatement(sql);
//        pstmt.setString(1, code);
//        pstmt.setString(2, password);
//        ResultSet rs = pstmt.executeQuery();
    }
}
