package SESSION01.DEMO;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo_Validate_Email {
    public static void main(String[] args) {
        String email;
        Scanner sc = new Scanner(System.in);

        Pattern p = Pattern.compile("^[a-zA-Z][._\\w]*@\\w{3,}(\\.\\w{2,5})(\\.\\w{2,5})?$");

        while (true) {
            System.out.print("Nhập vào địa chỉ Email: ");
            email = sc.nextLine();

            if (email.isBlank()) {
                System.out.println("Bạn phải nhập dữ liệu!");
            } else {
                Matcher m = p.matcher(email);

                if (!m.matches()) {
                    System.out.println("Lỗi: Email không đúng định dạng!");
                } else {
                    System.out.println("Thành công! Email của bạn là: " + email);
                    break;
                }
            }
        }
    }
}