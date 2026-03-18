package SESSION08.SESSION08_06;

import SESSION08.SESSION08_06.factory.MobileAppFactory;
import SESSION08.SESSION08_06.factory.POSFactory;
import SESSION08.SESSION08_06.factory.SalesChannelFactory;
import SESSION08.SESSION08_06.factory.WebsiteFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Chọn kênh:");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. POS");

        int choice = sc.nextInt();

        SalesChannelFactory factory = null;

        switch (choice) {
            case 1:
                factory = new WebsiteFactory();
                System.out.println("Bạn đã chọn kênh Website");
                break;
            case 2:
                factory = new MobileAppFactory();
                System.out.println("Bạn đã chọn kênh Mobile App");
                break;
            case 3:
                factory = new POSFactory();
                System.out.println("Bạn đã chọn kênh POS");
                break;
        }

        OrderService orderService = new OrderService(factory);

        sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String product = sc.nextLine();

        System.out.print("Giá: ");
        double price = sc.nextDouble();

        System.out.print("Số lượng: ");
        int quantity = sc.nextInt();

        orderService.placeOrder(product, price, quantity);
    }
}