package SESSION08.SESSION08_06;

import SESSION08.SESSION08_06.discount.DiscountStrategy;
import SESSION08.SESSION08_06.factory.SalesChannelFactory;
import SESSION08.SESSION08_06.notification.NotificationService;
import SESSION08.SESSION08_06.payment.PaymentMethod;

public class OrderService {
    private DiscountStrategy discount;
    private PaymentMethod payment;
    private NotificationService notification;

    public OrderService(SalesChannelFactory factory) {
        this.discount = factory.createDiscountStrategy();
        this.payment = factory.createPaymentMethod();
        this.notification = factory.createNotificationService();
    }

    public void placeOrder(String product, double price, int quantity) {
        double total = price * quantity;
        double finalAmount = discount.applyDiscount(total);

        payment.pay(finalAmount);
        notification.send("Đơn hàng thành công");
    }
}