package SESSION06.SESSION06_01;
import java.util.Random;

class BookingCounter implements Runnable {
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
        while (roomA.hasAvailableTickets() || roomB.hasAvailableTickets()) {
            TicketPool targetRoom = random.nextBoolean() ? roomA : roomB;
            Ticket ticket = targetRoom.sellTicket();
            if (ticket == null) {
                targetRoom = (targetRoom == roomA) ? roomB : roomA;
                ticket = targetRoom.sellTicket();
            }
            if (ticket != null) {
                soldCount++;
                System.out.println(counterName + " bán vé phòng " + targetRoom.getRoomName());
                System.out.println(counterName + " đã bán vé " + ticket.getTicketId());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}