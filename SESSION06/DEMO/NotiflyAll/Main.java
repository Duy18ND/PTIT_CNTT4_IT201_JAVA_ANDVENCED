package SESSION06.DEMO.NotiflyAll;

public class Main {
    static void main(String[] args) {
        NotiflyAll queue = new NotiflyAll();

        //Khởi tạo 3 dữ liệu
        Thread c1 = new Thread(() -> queue.consumer("Consumer 1"));
        Thread c2 = new Thread(() -> queue.consumer("Consumer 2"));
        Thread c3 = new Thread(() -> queue.consumer("Consumer 3"));

        //Chạy
        c1.start();
        c2.start();
        c3.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(queue::product).start();
    }
}
