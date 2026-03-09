package SESSION02.DEMO;
import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class References  {
    public static void main(String[] args) {

        System.out.println("--- 1. Static Method (Class::staticMethod) ---");
        /* * Tham chiếu đến một phương thức tĩnh (static) của một lớp.
         * Ví dụ: Integer::parseInt
         */
        // Cách dùng Lambda: str -> Integer.parseInt(str)
        Function<String, Integer> stringToInt = Integer::parseInt;
        System.out.println("Ép kiểu chuỗi '100' thành số: " + stringToInt.apply("100"));


        System.out.println("\n--- 2. Instance Method của Object cụ thể (obj::instanceMethod) ---");
        /* * Tham chiếu đến phương thức của một đối tượng (object) đã được tạo sẵn.
         * Ví dụ: System.out::println (System.out là một object có sẵn)
         */
        // Cách dùng Lambda: msg -> System.out.println(msg)
        Consumer<String> printMessage = System.out::println;
        printMessage.accept("In ra dòng chữ này bằng System.out::println");


        System.out.println("\n--- 3. Instance Method của Class (Class::instanceMethod) ---");
        /* * Tham chiếu đến phương thức của một đối tượng sẽ được truyền vào sau (khi gọi hàm).
         * Ví dụ: String::equals
         */
        // Cách dùng Lambda: (str1, str2) -> str1.equals(str2)
        // BiPredicate nhận 2 tham số: đối tượng gọi hàm (str1) và tham số truyền vào hàm equals (str2)
        BiPredicate<String, String> isEqual = String::equals;
        System.out.println("'Java' có bằng 'Java' không? " + isEqual.test("Java", "Java"));
        System.out.println("'Java' có bằng 'Python' không? " + isEqual.test("Java", "Python"));


        System.out.println("\n--- 4. Constructor (Class::new) ---");
        /* * Tham chiếu đến hàm tạo (Constructor) để tạo đối tượng mới.
         * Ví dụ: ArrayList::new
         */
        // Cách dùng Lambda: () -> new ArrayList<>()
        Supplier<ArrayList<String>> createList = ArrayList::new;

        // Gọi .get() để thực sự tạo ra một ArrayList mới
        ArrayList<String> myList = createList.get();
        myList.add("Phần tử đầu tiên");
        System.out.println("Danh sách vừa tạo có nội dung: " + myList);
    }
}