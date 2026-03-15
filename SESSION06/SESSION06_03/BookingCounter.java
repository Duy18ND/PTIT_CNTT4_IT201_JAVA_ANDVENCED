package SESSION06.SESSION06_03;

import java.util.Random;

public class BookingCounter implements Runnable {
    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private int soldCount;

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
        this.soldCount = 0;
    }

    public int getSoldCount() { return soldCount; }

    @Override
    public void run() {
        Random random = new Random();

        while (!roomA.isFinished() || !roomB.isFinished()) {
            TicketPool targetRoom;

            if (roomA.isFinished()) {
                targetRoom = roomB;
            } else if (roomB.isFinished()) {
                targetRoom = roomA;
            } else {
                targetRoom = random.nextBoolean() ? roomA : roomB;
            }

            if (targetRoom.isFinished()) break;

            Ticket ticket = targetRoom.sellTicket(counterName);

            if (ticket != null) {
                soldCount++;
                System.out.println(counterName + " bán vé phòng " + targetRoom.getRoomName());
                System.out.println(counterName + " đã bán vé " + ticket.getTicketId());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}