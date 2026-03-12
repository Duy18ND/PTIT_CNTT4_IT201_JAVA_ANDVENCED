public class UserService {

    public boolean checkRegistrationAge(int age) {
        // Kiểm tra lỗi logic: Tuổi không thể âm
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        // Điều kiện: Từ 18 tuổi trở lên mới được đăng ký
        return age >= 18;
    }
}