package SESSION06.DEMO.NotiflyAll;

public class NotiflyAll {
    private boolean isCheck = false;

    public synchronized void product(){
        System.out.println("Product khởi tạo dữ liệu");
        isCheck = true;

        notifyAll(); //Dánh thức tất cả các Thread
    }

    public synchronized void consumer(String name){
        try {
            while (!isCheck){
                System.out.println("Đang chờ");
                wait();
            }
            System.out.println("Nhận được dữ liệu: "+ name);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
