package SESSION08.SESSION08_06.factory;

import SESSION08.SESSION08_06.discount.DiscountStrategy;
import SESSION08.SESSION08_06.discount.WebsiteDiscount;
import SESSION08.SESSION08_06.notification.EmailNotification;
import SESSION08.SESSION08_06.notification.NotificationService;
import SESSION08.SESSION08_06.payment.CreditCardPayment;
import SESSION08.SESSION08_06.payment.PaymentMethod;

public class WebsiteFactory extends SalesChannelFactory {
    public DiscountStrategy createDiscountStrategy() {
        return new WebsiteDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }

    public NotificationService createNotificationService() {
        return new EmailNotification();
    }
}