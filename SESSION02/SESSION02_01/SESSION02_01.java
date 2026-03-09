package SESSION02.SESSION02_01;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SESSION02_01 {
    public static void main(String[] args) {

        // 1. Predicate: Kiểm tra xem một User có phải là Admin hay không
        Predicate<User> isAdminCheck = User::isAdmin;

        // 2. Function: Chuyển đổi User thành String chứa username
        Function<User, String> getUsernameFunc = User::getUsername;

        // 3. Consumer: In thông tin chi tiết của User ra màn hình
        Consumer<User> printUser = System.out::println;

        // 4. Supplier: Khởi tạo một đối tượng User mới với các giá trị mặc định
        Supplier<User> createDefaultUser = User::new;


        System.out.println("--- CHẠY THỬ NGHIỆM ---");

        // Dùng Supplier để tạo 1 user mặc định
        User newUser = createDefaultUser.get();

        // Tạo thêm 1 user là Admin bằng tay
        User adminUser = new User("admin_super", true);

        // Dùng Consumer để in thông tin
        System.out.print("Thông tin newUser: ");
        printUser.accept(newUser);

        // Dùng Function để lấy username
        System.out.println("Username của adminUser là: " + getUsernameFunc.apply(adminUser));

        // Dùng Predicate để kiểm tra
        System.out.println("newUser có phải admin không? " + isAdminCheck.test(newUser));
        System.out.println("adminUser có phải admin không? " + isAdminCheck.test(adminUser));
    }
}