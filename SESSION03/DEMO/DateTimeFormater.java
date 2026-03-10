package SESSION03.DEMO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * MÔ TẢ TỔNG QUAN:
 * DateTimeFormatter là "cái khuôn" giúp chuyển đổi qua lại giữa Thời gian thực (Object Java) và Chuỗi văn bản (String).
 * * ỨNG DỤNG TOÀN HỆ THỐNG:
 * Làm cầu nối giao tiếp giữa Frontend (Web/App) và Backend (Java).
 * Khách hàng thường đọc/nhập ngày tháng dưới dạng chuỗi String, nhưng Server cần Object LocalDateTime để lưu Database và tính toán.
 */
public class DateTimeFormater {
    public static void main(String[] args) {

        System.out.println("=== 1. FORMAT (Ép kiểu LocalDateTime -> String) ===");
        /*
         * MÔ TẢ: Biến Object thời gian của Java (chuẩn ISO có chữ 'T' ở giữa, rất khó đọc)
         * thành chuỗi String thân thiện, đẹp mắt.
         * * ỨNG DỤNG THỰC TẾ:
         * 1. Hiển thị "Ngày giờ đặt hàng", "Thời gian bình luận" lên giao diện Shopee, Facebook.
         * 2. Trình bày dữ liệu khi xuất báo cáo doanh thu ra file PDF, Excel cho Giám đốc xem.
         */
        LocalDateTime birth = LocalDateTime.of(2000, 10, 25, 14, 30, 0);
        System.out.println("Mặc định của Java (Hơi xấu): " + birth);

        // Tạo một cái "khuôn" định dạng (Pattern)
        DateTimeFormatter formatToVN = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // Nhúng thời gian vào khuôn
        String birthString = birth.format(formatToVN);
        System.out.println("Sau khi Format cho người Việt Nam xem: " + birthString);


        System.out.println("\n=== 2. PARSE (Ép kiểu String -> LocalDateTime) ===");
        /*
         * MÔ TẢ: Dịch một chuỗi String (do người dùng nhập hoặc từ API trả về)
         * ngược lại thành Object LocalDateTime để hệ thống hiểu được.
         * * ỨNG DỤNG THỰC TẾ:
         * 1. Hứng dữ liệu từ người dùng: Khi khách chọn ngày "Check-in khách sạn", Java phải Parse chuỗi đó
         * thành Object để kiểm tra xem ngày đó phòng đã có ai đặt chưa.
         * 2. Import dữ liệu: Đọc danh sách nhân viên từ file Excel (ngày sinh dạng text) để lưu vào Database.
         */
        String inputFromUser = "15-08-2024 09:15";

        // Chú ý: Khuôn parse phải KHỚP 100% với chuỗi String đầu vào (dấu gạch ngang, khoảng trắng)
        DateTimeFormatter parsePattern = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        // Biến chuỗi thành Object LocalDateTime để Java tính toán được
        LocalDateTime parsedDate = LocalDateTime.parse(inputFromUser, parsePattern);
        System.out.println("Đã chuyển thành Object LocalDateTime: " + parsedDate);
    }
}