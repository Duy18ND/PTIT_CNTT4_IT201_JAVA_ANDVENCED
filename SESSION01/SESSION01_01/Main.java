package SESSION01.SESSION01_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currentYear = 2026;

        System.out.print("Nhập năm sinh của bạn: ");

        try {
            String birthInput = sc.nextLine();
            int birthYear = Integer.parseInt(birthInput);

            if (birthYear > currentYear) {
                System.out.println("Lỗi: Năm sinh không thể lớn hơn năm hiện tại!");
            } else if (birthYear <= 0) {
                System.out.println("Lỗi: Năm sinh không hợp lệ!");
            } else {
                int age = currentYear - birthYear;
                System.out.println("Đăng ký thành công! Tuổi của bạn là: " + age);
            }

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Kiểu dữ liệu không hợp lệ! Vui lòng chỉ nhập số.");
        } finally {
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
            sc.close();
        }
    }
}