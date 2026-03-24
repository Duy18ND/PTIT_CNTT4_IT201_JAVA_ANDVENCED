package SESSION13.SESSION13_05;

import java.util.Scanner;

public class LeTanView {
    private final BenhNhanDAO dao = new BenhNhanDAO();
    private final Scanner scanner = new Scanner(System.in);

    public void hienThiMenu() {
        while (true) {
            System.out.println("\n========== HỆ THỐNG TIẾP NHẬN BỆNH NHÂN ==========");
            System.out.println("1. Xem danh sách giường trống");
            System.out.println("2. Tiếp nhận bệnh nhân nội trú (Nhập viện)");
            System.out.println("3. Thoát hệ thống");
            System.out.print("Chọn chức năng (1-3): ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    dao.layDanhSachGiuongTrong();
                    break;
                case "2":
                    xuLyTiepNhan();
                    break;
                case "3":
                    System.out.println("Đã thoát hệ thống. Chào tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
            }
        }
    }

    private void xuLyTiepNhan() {
        System.out.println("\n--- ĐIỀN THÔNG TIN NHẬP VIỆN ---");
        System.out.print("Nhập tên bệnh nhân: ");
        String ten = scanner.nextLine();

        int tuoi = 0;
        while (true) {
            try {
                System.out.print("Nhập tuổi: ");
                tuoi = Integer.parseInt(scanner.nextLine());
                if(tuoi <= 0 || tuoi > 150) throw new Exception("Tuổi phi logic");
                break;
            } catch (Exception e) {
                System.out.println("Lỗi: Tuổi phải là số nguyên dương. Vui lòng thử lại!");
            }
        }

        int maGiuong = 0;
        while (true) {
            try {
                System.out.print("Nhập mã giường muốn xếp (VD: 3 hoặc 4): ");
                maGiuong = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Lỗi: Mã giường phải là một số (ID). Vui lòng thử lại!");
            }
        }

        double tien = 0;
        while (true) {
            try {
                System.out.print("Nhập số tiền tạm ứng (VNĐ): ");
                tien = Double.parseDouble(scanner.nextLine());
                if (tien < 0) throw new Exception("Tiền âm");
                break;
            } catch (Exception e) {
                System.out.println("Lỗi: Số tiền không hợp lệ. Vui lòng thử lại!");
            }
        }

        System.out.println("Đang xử lý giao dịch (Transaction)...");
        boolean isSuccess = dao.tiepNhanBenhNhan(ten, tuoi, maGiuong, tien);

        if (isSuccess) {
            System.out.println("TÍCH HỢP THÀNH CÔNG: Đã tạo hồ sơ, xếp giường và thu tiền tạm ứng!");
        } else {
            System.out.println("TIẾP NHẬN THẤT BẠI. Dữ liệu đã được bảo toàn.");
        }
    }
}