package SESSION03.DEMO;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * MÔ TẢ TỔNG QUAN VỀ STREAM API:
 * Stream API không phải là cấu trúc dữ liệu (như List, Set), mà là một "đường ống" (pipeline) xử lý dữ liệu.
 * Giúp xử lý hàng triệu phần tử dữ liệu trong Collection cực kỳ nhanh chóng, ngắn gọn mà không cần viết các vòng lặp for chằng chịt.
 */
public class StreamAPI {
    public static void main(String[] args) {
        // Dữ liệu mẫu
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);
        List<String> names = Arrays.asList("Duy", "Hoa", "Hoài", "Đức", "An", "Bình");

        System.out.println("=== 1. INTERMEDIATE OPERATIONS (Thao tác trung gian) ===");
        // BẢN CHẤT: Các hàm này luôn trả về một Stream mới (để có thể nối tiếp nhau theo chuỗi chaining).

        /* * 1. Filter (Lọc dữ liệu)
         * - ỨNG DỤNG: Cực kỳ phổ biến. Dùng để tìm kiếm sản phẩm theo giá (vd: > 100k), lọc ra danh sách khách hàng VIP,
         * hoặc bỏ đi các tài khoản đã bị khóa trước khi hiển thị.
         */
        System.out.println("Filter (Số chẵn): " +
                numbers.stream().filter(n -> n % 2 == 0).toList());

        /* * 2. Map (Biến đổi cấu trúc dữ liệu)
         * - ỨNG DỤNG: Dùng nhiều nhất trong kiến trúc backend. Chuyển đổi từ dữ liệu thô (Entity)
         * sang dữ liệu trả về cho Frontend (DTO) để giấu đi thông tin nhạy cảm như Password.
         */
        System.out.println("Map (In hoa): " +
                names.stream().map(String::toUpperCase).toList());

        /* * 3. Sorted (Sắp xếp)
         * - ỨNG DỤNG: Làm bảng xếp hạng điểm số sinh viên, hiển thị tin tức mới nhất lên đầu,
         * sắp xếp sản phẩm từ giá thấp đến cao.
         */
        System.out.println("Sorted (Giảm dần): " +
                numbers.stream().sorted((a, b) -> b.compareTo(a)).toList());

        /* * 4. Distinct (Loại bỏ trùng lặp)
         * - ỨNG DỤNG: Lọc ra danh sách các Tỉnh/Thành phố duy nhất từ bảng địa chỉ khách hàng.
         */
        System.out.println("Distinct (Bỏ số trùng): " +
                numbers.stream().distinct().toList());

        /* * 5 & 6. Limit & Skip (Giới hạn và Bỏ qua)
         * - ỨNG DỤNG: Là bộ đôi hoàn hảo để làm chức năng Phân trang (Pagination) trên Website.
         * Ví dụ: Khách đang ở Trang 3, mỗi trang có 10 sản phẩm -> code sẽ là: skip(20).limit(10).
         */
        System.out.println("Limit (Lấy 3 phần tử đầu): " + numbers.stream().limit(3).toList());
        System.out.println("Skip (Bỏ qua 3 phần tử đầu): " + numbers.stream().skip(3).toList());

        /* * 7. Peek (Nhìn lén)
         * - ỨNG DỤNG: Chủ yếu dùng để Debug (Bắt lỗi). Bạn cài peek() ở giữa đường ống để in ra console
         * xem dữ liệu lúc đó đang mang hình thù gì, mà không làm thay đổi luồng dữ liệu thật.
         */
        System.out.println("Peek (In số chẵn trước khi nhân đôi): ");
        List<Integer> peekList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.print(n + " -> "))
                .map(n -> n * 2)
                .toList();
        System.out.println("\nKết quả sau Peek & Map: " + peekList);


        System.out.println("\n=== 2. TERMINAL OPERATIONS (Thao tác kết thúc) ===");
        // BẢN CHẤT: Công tắc kích hoạt "đường ống". Trả về kết quả cuối cùng (Số, Boolean, List, Void).

        /* * 8. forEach (Duyệt)
         * - ỨNG DỤNG: Thực hiện một hành động lên toàn bộ danh sách.
         * Ví dụ: Gửi email thông báo khuyến mãi cho từng khách hàng trong list.
         */
        System.out.print("forEach (In tên): ");
        names.stream().forEach(name -> System.out.print(name + " "));
        System.out.println();

        /* * 9. Reduce (Cộng dồn / Thu gọn)
         * - ỨNG DỤNG: Tính tổng tiền các sản phẩm trong Giỏ hàng của khách.
         */
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Reduce (Tổng các số): " + sum);

        /* * 10. Count (Đếm)
         * - ỨNG DỤNG: Hiển thị con số đỏ đỏ đếm "Số thông báo chưa đọc" hoặc "Số đơn hàng chờ xác nhận".
         */
        long countH = names.stream().filter(n -> n.startsWith("H")).count();
        System.out.println("Count (Số người tên bắt đầu bằng H): " + countH);

        /* * 11. Match (Kiểm tra logic tập hợp)
         * - ỨNG DỤNG: Validation (Kiểm duyệt dữ liệu).
         * VD: Kiểm tra xem trong giỏ hàng có sản phẩm nào đang Hết hàng không (anyMatch) để chặn không cho thanh toán.
         */
        boolean anyMatch = numbers.stream().anyMatch(n -> n > 9);
        boolean allMatch = numbers.stream().allMatch(n -> n > 0);
        boolean noneMatch = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("Match: Any > 9 (" + anyMatch + "), All > 0 (" + allMatch + "), None < 0 (" + noneMatch + ")");

        /* * 12. Min / Max (Tìm nhỏ/lớn nhất)
         * - ỨNG DỤNG: Tìm sản phẩm rẻ nhất / đắt nhất trong danh mục. Trả về Optional vì nhỡ danh sách rỗng.
         */
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("Max (Số lớn nhất): " + max.orElse(-1));

        /* * 13. FindFirst (Tìm phần tử đầu tiên)
         * - ỨNG DỤNG: Tìm kiếm 1 User cụ thể trong DB dựa vào Email đăng nhập. Kết hợp trả về Optional để xử lý null.
         */
        Optional<String> first = names.stream().filter(n -> n.length() > 3).findFirst();
        System.out.println("FindFirst (Tên đầu tiên dài hơn 3 chữ cái): " + first.orElse("Không thấy"));
    }
}