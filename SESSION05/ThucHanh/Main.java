package SESSION05.ThucHanh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product product = new Product();
        int choice;
        do {
            System.out.println("\n========= PRODUCT MANAGEMENT SYSTEM =========");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật số lượng theo ID");
            System.out.println("4. Xóa sản phẩm đã hết hàng");
            System.out.println("5. Thoát chương trình");
            System.out.println("=============================================");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập giá: ");
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.print("Nhập số lượng: ");
                    int quantity = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập danh mục: ");
                    String category = sc.nextLine();

                    product.add(new Product.Products(id,name,price,quantity,category));
                    break;
                case 2:
                    product.display();
                    break;
                case 3:
                    System.out.println("=======UPDATE=======");
                    System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                    int updateId = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập số lượng mới: ");
                    int newQuantity = Integer.parseInt(sc.nextLine());

                    product.update(updateId, newQuantity);
                    break;
                case 4:
                    product.delete();
                    break;
                case 5:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ!");
            }
        } while (choice != 5);
    }
}