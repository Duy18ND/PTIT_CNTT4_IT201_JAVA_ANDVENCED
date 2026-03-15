package SESSION06.SESSION06_06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimulationManager manager = SimulationManager.getInstance();
        boolean exit = false;

        System.out.println("HỆ THỐNG QUẢN LÝ RẠP PHIM ĐA LUỒNG");

        while (!exit) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Bắt đầu mô phỏng");
            System.out.println("2. Tạm dừng mô phỏng");
            System.out.println("3. Tiếp tục mô phỏng");
            System.out.println("4. Thêm vé vào phòng");
            System.out.println("5. Xem thống kê");
            System.out.println("6. Phát hiện deadlock");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Nhập số phòng: ");
                    int rooms = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập số vé/phòng: ");
                    int tickets = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập số quầy bán: ");
                    int counters = Integer.parseInt(scanner.nextLine());
                    manager.initSimulation(rooms, tickets, counters);
                    break;
                case "2":
                    manager.pauseSimulation();
                    break;
                case "3":
                    manager.resumeSimulation();
                    break;
                case "4":
                    System.out.print("Nhập tên phòng (VD: A, B): ");
                    String room = scanner.nextLine();
                    System.out.print("Nhập số lượng vé thêm: ");
                    int addCount = Integer.parseInt(scanner.nextLine());
                    manager.addTicketsToRoom(room, addCount);
                    break;
                case "5":
                    manager.printStats();
                    break;
                case "6":
                    DeadlockDetector.checkDeadlock();
                    break;
                case "7":
                    manager.stopSimulation();
                    System.out.println("Kết thúc chương trình. Hẹn gặp lại!");
                    exit = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
        scanner.close();
    }
}