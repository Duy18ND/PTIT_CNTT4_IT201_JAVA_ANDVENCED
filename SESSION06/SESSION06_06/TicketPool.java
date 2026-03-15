package SESSION06.SESSION06_06;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets;
    private int initialCount;
    private int soldCount;
    private long totalRevenue;

    public TicketPool(String roomName) {
        this.roomName = roomName;
        this.tickets = new ArrayList<>();
        this.soldCount = 0;
        this.totalRevenue = 0;
    }

    public String getRoomName() { return roomName; }
    public int getInitialCount() { return initialCount; }
    public int getSoldCount() { return soldCount; }
    public long getTotalRevenue() { return totalRevenue; }

    public synchronized void addTickets(int count) {
        for (int i = 1; i <= count; i++) {
            initialCount++;
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", initialCount), roomName, 250000));
        }
    }

    public synchronized Ticket sellTicket() {
        for (Ticket t : tickets) {
            if (!t.isSold()) {
                t.setSold(true);
                soldCount++;
                totalRevenue += t.getPrice();
                return t;
            }
        }
        return null;
    }

    public synchronized boolean hasTickets() {
        return soldCount < initialCount;
    }
}