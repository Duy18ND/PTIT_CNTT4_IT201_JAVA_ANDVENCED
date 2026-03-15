package SESSION06.SESSION06_05;

import java.util.List;

public class TimeoutManager implements Runnable {
    private List<TicketPool> pools;

    public TimeoutManager(List<TicketPool> pools) {
        this.pools = pools;
    }

    @Override
    public void run() {
        while (true) {
            boolean allFinished = true;

            for (TicketPool pool : pools) {
                pool.releaseExpiredTickets();
                if (!pool.isFinished()) {
                    allFinished = false;
                }
            }

            if (allFinished) break;

            try {
                Thread.sleep(1000); // Quét hệ thống 1 giây/lần
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("TimeoutManager: Tất cả vé đã bán hết, chốt sổ hệ thống.");
    }
}