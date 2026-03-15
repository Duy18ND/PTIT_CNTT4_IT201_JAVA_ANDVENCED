package SESSION06.DEMO;

public class SuDungJoin  {
    static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            for (int i=0; i< 5; i++){
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        worker.start();
        worker.join(); //Tác dụng là trong thời gian Thread chạy thì join() -> nó bảo main đợi Thread xong mới tới logic khác
        //Nếu khong có join() sẽ in hello ra trước rồi mới đếm số 1,2,3,4
        System.out.println("Hello");
    }
}
