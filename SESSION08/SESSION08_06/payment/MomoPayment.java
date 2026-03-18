package SESSION08.SESSION08_06.payment;

public class MomoPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Xử lý thanh toán MoMo: " + amount);
    }
}
