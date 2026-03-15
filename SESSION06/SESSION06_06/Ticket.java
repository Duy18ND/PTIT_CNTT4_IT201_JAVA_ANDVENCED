package SESSION06.SESSION06_06;

public class Ticket {
    private String id;
    private String roomName;
    private boolean isSold;
    private long price;

    public Ticket(String id, String roomName, long price) {
        this.id = id;
        this.roomName = roomName;
        this.price = price;
        this.isSold = false;
    }

    public String getId() { return id; }
    public String getRoomName() { return roomName; }
    public boolean isSold() { return isSold; }
    public void setSold(boolean sold) { this.isSold = sold; }
    public long getPrice() { return price; }
}