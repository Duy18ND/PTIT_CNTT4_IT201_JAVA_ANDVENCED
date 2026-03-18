package SESSION08.SESSION08_06.factory;

import SESSION08.SESSION08_06.discount.DiscountStrategy;
import SESSION08.SESSION08_06.discount.MemberDiscount;
import SESSION08.SESSION08_06.notification.NotificationService;
import SESSION08.SESSION08_06.notification.PrintReceipt;
import SESSION08.SESSION08_06.payment.CODPayment;
import SESSION08.SESSION08_06.payment.PaymentMethod;

public class POSFactory extends SalesChannelFactory {
    public DiscountStrategy createDiscountStrategy() {
        return new MemberDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new CODPayment();
    }

    public NotificationService createNotificationService() {
        return new PrintReceipt();
    }
}