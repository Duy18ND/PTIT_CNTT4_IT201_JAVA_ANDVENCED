package SESSION08.DEMO.adapter;
import SESSION08.DEMO.adapter.ModernPayment;

// 1. Adapter phải "tuân thủ" chuẩn mới (implements Target)
public class MomoAdapter implements ModernPayment {

    // 2. Chứa bên trong nó là cái thư viện cũ (Adaptee)
    private LegacyMomoAPI legacyMomo;

    public MomoAdapter(LegacyMomoAPI legacyMomo) {
        this.legacyMomo = legacyMomo;
    }

    // 3. Viết lại hàm của chuẩn mới, nhưng "lén" gọi hàm của thư viện cũ bên trong
    @Override
    public void pay(double amount) {
        // ĐỔI KIỂU DỮ LIỆU: Chuyển double thành String để thằng API cũ nó chịu đọc
        String convertedAmount = String.valueOf(amount);

        // Gọi hàm của thư viện cũ
        legacyMomo.processMomoTransaction(convertedAmount);
    }
}