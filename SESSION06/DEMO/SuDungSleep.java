package SESSION06.DEMO;

public class SuDungSleep {
    //Cách 1 Extends Cách này không thể dùng đa kế thừa
    public static class Thread1 extends Thread {
        @Override
        public void run() {
            //Logic ở đây
            for (int i = 3; i > 0; --i) {
                System.out.println("Đếm số: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //Cách 2
    public static class Thread2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("Chúc mừng bạn: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        //Cách 1:

        Thread1 thread1 = new Thread1();
        thread1.start();
        System.out.println("Hoàn thành Thread 1");

        //Cách 2:
        Thread2 runnalTime = new Thread2();
        Thread thread2 = new Thread(runnalTime);
        thread2.start();
        System.out.println("Hoàn thành Thread2");
    }
}
