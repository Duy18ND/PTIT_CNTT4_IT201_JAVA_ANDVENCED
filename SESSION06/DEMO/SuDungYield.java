package SESSION06.DEMO;

public class SuDungYield {
    // Luồng 1: Chạy ích kỷ, không nhường ai
    static class IchKyThread extends Thread {
        public IchKyThread() { super("Luồng Ích Kỷ"); }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("🏃 " + this.getName() + " đang chạy bước " + i);
            }
        }
    }

    // Luồng 2: Tốt bụng, vừa chạy vừa nhường
    static class TotBungThread extends Thread {
        public TotBungThread() { super("Luồng Tốt Bụng"); }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("🙏 " + this.getName() + " đang chạy bước " + i);

                // Gọi yield() để nhường CPU cho luồng khác
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        IchKyThread luong1 = new IchKyThread();
        TotBungThread luong2 = new TotBungThread();

        luong1.start();
        luong2.start();
    }
}