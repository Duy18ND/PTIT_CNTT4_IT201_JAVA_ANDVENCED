package SESSION01.SESSION01_03;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tuổi: ");
        int age = sc.nextInt();
        User user = new User();
        try {
            user.setAge(age);
            System.out.println("Tuổi của người dùng là: "+ user.getAge());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Hệ thống vẫn hoạt động");
    }
}
