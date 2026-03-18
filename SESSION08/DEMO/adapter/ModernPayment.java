package SESSION08.DEMO.adapter;
// Hệ thống mới của chúng ta chỉ chấp nhận hàm pay() với tham số là số thực (double)
public interface ModernPayment {
    void pay(double amount);
}