package SESSION07.SESSION07_05;

import SESSION07.SESSION07_05.entity.Customer;
import SESSION07.SESSION07_05.entity.Order;
import SESSION07.SESSION07_05.entity.OrderItem;
import SESSION07.SESSION07_05.entity.Product;
import SESSION07.SESSION07_05.repository.DatabaseOrderRepository;
import SESSION07.SESSION07_05.repository.OrderRepository;
import SESSION07.SESSION07_05.service.EmailNotification;
import SESSION07.SESSION07_05.service.NotificationService;
import SESSION07.SESSION07_05.service.OrderService;
import SESSION07.SESSION07_05.strategy.DiscountStrategy;
import SESSION07.SESSION07_05.strategy.PercentageDiscount;
import SESSION07.SESSION07_05.payment.CreditCardPayment;
import SESSION07.SESSION07_05.payment.PaymentMethod;
import SESSION07.SESSION07_05.util.InvoiceGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Product> productDB = new ArrayList<>();
    static List<Customer> customerDB = new ArrayList<>();
    static List<Order> orderDB = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        OrderRepository dbRepo = new DatabaseOrderRepository();
        NotificationService emailNotifier = new EmailNotification();
        OrderService orderService = new OrderService(dbRepo, emailNotifier);
        InvoiceGenerator invoiceGen = new InvoiceGenerator();

        while (true) {
            System.out.println("\n--- HỆ THỐNG QUẢN LÝ ĐƠN HÀNG ---");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem danh sách đơn hàng");
            System.out.println("5. Tính doanh thu");
            System.out.println("6. Thêm thanh toán mới");
            System.out.println("7. Thêm giảm giá mới");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    productDB.add(new Product("SP01", "Laptop", 15000000, "Điện tử"));
                    System.out.println("Đã thêm sản phẩm SP01");
                    break;
                case "2":
                    customerDB.add(new Customer("KH01", "Nguyễn Văn A", "a@example.com", "0123456789"));
                    System.out.println("Đã thêm khách hàng");
                    break;
                case "3":
                    if (customerDB.isEmpty() || productDB.isEmpty()) {
                        System.out.println("Vui lòng thêm khách hàng và sản phẩm trước!");
                        break;
                    }
                    Customer c = customerDB.get(0);
                    Product p = productDB.get(0);

                    Order order = new Order("ORD001", c);
                    order.addItem(new OrderItem(p, 1));

                    DiscountStrategy discount = new PercentageDiscount(10);
                    PaymentMethod payment = new CreditCardPayment();

                    orderService.processOrder(order, discount, payment);
                    orderDB.add(order);

                    invoiceGen.printInvoice(order);
                    break;
                case "4":
                    System.out.println("Danh sách đơn hàng:");
                    for (Order o : orderDB) {
                        System.out.printf("%s - %s - %,.0f\n", o.getOrId(), o.getCustomer().getName(), o.getFinalAmount());
                    }
                    break;
                case "5":
                    double totalRevenue = 0;
                    for (Order o : orderDB) {
                        totalRevenue += o.getFinalAmount();
                    }
                    System.out.printf("Tổng doanh thu: %,.0f\n", totalRevenue);
                    break;
                case "6":
                    System.out.println("Đã thêm phương thức thanh toán ZaloPay");
                    break;
                case "7":
                    System.out.println("Đã thêm chiến lược giảm giá VIP 20%");
                    break;
                case "8":
                    System.out.println("Thoát chương trình!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}