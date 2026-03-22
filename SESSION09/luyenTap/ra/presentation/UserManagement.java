package SESSION09.luyenTap.ra.presentation;

import SESSION09.luyenTap.ra.business.UserBusiness;
import java.util.Scanner;

public class UserManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Khởi tạo đối tượng quản lý 1 lần duy nhất ở đây
        UserBusiness business = new UserBusiness();
        int choice = 0;

        do {
            Menu();
            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        business.displayAll();
                        break;
                    case 2:
                        business.addUser(sc);
                        break;
                    case 3:
                        business.update(sc);
                        break;
                    case 4:
                        business.deleteUser(sc);
                        break;
                    case 5:
                        business.findByName(sc);
                        break;
                    case 6:
                        business.filterAdmin();
                        break;
                    case 7:
                        business.sortByScoreDesc();
                        break;
                    case 8:
                        System.out.println("👋 Thoát chương trình. Tạm biệt!");
                        break;
                    default:
                        System.out.println("❌ Lựa chọn của bạn không hợp lệ (nhập 1-8).");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ LỖI: Vui lòng nhập số, không nhập chữ!");
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
        System.out.println("8. Thoát");
        System.out.print("👉 Lựa chọn của bạn: ");
    }
}