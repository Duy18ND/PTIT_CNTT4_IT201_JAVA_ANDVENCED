package SESSION06.SESSION06_04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ticket> listA = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            listA.add(new Ticket(String.format("A-%03d", i), "A"));
        }
        TicketPool poolA = new TicketPool("A", listA);

        List<Ticket> listB = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            listB.add(new Ticket(String.format("B-%03d", i), "B"));
        }
        TicketPool poolB = new TicketPool("B", listB);

        // TH1: TẠO DEADLOCK (Quầy 2 khóa ngược thứ tự B -> A)
        BookingCounter counter1 = new BookingCounter("Quầy 1", poolA, poolB, false);
        BookingCounter counter2 = new BookingCounter("Quầy 2", poolA, poolB, true);

        // TH2: PHÒNG CHỐNG DEADLOCK (Cả 2 quầy cùng khóa theo chuẩn A -> B)
        // Hãy comment TH1 và uncomment TH2 để xem chương trình chạy mượt mà
        // BookingCounter counter1 = new BookingCounter("Quầy 1", poolA, poolB, false);
        // BookingCounter counter2 = new BookingCounter("Quầy 2", poolA, poolB, false);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------");
        System.out.println("Kết thúc chương trình");
        System.out.println("Quầy 1 bán được: " + counter1.getSoldCount() + " vé");
        System.out.println("Quầy 2 bán được: " + counter2.getSoldCount() + " vé");
        System.out.println("Vé còn lại phòng A: " + poolA.getRemainingCount());
        System.out.println("Vé còn lại phòng B: " + poolB.getRemainingCount());
    }
}