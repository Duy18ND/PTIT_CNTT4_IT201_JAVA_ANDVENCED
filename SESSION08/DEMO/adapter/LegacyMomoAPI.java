package SESSION08.DEMO.adapter;

// Đây là class của bên thứ 3 (Ví dụ API MoMo cũ).
// KHÔNG THỂ SỬA code trong này. Nó lại bắt truyền vào chuỗi (String) thay vì số.
public class LegacyMomoAPI {
    public void processMomoTransaction(String amountInVND) {
        System.out.println("Đang xử lý thanh toán MoMo (API cũ) với số tiền: " + amountInVND + " VNĐ");
    }
}