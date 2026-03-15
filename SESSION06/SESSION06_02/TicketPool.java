package SESSION06.SESSION06_02;

import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets;
    private int totalCreated;

    public TicketPool(String roomName, List<Ticket> tickets) {
        this.roomName = roomName;
        this.tickets = tickets;
        this.totalCreated = tickets.size();
    }

    public String getRoomName() { return roomName; }

    public synchronized Ticket sellTicket() {
        for (Ticket t : tickets) {
            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }
        return null;
    }

    public synchronized boolean hasAvailableTickets() {
        for (Ticket t : tickets) {
            if (!t.isSold()) {
                return true;
            }
        }
        return false;
    }

    public synchronized int getRemainingCount() {
        int count = 0;
        for (Ticket t : tickets) {
            if (!t.isSold()) count++;
        }
        return count;
    }

    public synchronized void addTickets(int count) {
        for (int i = 1; i <= count; i++) {
            totalCreated++;
            String id = String.format("%s-%03d", roomName, totalCreated);
            tickets.add(new Ticket(id, roomName));
        }
    }
}