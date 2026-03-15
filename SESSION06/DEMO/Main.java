package SESSION06.DEMO;

/**
 * ==============================================================================================
 * TỔNG QUAN VỀ THREAD (LUỒNG) TRONG JAVA
 * ==============================================================================================
 * 1. Thread là gì?
 * - Thread (Luồng) là một đơn vị thực thi nhỏ nhất trong một chương trình.
 * - Mặc định, mỗi chương trình Java có ít nhất 1 luồng chạy chính, gọi là Main Thread.
 * - Đa luồng (Multithreading) là việc cho phép nhiều luồng chạy ĐỒNG THỜI (hoặc luân phiên
 * cực nhanh) để tận dụng tối đa sức mạnh của CPU nhiều nhân.
 * * 2. Ứng dụng thực tế:
 * - Vừa tải file trên mạng, vừa hiển thị thanh tiến trình (progress bar).
 * - Game: Một luồng xử lý hình ảnh, một luồng phát âm thanh, một luồng nhận phím bấm.
 * * 3. Hai cách tạo Thread:
 * - Cách 1: Kế thừa class `Thread` (extends Thread).
 * - Cách 2: Triển khai interface `Runnable` (implements Runnable) -> Khuyên dùng vì Java
 * chỉ cho đa kế thừa interface, không cho đa kế thừa class.
 * ==============================================================================================
 */

public class Main {

    // --- TẠO LUỒNG BẰNG CÁCH 1: EXTENDS THREAD ---
    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name); // Đặt tên cho luồng để dễ nhận diện
        }

        /**
         * MÔ TẢ: Phương thức run()
         * - Tác dụng: Nơi chứa toàn bộ "công việc" mà luồng này sẽ thực hiện.
         * - Lưu ý sống còn: KHÔNG BAO GIỜ gọi trực tiếp myThread.run() ở hàm main.
         * Nếu gọi trực tiếp, nó chỉ chạy như một hàm bình thường trên luồng Main,
         * chứ không hề sinh ra luồng mới.
         */
        @Override
        public void run() {
            System.out.println("🚀 [" + this.getName() + "] đang bắt đầu làm việc!");
            for (int i = 1; i <= 3; i++) {
                System.out.println("   -> [" + this.getName() + "] đang xử lý bước " + i);
                try {
                    /**
                     * MÔ TẢ: Thread.sleep(milliseconds)
                     * - Tác dụng: Bắt luồng hiện tại "ngủ" (tạm dừng) trong một khoảng thời gian.
                     * - Ví dụ: Cho luồng ngủ 1000ms (1 giây) để mô phỏng việc đang tải dữ liệu.
                     * - Trạng thái: Chuyển luồng sang trạng thái TIMED_WAITING.
                     */
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Xảy ra nếu luồng đang ngủ mà bị một luồng khác gọi lệnh interrupt() "đánh thức" thô bạo.
                    System.out.println("⚠️ [" + this.getName() + "] bị đánh thức đột ngột!");
                }
            }
            System.out.println("✅ [" + this.getName() + "] đã hoàn thành công việc và kết thúc (Dead).");
        }
    }

    public static void main(String[] args) {
        // Lấy tên của luồng chính đang chạy đoạn code này
        String mainThreadName = Thread.currentThread().getName();
        System.out.println("🎬 Bắt đầu chương trình bằng luồng chính: " + mainThreadName);
        System.out.println("--------------------------------------------------");

        // Khởi tạo 2 luồng (Lúc này luồng mới chỉ ở trạng thái NEW - Mới sinh ra, chưa chạy)
        MyThread luong1 = new MyThread("Luồng Tải Nhạc");
        MyThread luong2 = new MyThread("Luồng Tải Phim");

        /**
         * MÔ TẢ: Phương thức start()
         * - Tác dụng: Kích hoạt luồng. Sinh ra một không gian thực thi (Call Stack) hoàn toàn mới.
         * - Cách hoạt động: Nó sẽ tự động gọi hàm run() ở bên trong cái không gian mới đó.
         * - Trạng thái: Chuyển luồng từ NEW sang RUNNABLE (Sẵn sàng chạy, đợi CPU xếp lịch).
         * - Lỗi thường gặp: Một luồng chỉ được start() đúng 1 lần. Gọi lần 2 sẽ ném lỗi IllegalThreadStateException.
         */
        luong1.start();
        luong2.start();

        System.out.println("⚡ Luồng chính (" + mainThreadName + ") đã ra lệnh cho 2 luồng con chạy.");
        System.out.println("⚡ Luồng chính tiếp tục làm việc của nó mà không cần đợi 2 luồng kia...");

        try {
            /**
             * MÔ TẢ: Phương thức join()
             * - Tác dụng: Bắt luồng HIỆN TẠI (ở đây là luồng Main) phải "dừng hình" lại để
             * chờ luồng được gọi (luong1, luong2) chạy xong rồi mới được đi tiếp.
             * - Ví dụ thực tế: Bạn giao việc cho 2 nhân viên (luong1, luong2). Bạn (Main) phải
             * đợi cả 2 đứa làm xong thì mới đi nộp báo cáo tổng kết được.
             */
            luong1.join();
            luong2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------------------------------");
        System.out.println("🏁 Tất cả các luồng con đã hoàn thành. Luồng chính (" + mainThreadName + ") kết thúc chương trình.");
    }
}