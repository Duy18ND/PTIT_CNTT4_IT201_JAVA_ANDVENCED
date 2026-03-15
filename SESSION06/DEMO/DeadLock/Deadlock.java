package SESSION06.DEMO.DeadLock;

public class Deadlock {

    // Tạo một đối tượng Tài Khoản chung chung
    static class TaiKhoan {
        String tenTK;
        public TaiKhoan(String tenTK) {
            this.tenTK = tenTK;
        }
    }

    public static void main(String[] args) {
        // Có 2 tài khoản trong hệ thống
        TaiKhoan tkA = new TaiKhoan("Tài Khoản A");
        TaiKhoan tkB = new TaiKhoan("Tài Khoản B");

        // LUỒNG 1: Khách hàng A chuyển tiền cho Khách hàng B
        Thread giaoDich1 = new Thread(() -> {
            // Bước 1: Khóa tài khoản A (để trừ tiền)
            synchronized (tkA) {
                System.out.println("Giao dịch 1: Đã khóa " + tkA.tenTK + ", đang chuẩn bị trừ tiền...");

                // Cố tình cho luồng ngủ 1 chút để ép Deadlock xảy ra
                try { Thread.sleep(100); } catch (Exception e) {}

                System.out.println("Giao dịch 1: Đang chờ khóa " + tkB.tenTK + " để cộng tiền vào...");
                // Bước 2: Khóa tài khoản B (để cộng tiền)
                synchronized (tkB) {
                    System.out.println("Giao dịch 1: Chuyển tiền từ A sang B thành công!");
                }
            }
        });

        // LUỒNG 2: Cùng lúc đó, Khách hàng B lại chuyển tiền cho Khách hàng A
        Thread giaoDich2 = new Thread(() -> {
            // Bước 1: Khóa tài khoản B (để trừ tiền)
            synchronized (tkB) {
                System.out.println("Giao dịch 2: Đã khóa " + tkB.tenTK + ", đang chuẩn bị trừ tiền...");

                // Ngủ một chút để luồng 1 kịp khóa tài khoản A
                try { Thread.sleep(100); } catch (Exception e) {}

                System.out.println("Giao dịch 2: Đang chờ khóa " + tkA.tenTK + " để cộng tiền vào...");
                // Bước 2: Khóa tài khoản A (để cộng tiền)
                synchronized (tkA) {
                    System.out.println("Giao dịch 2: Chuyển tiền từ B sang A thành công!");
                }
            }
        });

        // Kích hoạt thảm họa
        giaoDich1.start();
        giaoDich2.start();
    }
}