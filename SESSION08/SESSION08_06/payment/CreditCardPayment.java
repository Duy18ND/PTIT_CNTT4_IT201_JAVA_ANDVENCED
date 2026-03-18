package SESSION08.SESSION08_06.payment;

public class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Xử lý thanh toán thẻ tín dụng: " + amount);
    }
}