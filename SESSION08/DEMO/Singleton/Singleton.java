package SESSION08.DEMO.Singleton;

/**
 * ========================================================
 * BÍ KÍP ÔN TẬP: DESIGN PATTERN - SINGLETON
 * ========================================================
 * 1. BẢN CHẤT: Đảm bảo class này chỉ tạo ra DUY NHẤT 1 object trong toàn app.
 * * 2. KHI NÀO CẦN DÙNG (Dấu hiệu nhận biết thực tế):
 * - Database Connection: Mở 1 cổng kết nối CSDL dùng chung để không sập server.
 * - Logger: Dùng 1 đối tượng để ghi file log lỗi, tránh việc 2 luồng ghi đè lên nhau.
 * - Configuration: Đọc file cấu hình (config.properties) 1 lần, dùng chung mọi nơi.
 * - Cache: Lưu trữ dữ liệu tạm thời trên RAM dùng chung cho toàn hệ thống.
 * ========================================================
 */
public class Singleton {

    // BƯỚC 1: Tạo biến static private để lưu trữ "Ông Giám Đốc" duy nhất
    private static Singleton instance;

    // BƯỚC 2: KHÓA CỬA! Constructor private ngăn không cho class khác gọi hàm new()
    private Singleton() {}

    // BƯỚC 3: Cổng kết nối duy nhất (Global access point)
    public static Singleton getInstance() {
        // Kỹ thuật Lazy Initialization (Cần dùng mới tạo)
        if(instance == null){
            instance = new Singleton(); // Chỉ chạy dòng này đúng 1 lần duy nhất
        }
        return instance; // Các lần sau gọi lại sẽ trả về đúng object cũ
    }

    public String hello(){
        return "Hello World! Tôi là instance duy nhất trong RAM!";
    }
}