package SESSION01.DEMO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Throw_exception {
    static void main(String[] args) throws ParseException {
        Date birthday = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời bạn nhập ngày sinh: ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        birthday = sdf.parse(sc.nextLine());
        if(birthday != null){
            System.out.println("Ngày sinh của bạn là: " +sdf.format(birthday));
        }else {
            System.out.println("Nhập sai định dạng");
        }
        System.out.println("abc"); //Throw gặp lỗi dừng luôn chương trình
    }
}
