package SESSION07.SESSION07_03;

class CODPayment implements CODPayable {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Xử lý thanh toán COD: %,.0f - Thành công\n", amount);
    }
}