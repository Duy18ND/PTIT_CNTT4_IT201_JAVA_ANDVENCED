package SESSION06.DEMO.Notifly_Wait;

public class Main {
    public static void main(String[] args) {
        // Tạo 1 cái kho dùng chung cho cả 2 luồng
        Notifly_wait khoHang = new Notifly_wait();

        // Luồng 1: Nhà sản xuất (Chỉ lo tạo dữ liệu)
        Thread producerThread = new Thread(() -> {
            String[] monHang = {"Iphone 15", "Macbook Pro", "Tai nghe Airpods"};
            for (String hang : monHang) {
                khoHang.produce(hang);
                try { Thread.sleep(1000); } catch (Exception e) {} // Chậm lại 1s cho dễ nhìn
            }
        });

        // Luồng 2: Người tiêu dùng (Chỉ lo lấy dữ liệu)
        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                khoHang.consume();
                try { Thread.sleep(2000); } catch (Exception e) {} // Lấy hàng chậm hơn sản xuất
            }
        });

        // Bắt đầu cuộc đua
        consumerThread.start();
        producerThread.start();
    }
}