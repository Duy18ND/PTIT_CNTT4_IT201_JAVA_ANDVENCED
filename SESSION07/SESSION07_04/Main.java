package SESSION07.SESSION07_04;

public class Main {
    public static void main(String[] args) {
        OrderRepository fileRepo = new FileOrderRepository();
        NotificationService emailNotifier = new EmailService();

        OrderService service1 = new OrderService(fileRepo, emailNotifier);
        service1.createOrder(new Order("ORD001"), "khachhang@email.com");

        OrderRepository dbRepo = new DatabaseOrderRepository();
        NotificationService smsNotifier = new SMSNotification();

        OrderService service2 = new OrderService(dbRepo, smsNotifier);
        service2.createOrder(new Order("ORD002"), "Duy18nd@gmail.com");
    }
}
