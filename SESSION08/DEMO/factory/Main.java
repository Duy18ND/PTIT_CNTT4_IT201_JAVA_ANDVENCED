package SESSION08.DEMO.factory;

public class Main {
    public static void main(String[] args) {

        // 1. TÁCH RỜI PHỤ THUỘC (Decoupling) & ỦY QUYỀN (Delegation):
        // Tuyệt đối KHÔNG dùng 'new StudentCard()' hay 'new TeacherCard()' ở đây.
        // Giao phó 100% trách nhiệm "đẻ" object cho nhà máy CardFactory lo.

        // 2. LẬP TRÌNH HƯỚNG GIAO DIỆN (Code to an Interface):
        // Khai báo bằng Interface (LibraryCard), giấu kín (ẩn) đi Concrete Class thật sự.
        LibraryCard card1 = CardFactory.getCard("STUDENT");

        // 3. TÍNH ĐA HÌNH (Polymorphism):
        // Nhờ dùng Interface, chỉ cần gọi 1 hàm chung, hệ thống tự biết chạy logic của thẻ Sinh Viên.
        card1.showPrivileges();

        // 4. PLUG & PLAY (Tuân thủ OCP):
        // Thử nghiệm gọi một loại thẻ khác. Nếu ngày mai có thêm thẻ VIP, file Main này
        // hoàn toàn KHÔNG PHẢI SỬA BẤT KỲ DÒNG CODE NÀO, chỉ cần truyền vào chữ "VIP".
        LibraryCard card2 = CardFactory.getCard("TEACHER");
        card2.showPrivileges();
    }
}