package SESSION08.SESSION08_06.factory;

import SESSION08.SESSION08_06.discount.DiscountStrategy;
import SESSION08.SESSION08_06.discount.FirstTimeDiscount;
import SESSION08.SESSION08_06.notification.NotificationService;
import SESSION08.SESSION08_06.notification.PushNotification;
import SESSION08.SESSION08_06.payment.MomoPayment;
import SESSION08.SESSION08_06.payment.PaymentMethod;

public class MobileAppFactory extends SalesChannelFactory {
    public DiscountStrategy createDiscountStrategy() {
        return new FirstTimeDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new MomoPayment();
    }

    public NotificationService createNotificationService() {
        return new PushNotification();
    }
}