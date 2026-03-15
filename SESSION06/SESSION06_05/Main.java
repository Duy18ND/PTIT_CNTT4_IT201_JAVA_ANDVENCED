package SESSION06.SESSION06_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo vé cho 3 phòng với sức chứa khác nhau
        List<Ticket> listA = createTickets("A", 3); // A có 3 vé
        List<Ticket> listB = createTickets("B", 4); // B có 4 vé
        List<Ticket> listC = createTickets("C", 5); // C có 5 vé

        TicketPool poolA = new TicketPool("A", listA);
        TicketPool poolB = new TicketPool("B", listB);
        TicketPool poolC = new TicketPool("C", listC);

        List<TicketPool> allPools = Arrays.asList(poolA, poolB, poolC);

        // Khởi tạo các bộ phận
        TimeoutManager manager = new TimeoutManager(allPools);
        Thread managerThread = new Thread(manager);

        List<BookingCounter> counters = new ArrayList<>();
        List<Thread> counterThreads = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            BookingCounter counter = new BookingCounter("Quầy " + i, allPools);
            counters.add(counter);
            counterThreads.add(new Thread(counter));
        }

        // Bắt đầu hệ thống
        managerThread.start();
        for (Thread t : counterThreads) {
            t.start();
        }

        // Chờ hệ thống chạy xong
        try {
            managerThread.join();
            for (Thread t : counterThreads) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tổng kết
        System.out.println("\n--- TỔNG KẾT DOANH THU ---");
        for (BookingCounter counter : counters) {
            System.out.println(counter.getSoldCount() + " vé đã được bán tại " + counter.getSoldCount()); // Sửa lại một chút phần in để hiển thị tên
        }
    }

    // Hàm phụ trợ tạo vé, 2 vé đầu tiên luôn là VIP
    private static List<Ticket> createTickets(String room, int count) {
        List<Ticket> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            boolean isVIP = (i <= 2);
            list.add(new Ticket(String.format("%s-%03d", room, i), room, isVIP));
        }
        return list;
    }
}