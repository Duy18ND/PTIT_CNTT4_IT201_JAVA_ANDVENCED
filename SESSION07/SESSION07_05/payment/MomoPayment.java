package SESSION07.SESSION07_05.payment;

public class MomoPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Xử lý thanh toán MoMo: %,.0f - Thành công\n", amount);
    }
}