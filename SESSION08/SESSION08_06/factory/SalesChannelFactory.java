package SESSION08.SESSION08_06.factory;

import SESSION08.SESSION08_06.discount.DiscountStrategy;
import SESSION08.SESSION08_06.notification.NotificationService;
import SESSION08.SESSION08_06.payment.PaymentMethod;

public abstract class SalesChannelFactory {
    public abstract DiscountStrategy createDiscountStrategy();
    public abstract PaymentMethod createPaymentMethod();
    public abstract NotificationService createNotificationService();
}