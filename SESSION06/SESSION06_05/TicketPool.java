package SESSION06.SESSION06_05;

import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets;

    public TicketPool(String roomName, List<Ticket> tickets) {
        this.roomName = roomName;
        this.tickets = tickets;
    }

    public String getRoomName() { return roomName; }

    public synchronized Ticket holdTicket(boolean requestVIP, String counterName) {
        while (true) {
            boolean allSold = true;
            boolean hasHeld = false;
            Ticket selected = null;

            // Kiểm tra trạng thái chung của kho
            for (Ticket t : tickets) {
                if (!t.isSold()) allSold = false;
                if (!t.isSold() && t.isHeld()) hasHeld = true;
            }

            if (allSold) return null;

            // Quét lần 1: Ưu tiên tìm vé khớp với yêu cầu VIP
            for (Ticket t : tickets) {
                if (!t.isSold() && !t.isHeld() && (requestVIP == t.isVIP())) {
                    selected = t;
                    break;
                }
            }

            // Quét lần 2: Nếu không có vé khớp, lấy bừa vé còn trống
            if (selected == null) {
                for (Ticket t : tickets) {
                    if (!t.isSold() && !t.isHeld()) {
                        selected = t;
                        break;
                    }
                }
            }

            // Nếu lấy được vé -> Tiến hành giữ chỗ 5 giây
            if (selected != null) {
                selected.setHeld(true);
                selected.setHoldExpiryTime(System.currentTimeMillis() + 5000);
                String type = selected.isVIP() ? "VIP" : "Thường";
                System.out.println(counterName + ": Đã giữ vé " + selected.getTicketId() + " (" + type + "). Vui lòng thanh toán trong 5s");
                return selected;
            }

            // Nếu kho vẫn còn vé nhưng tất cả đang bị HOLD -> Đi ngủ chờ TimeoutManager đòi lại vé
            if (hasHeld) {
                System.out.println(counterName + ": Các vé phòng " + roomName + " đang được giữ bởi quầy khác, chờ...");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized boolean sellHeldTicket(Ticket t, String counterName) {
        // Chỉ bán nếu vé vẫn đang được giữ, chưa bán cho ai, và chưa quá hạn
        if (t.isHeld() && !t.isSold() && t.getHoldExpiryTime() >= System.currentTimeMillis()) {
            t.setSold(true);
            t.setHeld(false);
            t.setHoldExpiryTime(0);
            System.out.println(counterName + ": Thanh toán THÀNH CÔNG vé " + t.getTicketId());
            return true;
        }
        System.out.println(counterName + ": Thanh toán THẤT BẠI, vé " + t.getTicketId() + " đã hết hạn giữ!");
        return false;
    }

    public synchronized void releaseExpiredTickets() {
        long currentTime = System.currentTimeMillis();
        boolean releasedAny = false;

        for (Ticket t : tickets) {
            if (!t.isSold() && t.isHeld() && currentTime > t.getHoldExpiryTime()) {
                t.setHeld(false);
                t.setHoldExpiryTime(0);
                System.out.println("TimeoutManager: Vé " + t.getTicketId() + " hết hạn giữ, đã trả lại kho");
                releasedAny = true;
            }
        }
        // Nếu đòi lại được vé nào, lập tức đánh thức các Quầy đang chờ
        if (releasedAny) {
            notifyAll();
        }
    }

    public synchronized boolean isFinished() {
        for (Ticket t : tickets) {
            if (!t.isSold()) return false;
        }
        return true;
    }
}