package SESSION07.SESSION07_05.payment;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Xử lý thanh toán Thẻ tín dụng: %,.0f - Thành công\n", amount);
    }
}