package SESSION02.DEMO;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {

        System.out.println("--- 1. PREDICATE ---");
        /*
         * Predicate<T>
         * - Nhận: 1 tham số kiểu T
         * - Trả về: boolean (true/false)
         * - Ứng dụng: Dùng để kiểm tra một điều kiện (thường dùng trong filter).
         * - Phương thức chính: test(T t)
         */
        // Ví dụ: Kiểm tra xem một số nguyên có phải là số chẵn hay không
        Predicate<Integer> isEven = (number) -> number % 2 == 0;

        System.out.println("10 có phải số chẵn không? " + isEven.test(10)); // Kết quả: true
        System.out.println("7 có phải số chẵn không? " + isEven.test(7));   // Kết quả: false


        System.out.println("\n--- 2. FUNCTION ---");
        /*
         * Function<T, R>
         * - Nhận: 1 tham số kiểu T
         * - Trả về: 1 giá trị kiểu R
         * - Ứng dụng: Dùng để biến đổi dữ liệu từ dạng này sang dạng khác (thường dùng trong map).
         * - Phương thức chính: apply(T t)
         */
        // Ví dụ: Nhận vào một chuỗi String và trả về độ dài của chuỗi đó (Integer)
        Function<String, Integer> getStringLength = (str) -> str.length();

        String myString = "Xin chao Java";
        int length = getStringLength.apply(myString);
        System.out.println("Độ dài của chuỗi '" + myString + "' là: " + length);


        System.out.println("\n--- 3. CONSUMER ---");
        /*
         * Consumer<T>
         * - Nhận: 1 tham số kiểu T
         * - Trả về: void (không trả về gì cả)
         * - Ứng dụng: Dùng để thực hiện một hành động nào đó (như in ra màn hình, ghi log, lưu database) mà không cần kết quả trả về.
         * - Phương thức chính: accept(T t)
         */
        // Ví dụ: Nhận vào một chuỗi và in nó ra màn hình với định dạng chữ hoa
        Consumer<String> printUpperCase = (text) -> System.out.println("In ra: " + text.toUpperCase());

        printUpperCase.accept("hello world"); // Kết quả: In ra: HELLO WORLD


        System.out.println("\n--- 4. SUPPLIER ---");
        /*
         * Supplier<T>
         * - Nhận: 0 tham số (không nhận gì cả)
         * - Trả về: 1 giá trị kiểu T
         * - Ứng dụng: Dùng để cung cấp, sinh ra dữ liệu, tạo mới object hoặc lấy giá trị mặc định.
         * - Phương thức chính: get()
         */
        // Ví dụ: Tạo một Supplier để sinh ra một số ngẫu nhiên từ 0 đến 99
        Supplier<Integer> randomScoreGenerator = () -> (int) (Math.random() * 100);

        System.out.println("Điểm ngẫu nhiên lần 1: " + randomScoreGenerator.get());
        System.out.println("Điểm ngẫu nhiên lần 2: " + randomScoreGenerator.get());
    }
}