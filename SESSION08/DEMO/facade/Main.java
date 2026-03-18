package SESSION08.DEMO.facade;

// =========================================================
// PHẦN 1: CÁC HỆ THỐNG CON PHỨC TẠP (Subsystems)
// (Đây là đống logic rườm rà phía sau mà mình không muốn Client đụng vào)
// =========================================================

class InventoryService {
    public void checkStock(String product) {
        System.out.println(" - [Kho bãi]: Đã kiểm tra còn hàng cho " + product);
    }
}

class PaymentService {
    public void deductMoney(String account) {
        System.out.println(" - [Ngân hàng]: Đã trừ tiền từ tài khoản " + account);
    }
}

class EmailService {
    public void sendMail(String email) {
        System.out.println(" - [Email]: Đã gửi biên lai xác nhận tới " + email);
    }
}

// =========================================================
// PHẦN 2: LỚP FACADE (Cô tiếp tân)
// (Gom toàn bộ sự phức tạp ở Phần 1 vào đây, giấu nhẹm đi)
// =========================================================

class OrderFacade {
    private InventoryService inventory;
    private PaymentService payment;
    private EmailService email;

    public OrderFacade() {
        this.inventory = new InventoryService();
        this.payment = new PaymentService();
        this.email = new EmailService();
    }

    // Nút bấm thần kỳ: Khách hàng chỉ cần gọi hàm này là xong hết thủ tục
    public void placeOrder(String product, String account, String mailAddress) {
        inventory.checkStock(product);
        payment.deductMoney(account);
        email.sendMail(mailAddress);
        System.out.println(" -> ĐẶT HÀNG THÀNH CÔNG (Qua Facade)!\n");
    }
}

// =========================================================
// PHẦN 3: SO SÁNH TRỰC TIẾP TRONG HÀM MAIN (Client)
// =========================================================

public class Main {
    public static void main(String[] args) {

        System.out.println("========== KỊCH BẢN 1: LÚC CHƯA CÓ FACADE ==========");
        System.out.println("Client phải tự đi 'gõ cửa' từng phòng ban, tự nhớ thứ tự gọi hàm:");

        // Nhược điểm: Bị Tight Coupling (phụ thuộc chặt) vào 3 class con.
        // Lỡ gọi hàm gửi Email trước khi Trừ tiền là toang!
        InventoryService inv = new InventoryService();
        PaymentService pay = new PaymentService();
        EmailService mail = new EmailService();

        inv.checkStock("Bàn phím cơ");
        pay.deductMoney("MOMO-9999");
        mail.sendMail("khach@gmail.com");
        System.out.println(" -> ĐẶT HÀNG THÀNH CÔNG (Tự làm thủ công)!\n");


        System.out.println("========== KỊCH BẢN 2: SAU KHI DÙNG FACADE ==========");
        System.out.println("Client thảnh thơi gọi 'Cô tiếp tân', mọi việc để cô ấy lo:");

        // Ưu điểm: Loose Coupling (Khớp nối lỏng).
        // Client CHỈ BIẾT ĐÚNG 1 CLASS là OrderFacade, hoàn toàn mù tịt về Kho bãi hay Ngân hàng.
        OrderFacade shopeeCheckout = new OrderFacade();
        shopeeCheckout.placeOrder("Bàn phím cơ", "MOMO-9999", "khach@gmail.com");
    }
}