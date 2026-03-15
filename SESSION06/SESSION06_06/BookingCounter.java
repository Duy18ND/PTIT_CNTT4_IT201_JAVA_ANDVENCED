package SESSION06.SESSION06_06;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.List;
import java.util.Random;

class BookingCounter implements Runnable {
    private String name;
    private List<TicketPool> pools;
    private SimulationManager manager;

    public BookingCounter(String name, List<TicketPool> pools, SimulationManager manager) {
        this.name = name;
        this.pools = pools;
        this.manager = manager;
    }

    @Override
    public void run() {
        System.out.println(name + " bắt đầu bán vé...");
        Random random = new Random();

        while (manager.isRunning()) {
            manager.checkPause();

            boolean allEmpty = true;
            for (TicketPool p : pools) {
                if (p.hasTickets()) allEmpty = false;
            }
            if (allEmpty) {
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
                continue;
            }

            TicketPool target = pools.get(random.nextInt(pools.size()));
            Ticket ticket = target.sellTicket();

            if (ticket != null) {
                System.out.println(name + " đã bán vé: " + ticket.getId());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

class DeadlockDetector {
    public static void checkDeadlock() {
        System.out.println("Đang quét deadlock từ JVM...");
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();

        if (deadlockedThreads != null && deadlockedThreads.length > 0) {
            System.out.println("PHÁT HIỆN DEADLOCK! Số lượng thread bị kẹt: " + deadlockedThreads.length);
            ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(deadlockedThreads);
            for (ThreadInfo info : threadInfos) {
                System.out.println("- Thread [" + info.getThreadName() + "] đang chờ khóa bị giữ bởi [" + info.getLockOwnerName() + "]");
            }
        } else {
            System.out.println("Không phát hiện deadlock. Hệ thống luồng đang luân chuyển mượt mà.");
        }
    }
}