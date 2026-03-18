package SESSION08.SESSION08_06.payment;

public class CODPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toán khi nhận hàng: " + amount);
    }
}