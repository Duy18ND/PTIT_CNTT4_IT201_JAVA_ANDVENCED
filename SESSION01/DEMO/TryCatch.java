package SESSION01.DEMO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TryCatch {
    static void main(String[] args) {
        Date birthday = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("Mời bạn nhập ngày sinh: ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            birthday = sdf.parse(sc.nextLine());
        } catch (ParseException e) {
            e.printStackTrace(); //Thông báo lỗi khi runtime
            System.out.println("Kiểu ngày tháng sai định dạng");
        }
        if (birthday != null) {
            System.out.println("Ngày sinh của bạn là: " + sdf.format(birthday));
        }
        System.out.println("abc");//Try catch lỗi vẫn chạy dòng dưới
    }
}
