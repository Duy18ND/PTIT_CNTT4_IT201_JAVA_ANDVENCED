package SESSION09.luyenTap.ra.business;

import SESSION09.luyenTap.ra.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserBusiness {
    // Để List ở đây để Business tự quản lý dữ liệu của nó
    private List<User> userList;

    public UserBusiness() {
        this.userList = new ArrayList<>();
    }

    // 1. Hiển thị danh sách
    public void displayAll() {
        System.out.println("\n=========== DANH SÁCH USER ===========");
        if (userList.isEmpty()) {
            System.out.println("📦 Danh sách đang trống!");
            return;
        }
        for (User u : userList) {
            u.displayInfo();
        }
    }

    // 2. Thêm mới
    public void addUser(Scanner sc) {
        System.out.println("\n=============== THÊM USER ===============");
        User newUser = new User();
        newUser.inputData(sc);
        userList.add(newUser);
        System.out.println("✅ Thêm User thành công!");
    }

    // 3. Cập nhật
    public void update(Scanner sc) {
        System.out.println("\n============ UPDATE ============");
        System.out.print("Nhập ID cần sửa: ");
        String findID = sc.nextLine().trim();

        User userToUpdate = findById(findID);
        if (userToUpdate == null) {
            System.out.println("❌ Lỗi: ID bạn tìm kiếm không hợp lệ hoặc không tồn tại!");
            return;
        }

        System.out.println("✅ Đã tìm thấy User. Mời nhập thông tin mới:");
        userToUpdate.inputData(sc);
        System.out.println("✅ Cập nhật thành công!");
    }

    // 4. Xóa
    public void deleteUser(Scanner sc) {
        System.out.println("\n============ XÓA USER ============");
        System.out.print("Nhập ID cần xóa: ");
        String findID = sc.nextLine().trim();

        User userToDelete = findById(findID);
        if (userToDelete == null) {
            System.out.println("❌ Lỗi: Không tìm thấy User mang mã: " + findID);
            return;
        }

        userList.remove(userToDelete);
        System.out.println("✅ Đã xóa User thành công!");
    }

    // 5. Tìm kiếm theo tên (Gần đúng)
    public void findByName(Scanner sc) {
        System.out.println("\n============ TÌM KIẾM THEO TÊN ============");
        System.out.print("Nhập tên cần tìm: ");
        String searchName = sc.nextLine().trim().toLowerCase();

        boolean isFound = false;
        for (User u : userList) {
            // Dùng contains để tìm gần đúng (VD: nhập "an" sẽ ra "Tuấn", "An", "Lan")
            if (u.getUserName().toLowerCase().contains(searchName)) {
                u.displayInfo();
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("❌ Không tìm thấy User nào có tên chứa: " + searchName);
        }
    }

    // 6. Lọc danh sách ADMIN
    public void filterAdmin() {
        System.out.println("\n=========== DANH SÁCH ADMIN ===========");
        boolean isFound = false;
        for (User u : userList) {
            if (u.getRole().equalsIgnoreCase("ADMIN")) {
                u.displayInfo();
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("⚠️ Hệ thống hiện không có ADMIN nào.");
        }
    }

    // 7. Sắp xếp theo điểm giảm dần
    public void sortByScoreDesc() {
        System.out.println("\n=========== SẮP XẾP ĐIỂM GIẢM DẦN ===========");
        if (userList.isEmpty()) {
            System.out.println("📦 Danh sách trống!");
            return;
        }

        // Sử dụng hàm sort có sẵn của List với biểu thức Lambda
        userList.sort((u1, u2) -> Double.compare(u2.getScore(), u1.getScore()));

        System.out.println("✅ Đã sắp xếp xong! Dưới đây là danh sách:");
        displayAll();
    }

    // --- Hàm hỗ trợ tìm kiếm theo ID ---
    public User findById(String id) {
        for (User u : userList) {
            if (u.getUserId().equalsIgnoreCase(id)) {
                return u;
            }
        }
        return null;
    }
}