package SESSION07.SESSION07_05.payment;

public class VNPayPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Xử lý thanh toán VNPay: %,.0f - Thành công\n", amount);
    }
}