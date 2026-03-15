package SESSION06.SESSION06_05;

import java.util.List;
import java.util.Random;

public class BookingCounter implements Runnable {
    private String counterName;
    private List<TicketPool> pools;
    private int soldCount;

    public BookingCounter(String counterName, List<TicketPool> pools) {
        this.counterName = counterName;
        this.pools = pools;
        this.soldCount = 0;
    }

    public int getSoldCount() { return soldCount; }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            boolean allFinished = true;
            for (TicketPool p : pools) {
                if (!p.isFinished()) allFinished = false;
            }
            if (allFinished) break;

            // Random chọn phòng
            TicketPool targetPool = pools.get(random.nextInt(pools.size()));
            if (targetPool.isFinished()) continue;

            // Random khách hàng yêu cầu vé VIP hoặc Thường
            boolean isVIPRequest = random.nextBoolean();

            Ticket heldTicket = targetPool.holdTicket(isVIPRequest, counterName);

            if (heldTicket != null) {
                // Mô phỏng thời gian khách suy nghĩ/nhập mã OTP
                // 70% khách thanh toán nhanh (3s) -> Thành công
                // 30% khách rề rà (6s) -> Bị hủy vé
                int thinkTime = random.nextInt(100) < 70 ? 3000 : 6000;

                try {
                    Thread.sleep(thinkTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                boolean isPaid = targetPool.sellHeldTicket(heldTicket, counterName);
                if (isPaid) {
                    soldCount++;
                }
            } else {
                try { Thread.sleep(50); } catch (InterruptedException e) {}
            }
        }
    }
}