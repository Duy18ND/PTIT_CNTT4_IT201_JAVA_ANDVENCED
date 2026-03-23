package SESSION12.SESSION12_05.Test;

import SESSION12.SESSION12_05.Entity.Bneed;
import SESSION12.SESSION12_05.Repositon.BneedReposition;
import SESSION12.SESSION12_05.Repositon.ipml.BneedImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static final BneedReposition bneedRepo = new BneedImpl();

    public static void main(String[] args) {
        int choice;
        do {
            Menu();
            System.out.print("Chọn chức năng (1-5): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi lựa chọn! Vui lòng nhập số.");
                choice = 0;
                continue;
            }
            switch (choice) {
                case 1 -> getAllBneed();
                case 2 -> addBneed();
                case 3 -> updateBneed();
                case 4 -> dischargeAndCalculateFee();
                case 5 -> System.out.println("Đang thoát chương trình. Tạm biệt!");
                default -> System.out.println("Vui lòng chọn từ 1 đến 5!");
            }
        } while (choice != 5);
    }

    public static void Menu() {
        System.out.println("\n==================HỆ THỐNG QUẢN LÝ NỘI TRÚ================");
        System.out.println("1. Danh sách bệnh nhân");
        System.out.println("2. Tiếp nhận bệnh nhân mới");
        System.out.println("3. Cập nhật bệnh án");
        System.out.println("4. Xuất viện & Tính phí");
        System.out.println("5. Thoát chương trình.");
    }

    private static void getAllBneed() {
        try {
            List<Bneed> list = bneedRepo.getBneed();

            if (list == null || list.isEmpty()) {
                System.out.println("Danh sách trống!!!");
                return;
            }

            System.out.println("\n--- Danh sách bệnh nhân ---");
            for (Bneed bneed : list) {
                System.out.println(bneed.toString());
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy xuất dữ liệu từ Database: " + e.getMessage());
        }
    }

    private static void addBneed() {
        try {
            System.out.println("\n--- Thêm bệnh nhân mới ---");
            System.out.print("ID: ");
            String id = sc.nextLine();

            if (bneedRepo.findById(id) != null) {
                System.out.println("Lỗi: Mã bệnh nhân (ID) này đã tồn tại trong hệ thống!");
                return;
            }

            System.out.print("Name: ");
            String name = sc.nextLine();

            int age = 0;
            try {
                System.out.print("Age: ");
                age = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Tuổi phải là số!");
                return;
            }

            System.out.print("Treatment: ");
            String treatment = sc.nextLine();

            Bneed bneed = new Bneed(id, name, age, treatment);
            if (bneedRepo.addBneed(bneed)) {
                System.out.println("Thêm thành công!");
            } else {
                System.out.println("Thêm thất bại!");
            }
        } catch (Exception e) {
            System.out.println("Lỗi add: " + e.getMessage());
        }
    }

    private static void updateBneed() {
        try {
            System.out.println("\n--- Cập nhật bệnh án ---");
            System.out.print("Nhập ID bệnh nhân cần cập nhật: ");
            String id = sc.nextLine();

            Bneed findId = bneedRepo.findById(id);
            if (findId == null) {
                System.out.println("Không tìm thấy bệnh nhân ID này!");
                return;
            }
            System.out.println("Thông tin hiện tại: " + findId.toString());

            System.out.print("Nhập Name mới: ");
            String name = sc.nextLine();
            int age = 0;
            try {
                System.out.print("Nhập Age mới: ");
                age = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Tuổi phải là số!");
                return;
            }

            System.out.print("Nhập Treatment mới: ");
            String treatment = sc.nextLine();

            Bneed bneed = new Bneed(id, name, age, treatment);

            if (bneedRepo.updateBneed(bneed)) {
                System.out.println("Cập nhật thành công!");
            } else {
                System.out.println("Cập nhật thất bại (Kiểm tra lại ID)!");
            }
        }catch (Exception e){
            System.out.println("Lỗi update: "+ e.getMessage());
        }
    }

    private static void dischargeAndCalculateFee() {
        try {
            System.out.println("\n--- Xuất viện & Tính phí ---");
            System.out.print("Nhập ID bệnh nhân làm thủ tục: ");
            String id = sc.nextLine();
            Bneed bneed = bneedRepo.findById(id);
            if (bneed == null) {
                System.out.println("Không tìm thấy bệnh nhân ID này!");
                return;
            }
            double fee = bneedRepo.calculateFee(id);

            if (fee > 0) {
                if (bneedRepo.dischargePatient(id)) {
                    System.out.println("Thủ tục xuất viện thành công!");
                    System.out.printf("Tổng viện phí của bệnh nhân là: %,.2f VNĐ\n", fee);
                } else {
                    System.out.println("Lỗi hệ thống khi xóa bệnh án!");
                }
            } else {
                System.out.println("Không tìm thấy bệnh nhân hoặc thủ tục tính toán bị lỗi!");
            }
        }catch (Exception e){
            System.out.println("Lỗi discharge: "+ e.getMessage());
        }
    }
}