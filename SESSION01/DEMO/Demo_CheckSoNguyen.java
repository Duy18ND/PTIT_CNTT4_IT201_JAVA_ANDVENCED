package SESSION01.DEMO;

import java.util.Scanner;

public class Demo_CheckSoNguyen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 0;

        while (true) {
            try {
                System.out.print("Nhập một số nguyên: ");
                String input = sc.nextLine();

                if (input.trim().isEmpty()) {
                    throw new Exception("Lỗi: Không được để trống!");
                }

                number = Integer.parseInt(input);

                if (number == -1) {
                    throw new Exception("Lỗi: Không xử lý -1");
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Nhập dữ liệu chưa đúng (không nhập chữ)");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Số bạn nhập vào: " + number);
    }
}