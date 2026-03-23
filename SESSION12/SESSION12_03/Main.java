package SESSION12.SESSION12_03;

public class Main {
    public static void main(String[] args) {
//        Bối cảnh & Vai trò: Bệnh viện có một Stored Procedure tên là GET_SURGERY_FEE để tính toán tổng chi phí dựa trên loại phẫu thuật và bảo hiểm.
//        Đầu vào là surgery_id (IN), đầu ra là total_cost (OUT).
//                Vấn đề hiện tại: Code của bạn chạy nhưng hệ thống báo lỗi: The column index is out of range hoặc không lấy được giá trị tiền tệ ra.

//        Mã nguồn lỗi:
//        CallableStatement cstmt = conn.prepareCall("{call GET_SURGERY_FEE(?, ?)}");
//        cstmt.setInt(1, 505);
//        cstmt.execute();
//        double cost = cstmt.getDouble(2); // Lỗi quên bước đăng ký tham số ở đầu ra

//        /*
//            Giải thích:
//            1. Tại sao phải gọi registerOutParameter() trước khi thực thi:
//            - Bản chất: Đây là bước "đặt chỗ và báo kiểu" cho JDBC Driver.
//            - Driver cần biết trước kiểu dữ liệu của tham số trả về (OUT parameter) để cấp phát đúng kích thước bộ nhớ và chuẩn bị sẵn cơ chế ánh xạ (mapping) từ Database sang đối tượng Java. Nếu không đăng ký trước, khi Database trả kết quả về, JDBC sẽ không biết cách hứng dữ liệu và văng lỗi ngay lập tức.
//
//            2. Đăng ký kiểu DECIMAL trong SQL:
//            - Trong Java, bạn bắt buộc phải đăng ký bằng hằng số: java.sql.Types.DECIMAL (hoặc java.sql.Types.NUMERIC).
//            */

//                Phần 2 - Thực thi: Triển khai hoàn chỉnh mã nguồn gọi thủ tục trên và in ra chi phí phẫu thuật.
        //Mã sửa:
//        CallableStatement cstmt = conn.prepareCall("{call GET_SURGERY_FEE(?, ?)}");
//        cstmt.setInt(1, 505);
//        cstmt.registerOutParameter(2, java.sql.Types.DECIMAL);
//        cstmt.execute();
//        double cost = cstmt.getDouble(2);
//        System.out.println("Total cost: " + cost);
    }
}
