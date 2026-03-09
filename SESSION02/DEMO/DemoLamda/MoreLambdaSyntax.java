package SESSION02.DEMO.DemoLamda;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MoreLambdaSyntax {
    public static void main(String[] args) {

        // --- FUNCTION: Nhận 1 (String), Trả 1 (Integer) ---
        // Thay vì: (String s) -> { return s.length(); }
        // Rút gọn thành:
        Function<String, Integer> getLength = s -> s.length();
        System.out.println("Độ dài chữ 'Java': " + getLength.apply("Java"));


        // --- CONSUMER: Nhận 1 (String), Trả void ---
        // Thay vì: (String msg) -> { System.out.println(msg); }
        // Rút gọn thành:
        Consumer<String> printMessage = msg -> System.out.println("Thông báo: " + msg);
        printMessage.accept("Học Lambda rất vui!");


        // --- SUPPLIER: Nhận 0, Trả 1 (String) ---
        // LƯU Ý: Vì không có tham số nào, nên BẮT BUỘC phải giữ lại cặp ngoặc đơn rỗng ()
        // Thay vì: () -> { return "Trà sữa"; }
        // Rút gọn thành:
        Supplier<String> getDrink = () -> "Trà sữa";
        System.out.println("Đồ uống của bạn: " + getDrink.get());


        // ❌ LƯU Ý KHI THÂN HÀM CÓ NHIỀU HƠN 1 DÒNG:
        // Nếu bạn cần xử lý phức tạp nhiều bước, bạn bắt buộc phải dùng ngoặc nhọn {} và chữ return (nếu có trả về).
        Function<Integer, Integer> complexLogic = n -> {
            int step1 = n * 2;
            int step2 = step1 + 10;
            return step2; // Bắt buộc có chữ return
        };
    }
}