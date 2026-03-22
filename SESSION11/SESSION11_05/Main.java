package SESSION11.SESSION11_05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoctorDAO dao = new DoctorDAO();

        while (true) {
            System.out.println("\n--- RIKKEI-CARE DOCTOR MANAGEMENT ---");
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ mới");
            System.out.println("3. Thống kê chuyên khoa");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    dao.getAllDoctors();
                    break;
                case 2:
                    System.out.print("Nhập ID Bác sĩ: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập Họ Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập Chuyên khoa: ");
                    String spec = sc.nextLine();

                    if (dao.addDoctor(new Doctor(id, name, spec))) {
                        System.out.println("Thêm thành công!");
                    }
                    break;
                case 3:
                    dao.getSpecialtyStats();
                    break;
                case 4:
                    System.out.println("Tạm biệt!");
                    System.exit(0);
            }
        }
    }
}