package SESSION07.SESSION07_05.service;

import SESSION07.SESSION07_05.entity.Order;
import SESSION07.SESSION07_05.entity.OrderItem;
import SESSION07.SESSION07_05.repository.OrderRepository;
import SESSION07.SESSION07_05.strategy.DiscountStrategy;
import SESSION07.SESSION07_05.payment.PaymentMethod;

public class OrderService {
    private OrderRepository repository;
    private NotificationService notifier;

    public OrderService(OrderRepository repository, NotificationService notifier) {
        this.repository = repository;
        this.notifier = notifier;
    }

    public void processOrder(Order order, DiscountStrategy discount, PaymentMethod payment) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += item.getSubTotal();
        }
        order.setTotalAmount(total);

        double finalPrice = discount.applyDiscount(total);
        order.setFinalAmount(finalPrice);

        payment.processPayment(finalPrice);

        repository.save(order);

        notifier.send("Đơn hàng " + order.getOrId() + " đã được tạo thành công.", order.getCustomer());
    }
}