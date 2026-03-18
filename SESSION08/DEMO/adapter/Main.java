package SESSION08.DEMO.adapter;

public class Main {
    public static void main(String[] args) {

        // 1. BỐI CẢNH/VẤN ĐỀ (The Problem):
        // Chúng ta có một thư viện cũ (Adaptee) đã được test kỹ và đang chạy tốt.
        // Nhưng nó bị BẤT ĐỒNG BỘ (Incompatible) với hệ thống hiện tại.
        // (API cũ đòi String, nhưng hệ thống mới lại bắt dùng double).
        LegacyMomoAPI oldMomoApi = new LegacyMomoAPI();

        // 2. ÁP DỤNG ADAPTER (The Solution):
        // Thay vì đập đi viết lại class cũ (rất rủi ro và mất thời gian),
        // ta tạo ra một "Thông dịch viên" (Adapter) để BỌC (Wrap) cái class cũ lại.
        // Cục Adapter này cắm vừa khít với chuẩn mới của hệ thống (ModernPayment).
        ModernPayment paymentGateway = new MomoAdapter(oldMomoApi);

        // 3. MỤC ĐÍCH & CÁCH SỬ DỤNG (Usage & Benefit):
        // Client (hàm main) cứ ung dung gọi hàm theo chuẩn mới (truyền số double).
        // Adapter ở giữa sẽ tự động hứng lấy số double này, ép kiểu sang String,
        // rồi lén nhét vào cho thư viện cũ xử lý.
        // -> KẾT QUẢ: Tái sử dụng (Reuse) được code cũ mà Client KHÔNG CẦN THAY ĐỔI thói quen.
        paymentGateway.pay(150000.50);
    }
}