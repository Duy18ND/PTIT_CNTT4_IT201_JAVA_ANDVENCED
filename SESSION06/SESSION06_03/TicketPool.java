package SESSION06.SESSION06_03;

import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets;
    private int totalCreated;
    private boolean isSupplierDone = false;

    public TicketPool(String roomName, List<Ticket> tickets) {
        this.roomName = roomName;
        this.tickets = tickets;
        this.totalCreated = tickets.size();
    }

    public String getRoomName() { return roomName; }

    public synchronized void setSupplierDone() {
        this.isSupplierDone = true;
        notifyAll();
    }

    public synchronized boolean isFinished() {
        return isSupplierDone && !hasAvailableTickets();
    }

    public synchronized Ticket sellTicket(String counterName) {
        while (!hasAvailableTickets() && !isSupplierDone) {
            System.out.println(counterName + ": Hết vé phòng " + roomName + ", đang chờ...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Ticket t : tickets) {
            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }
        return null;
    }

    public synchronized void addTickets(int count) {
        for (int i = 1; i <= count; i++) {
            totalCreated++;
            String id = String.format("%s-%03d", roomName, totalCreated);
            tickets.add(new Ticket(id, roomName));
        }
        notifyAll();
    }

    public synchronized boolean hasAvailableTickets() {
        for (Ticket t : tickets) {
            if (!t.isSold()) return true;
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
}