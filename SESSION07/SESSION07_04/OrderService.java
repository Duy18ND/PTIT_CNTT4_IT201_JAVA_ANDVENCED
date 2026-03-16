package SESSION07.SESSION07_04;

public class OrderService {
    private OrderRepository repository;
    private NotificationService notificationService;

    public OrderService(OrderRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void createOrder(Order order, String customerContact) {
        repository.save(order);
        String message = "Đơn hàng " + order.getId() + " đã được tạo";
        notificationService.send(message, customerContact);
    }
}
