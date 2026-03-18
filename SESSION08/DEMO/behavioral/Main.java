package SESSION08.DEMO.behavioral;

// =========================================================
// KỊCH BẢN 1: CHƯA DÙNG STRATEGY (Spaghetti if-else)
// =========================================================
class BadOrderCalculator {
    public double calculateTotal(double amount, String discountType) {
        // ❌ TỬ HUYỆT: Mọi logic nhét hết vào 1 hàm.
        // Lần sau phòng Marketing nghĩ ra 10 loại giảm giá mới là cái hàm này dài cả ngàn dòng.
        // Cực kỳ dễ sinh bug và vi phạm OCP (Đục code cũ ra sửa).
        if (discountType.equals("VIP")) {
            return amount * 0.8;
        } else if (discountType.equals("FESTIVE")) {
            return amount - 50000;
        } else {
            return amount;
        }
    }
}

// =========================================================
// KỊCH BẢN 2: ĐÃ ÁP DỤNG STRATEGY (Tách rời thuật toán)
// =========================================================

// 1. Kế hoạch tác chiến chung (Strategy Interface)
interface DiscountStrategy {
    double applyDiscount(double amount);
}

// 2. Các "Chiến lược" cụ thể được bóc tách ra thành từng class riêng biệt
// Nhờ vậy, sửa chiến lược này không bao giờ làm chết chiến lược kia (SRP)
class VipDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) { return amount * 0.8; }
}

class FestiveDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) { return amount - 50000; }
}

class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) { return amount; }
}

// 3. Class sử dụng chiến lược (Context)
class GoodOrderCalculator {
    private DiscountStrategy strategy;

    // ĐIỂM ĂN TIỀN: Cho phép tráo đổi chiến lược linh hoạt ngay cả khi phần mềm đang chạy (Runtime)
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateTotal(double amount) {
        // Hoàn toàn không có if-else! Trách nhiệm tính toán bị đùn đẩy hết cho cái Strategy hiện tại.
        return strategy.applyDiscount(amount);
    }
}

// =========================================================
// PHẦN 3: HÀM MAIN (So sánh trực tiếp)
// =========================================================
public class Main {
    public static void main(String[] args) {
        double cartAmount = 500000; // Đơn hàng 500k

        System.out.println("--- 1. LÚC CHƯA CÓ STRATEGY ---");
        BadOrderCalculator badCalc = new BadOrderCalculator();
        System.out.println("Khách VIP phải trả: " + badCalc.calculateTotal(cartAmount, "VIP"));

        System.out.println("\n--- 2. LÚC ĐÃ ÁP DỤNG STRATEGY ---");
        GoodOrderCalculator goodCalc = new GoodOrderCalculator();

        // Cắm "Băng đạn" (Chiến lược) VIP vào
        goodCalc.setStrategy(new VipDiscount());
        System.out.println("Khách VIP phải trả: " + goodCalc.calculateTotal(cartAmount));

        // Tráo "Băng đạn" Lễ Tết ngay lập tức (Runtime Swap) mà không cần tạo object máy tính mới
        goodCalc.setStrategy(new FestiveDiscount());
        System.out.println("Khách mua ngày Lễ phải trả: " + goodCalc.calculateTotal(cartAmount));

        // LỢI ÍCH KHỦNG KHIẾP: Ngày mai sếp ra mắt thẻ "Sinh Viên",
        // bạn chỉ cần tạo class StudentDiscount, file GoodOrderCalculator hoàn toàn KHÔNG CẦN SỬA 1 DÒNG (Tuân thủ tuyệt đối OCP).
    }
}