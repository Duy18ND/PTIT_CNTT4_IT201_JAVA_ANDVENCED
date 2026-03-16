package SESSION07.SESSION07_03;

class CreditCardPayment implements CardPayable {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Xử lý thanh toán thẻ tín dụng: %,.0f - Thành công\n", amount);
    }
}
