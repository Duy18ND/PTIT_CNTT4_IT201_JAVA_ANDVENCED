package SESSION07.SESSION07_03;

class MomoPayment implements EWalletPayable {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Xử lý thanh toán MoMo: %,.0f - Thành công\n", amount);
    }
}
