package SESSION01.SESSION01_05;

public class Main {
    public static void main(String[] args) {
        User user = new User();

        try {
            user.setAge(-10);
            System.out.println("Tuổi của người dùng là: " + user.getAge());
        } catch (InvalidAgeException e) {
            System.out.println("Bắt được lỗi nghiệp vụ: " + e.getClass().getSimpleName());
            System.out.println("Chi tiết: " + e.getMessage());
            System.out.println("--- In ra Stack Trace để kiểm tra tên Exception ---");
            e.printStackTrace();
        }

        System.out.println("Hệ thống xử lý lỗi êm đẹp và tiếp tục chạy...");
    }
}