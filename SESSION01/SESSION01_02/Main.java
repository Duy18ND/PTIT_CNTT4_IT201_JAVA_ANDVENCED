package SESSION01.SESSION01_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Nhập tổng số người: ");
            int totalPeopel = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập tổng số nhóm: ");
            int group = sc.nextInt();
            if(totalPeopel <= 0){
                System.out.println("Lỗi: Tổng số người phải lớn hơn 0");
            }else if(group < 0){
                System.out.println("Lỗi: Số lượng nhóm ít nhất là 1");
            }else{
                int result = totalPeopel / group;
                System.out.println("Mỗi nhóm có "+ result +" người");
            }
        }catch (ArithmeticException e){
            System.out.println("Lỗi: Không thể chia cho 0");
        }catch (NumberFormatException e){
            System.out.println("Lỗi: Vui lòng nhập số không nhập chữ");
        }finally {
            System.out.println("Chương trình đang được thực thi");
        }
    }
}
