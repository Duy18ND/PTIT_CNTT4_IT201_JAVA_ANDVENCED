package SESSION06.SESSION06_04;

public class BookingCounter implements Runnable {
    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private int soldCount;
    private boolean reverseLock;

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB, boolean reverseLock) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
        this.reverseLock = reverseLock;
        this.soldCount = 0;
    }

    public int getSoldCount() { return soldCount; }

    public boolean sellCombo() {
        TicketPool firstLock = reverseLock ? roomB : roomA;
        TicketPool secondLock = reverseLock ? roomA : roomB;

        synchronized (firstLock) {
            Ticket ticket1 = firstLock.sellTicket();
            if (ticket1 != null) {
                System.out.println(counterName + ": Đã lấy vé " + ticket1.getTicketId());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(counterName + ": Đang chờ vé " + secondLock.getRoomName() + "...");

                synchronized (secondLock) {
                    Ticket ticket2 = secondLock.sellTicket();
                    if (ticket2 != null) {
                        System.out.println(counterName + " bán combo thành công: " + ticket1.getTicketId() + " & " + ticket2.getTicketId());
                        soldCount += 2;
                        return true;
                    } else {
                        ticket1.setSold(false);
                        System.out.println(counterName + ": Hết vé phòng " + secondLock.getRoomName() + ", bán combo thất bại");
                        return false;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void run() {
        while (roomA.hasAvailableTickets() && roomB.hasAvailableTickets()) {
            sellCombo();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}