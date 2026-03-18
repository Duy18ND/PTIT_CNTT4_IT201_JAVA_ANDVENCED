package SESSION09.luyenTap.ra.presentation;

import java.util.Scanner;

public class UserManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            Menu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ vui lòng check lại");
            }
        } while (choice != 8);
    }

    public static void Menu() {
        System.out.println("\n********************* QUẢN LÝ NGƯỜI DÙNG *********************");
        System.out.println("1. Hiển thị danh sách toàn bộ người dùng");
        System.out.println("2. Thêm mới người dùng");
        System.out.println("3. Cập nhật thông tin người dùng theo mã");
        System.out.println("4. Xóa người dùng theo mã");
        System.out.println("5. Tìm kiếm người dùng theo tên");
        System.out.println("6. Lọc danh sách người dùng ADMIN");
        System.out.println("7. Sắp xếp danh sách theo điểm đánh giá giảm dần");
        System.out.println("8. Thoát\n");
        System.out.print("Lựa chọn của bạn: ");
    }
}
