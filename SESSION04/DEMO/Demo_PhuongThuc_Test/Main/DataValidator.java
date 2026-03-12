import java.util.Arrays;

public class DataValidator {

    // 1. Dùng cho assertEquals: Chuyển chữ thường thành chữ hoa
    public String toUpperCase(String input) {
        if (input == null) return null;
        return input.toUpperCase();
    }

    // 2. Dùng cho assertTrue: Kiểm tra tuổi trưởng thành
    public boolean isAdult(int age) {
        return age >= 18;
    }

    // 3. Dùng cho assertFalse: Kiểm tra số chẵn
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    // 4. Dùng cho assertNull & assertNotNull: Tìm kiếm User giả lập
    public String findRole(String username) {
        if ("admin".equals(username)) {
            return "SUPER_ADMIN";
        }
        return null; // Không tìm thấy thì trả về null
    }

    // 5. Dùng cho assertThrows: Kiểm tra độ dài mật khẩu
    public void validatePassword(String password) {
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Mật khẩu quá ngắn!");
        }
    }

    // 6. Dùng cho assertTimeout: Giả lập một tiến trình xử lý nặng tốn thời gian
    public void heavyProcessing() throws InterruptedException {
        // Cố tình làm chậm chương trình 200 mili-giây
        Thread.sleep(200);
    }

    // 7. Dùng cho assertArrayEquals: Sắp xếp mảng số nguyên
    public int[] sortNumbers(int[] numbers) {
        Arrays.sort(numbers);
        return numbers;
    }
}