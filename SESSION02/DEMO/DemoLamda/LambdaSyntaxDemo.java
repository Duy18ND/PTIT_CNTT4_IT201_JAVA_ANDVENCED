package SESSION02.DEMO.DemoLamda;

import java.util.function.Predicate;

public class LambdaSyntaxDemo {
    public static void main(String[] args) {

        // 🔴 CÁCH 1: Lớp nặc danh (Anonymous Inner Class) - Cách cổ điển trước Java 8
        // Rất dài dòng, nhiều code thừa.
        Predicate<Integer> isGreaterThan5_Old = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number > 5;
            }
        };

        // 🟡 CÁCH 2: Cú pháp Lambda cơ bản
        // Bỏ đi tên interface và tên hàm (vì Java tự hiểu được). Giữ lại tham số và phần body.
        Predicate<Integer> isGreaterThan5_Lambda1 = (Integer number) -> {
            return number > 5;
        };

        // 🟢 CÁCH 3: Cú pháp Lambda rút gọn (Khuyên dùng)
        // - Không cần khai báo kiểu dữ liệu của tham số (tự suy luận là Integer).
        // - Nếu thân hàm chỉ có 1 dòng, bỏ luôn cặp ngoặc nhọn {} và chữ 'return'.
        Predicate<Integer> isGreaterThan5_Lambda2 = (number) -> number > 5;

        // 🔵 CÁCH 4: Cú pháp Lambda siêu rút gọn
        // - Nếu chỉ có đúng 1 tham số, bỏ luôn cặp ngoặc đơn () bọc tham số.
        Predicate<Integer> isGreaterThan5_Perfect = number -> number > 5;

        System.out.println("Cú pháp Lambda hoàn hảo: " + isGreaterThan5_Perfect.test(8)); // true
    }
}