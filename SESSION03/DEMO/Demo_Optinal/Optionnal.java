package SESSION03.DEMO.Demo_Optinal;

import java.util.Optional;

/**
 * MÔ TẢ TỔNG QUAN:
 * Phần nâng cao của Optional giúp lập trình viên viết code theo phong cách Functional (Hàm).
 * Giúp chuỗi xử lý logic được viết liên tục (chaining) mà không bị ngắt quãng bởi các khối lệnh if-else kiểm tra null dài dòng.
 */
public class Optionnal {
    public static void main(String[] args) {

        // Dữ liệu giả lập
        Optional<Student> studentOpt = Optional.of(new Student("Trần Văn Đức"));
        Optional<Student> emptyOpt = Optional.empty();

        System.out.println("\n=== 4. BIẾN ĐỔI VÀ LỌC DỮ LIỆU BÊN TRONG HỘP ===");

        /*
         * A. map()
         * MÔ TẢ: Thò tay vào hộp lấy dữ liệu, biến đổi nó thành cái khác, rồi nhét lại vào một hộp Optional mới.
         * Nếu hộp ban đầu rỗng, nó an toàn trả về hộp rỗng mới mà không báo lỗi.
         * * ỨNG DỤNG THỰC TẾ:
         * Dùng cực nhiều trong kiến trúc hệ thống (Spring Boot) để chuyển đổi dữ liệu.
         * Ví dụ: Tìm Object User từ Database, sau đó dùng map() để chỉ lấy ra mỗi cái chuỗi Email của User đó để gửi thông báo.
         */
        Optional<String> nameOpt = studentOpt.map(s -> s.getName().toUpperCase());
        System.out.println("Dùng map() biến đổi tên: " + nameOpt.orElse("Không có tên"));

        System.out.println("Dùng map() trên hộp rỗng: " + emptyOpt.map(Student::getName).orElse("Không có ai"));

        /*
         * B. filter()
         * MÔ TẢ: Đặt bộ lọc ngay ngoài cửa hộp. Nếu dữ liệu trong hộp thỏa mãn điều kiện -> Giữ nguyên hộp.
         * Nếu không thỏa mãn -> Biến thành hộp rỗng (Vứt bỏ dữ liệu).
         * * ỨNG DỤNG THỰC TẾ:
         * Kiểm tra trạng thái tài khoản. Ví dụ: Tìm thấy User trong DB, nhưng phải filter thêm điều kiện
         * u -> u.getStatus() == "ACTIVE" thì mới cho phép đăng nhập. Nếu tài khoản bị khóa (bị filter loại bỏ), xử lý như User không tồn tại.
         */
        Optional<Student> filteredOpt = studentOpt.filter(s -> s.getName().startsWith("Trần"));
        System.out.println("Dùng filter() tìm họ Trần: " + filteredOpt.isPresent()); // Trả về true

        Optional<Student> filteredOpt2 = studentOpt.filter(s -> s.getName().startsWith("Nguyễn"));
        System.out.println("Dùng filter() tìm họ Nguyễn: " + filteredOpt2.isPresent()); // Trả về false


        System.out.println("\n=== 5. XỬ LÝ NÂNG CAO (HIỆU NĂNG & JAVA 9+) ===");

        /*
         * C. orElseGet()
         * MÔ TẢ: Gần giống orElse, nhưng thông minh hơn nhờ cơ chế "Lười biếng" (Lazy).
         * Nó CHỈ CHẠY đoạn code dự phòng NẾU hộp thực sự rỗng.
         * * ỨNG DỤNG THỰC TẾ:
         * Tối ưu hiệu năng cực mạnh. Ví dụ: Tìm thông tin người chơi trong Cache (RAM) trước.
         * Nếu hộp rỗng (Cache miss), dùng orElseGet để gọi hàm chọc vào Database (rất chậm và tốn tài nguyên) để lấy dữ liệu lên.
         */
        System.out.print("Dùng orElseGet: ");
        Student s1 = emptyOpt.orElseGet(() -> {
            System.out.println("Đang kết nối Database để tạo user mặc định...");
            return new Student("Khách Vãng Lai");
        });

        /*
         * D. ifPresentOrElse() (Từ Java 9)
         * MÔ TẢ: Giải quyết trọn vẹn bài toán rẽ 2 nhánh "Nếu có thì làm A, nếu rỗng thì làm B" chỉ trong 1 lệnh duy nhất.
         * * ỨNG DỤNG THỰC TẾ:
         * Tính năng Quên Mật Khẩu: Người dùng nhập Email.
         * - Nhánh Có (ifPresent): Tạo mã OTP và gửi mail.
         * - Nhánh Không (orElse): Log ra hệ thống cảnh báo có người đang cố tình dò quét Email.
         */
        System.out.println("\nDùng ifPresentOrElse cho studentOpt:");
        studentOpt.ifPresentOrElse(
                s -> System.out.println("-> Đã tìm thấy: " + s.getName()), // Nhánh Có data
                () -> System.out.println("-> Không tìm thấy sinh viên nào!") // Nhánh Rỗng
        );

        System.out.println("Dùng ifPresentOrElse cho emptyOpt:");
        emptyOpt.ifPresentOrElse(
                s -> System.out.println("-> Đã tìm thấy: " + s.getName()),
                () -> System.out.println("-> Không tìm thấy sinh viên nào!")
        );

        /*
         * E. isEmpty() (Từ Java 11)
         * MÔ TẢ: Đơn giản là ngược lại của isPresent().
         * * ỨNG DỤNG THỰC TẾ:
         * Validate dữ liệu đăng ký. Nhập Email đăng ký mới -> Tìm trong DB xem Email này có ai dùng chưa.
         * Nếu kết quả trả về là isEmpty() -> Cho phép đăng ký.
         */
        if (emptyOpt.isEmpty()) {
            System.out.println("\nDùng isEmpty(): Xác nhận hộp trống rỗng!");
        }
    }
}