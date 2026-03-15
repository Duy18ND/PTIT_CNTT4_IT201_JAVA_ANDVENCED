package SESSION06.DEMO.Notifly_Wait;

public class Notifly_wait {
        private String data;
        // Cờ báo hiệu:
        // false = Kho trống (Sẵn sàng cho Producer tạo)
        // true  = Kho có hàng (Sẵn sàng cho Consumer lấy)
        private boolean hasData = false;

        /**
         * PHƯƠNG THỨC 1: TẠO DỮ LIỆU (NHÀ SẢN XUẤT)
         * Phải có 'synchronized' vì ta đang thao tác trên biến dùng chung (data, hasData)
         */
        public synchronized void produce(String value) {
            // Bước 1: Kiểm tra điều kiện chờ
            // Nếu kho ĐÃ CÓ HÀNG (hasData == true), Producer phải dừng lại chờ Consumer lấy đi
            while (hasData) {
                try {
                    System.out.println("📦 Kho đã đầy, Nhà sản xuất đi ngủ...");
                    wait(); // Đi ngủ và TẠM THỜI NHẢ CHÌA KHÓA (lock) ra cho luồng khác vào
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Bước 2: Sản xuất dữ liệu
            data = value;
            System.out.println("🏭 Nhà sản xuất vừa tạo ra: " + data);

            // Bước 3: Cập nhật trạng thái và Đánh thức
            hasData = true; // Đánh dấu kho đã có hàng
            notify(); // Đánh thức Consumer (nếu nó đang ngủ) dậy để lấy hàng
            // Lưu ý: Nếu có nhiều luồng Consumer đang ngủ, dùng notifyAll() để đánh thức tất cả.
        }

        /**
         * PHƯƠNG THỨC 2: LẤY DỮ LIỆU (NGƯỜI TIÊU DÙNG)
         */
        public synchronized void consume() {
            // Bước 1: Kiểm tra điều kiện chờ
            // Nếu kho TRỐNG (hasData == false), Consumer phải đứng chờ
            while (!hasData) {
                try {
                    System.out.println("🛒 Kho trống, Người tiêu dùng ngồi chờ...");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Bước 2: Lấy dữ liệu
            System.out.println("✅ Người tiêu dùng vừa mua: " + data);

            // Bước 3: Cập nhật trạng thái và Đánh thức
            hasData = false; // Đánh dấu kho đã trống
            notify(); // Đánh thức Producer (nếu đang ngủ) dậy để sản xuất tiếp
        }
    }