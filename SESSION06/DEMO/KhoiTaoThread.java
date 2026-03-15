package SESSION06.DEMO;

import SESSION06.SESSION06_01.Main;
public class KhoiTaoThread {
    //Cách 1 Extends Cách này không thể dùng đa kế thừa
    public static class Thread1 extends Thread {
        @Override
        public void run() {
            //Logic ở đây
        }
    }

    //Cách 2
    public static class Thread2 implements Runnable {
        @Override
        public void run() {
            //Logic ở đây
            System.out.println("a");
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
