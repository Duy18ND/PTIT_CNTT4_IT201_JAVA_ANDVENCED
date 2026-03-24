//package SESSION13.demo.Service;
//
//import java.awt.*;
//import java.util.Scanner;
//
//public class Main {
//    private static final Scanner sc = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        int mainChoice;
//        do {
//            MenuChoiceManagement();
//            try {
//                mainChoice = Integer.parseInt(sc.nextLine());
//                switch (mainChoice) {
//                    case 1 -> ActionMenuCategory();
//                    case 2 -> ActionMenuProduct();
//                    case 3 -> System.out.println("Thoát chương trình!");
//                    default -> System.out.println("Lựa chọn của bạn không hợp lệ. Vui lòng thử lại");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Lỗi Lựa chọn: MainChoice");
//                mainChoice = 0;
//            }
//        } while (mainChoice != 3);
//    }
//
//    //Mục MENU
//    //MENU MAIN
//    public static void MenuChoiceManagement() {
//        System.out.println("\n============== CATE PRO MANAGEMENT =============");
//        System.out.println("1. Quản lý category");
//        System.out.println("2. Quản lý product");
//        System.out.println("3. Kết thúc\n");
//        System.out.print("Mời bạn nhập lựa chọn: ");
//    }
//
//    //MENU CATEGORY
//    public static void MenuCategory() {
//        System.out.println("\n============== CATEGORY MANAGEMENT ===============");
//        System.out.println("1. Danh sách categories");
//        System.out.println("2. Thêm mới category");
//        System.out.println("3. Cập nhật category");
//        System.out.println("4. Xóa cateogry (Xóa mềm)");
//        System.out.println("5. Tìm kiếm category theo tên");
//        System.out.println("6. Sắp xếp category theo tên");
//        System.out.println("7. Trở lại\n");
//        System.out.print("Mời bạn nhập lựa chọn: ");
//    }
//
//    public static void ActionMenuCategory() {
//        int categoryChoice;
//        do {
//            try {
//                MenuCategory();
//                switch (categoryChoice) {
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Lỗi lựa chọn: ACTION MENU CATEGORY");
//                categoryChoice = 0;
//            }
//        } while (categoryChoice != 7);
//    }
//
//    //MENU PRODUCT
//    public static void MenuProduct() {
//        System.out.println("\n============== PRODUCT MANAGEMENT ===============");
//        System.out.println("1. Danh sách products");
//        System.out.println("2. Thêm mới product");
//        System.out.println("3. Cập nhật product");
//        System.out.println("4. Tìm kiếm product theo tên");
//        System.out.println("5. Xóa product (Xóa mềm)");
//        System.out.println("6. Sắp xếp product theo tên");
//        System.out.println("7. Trở lại\n");
//        System.out.print("Mời bạn nhập lựa chọn: ");
//    }
//
//    public static void ActionMenuProduct() {
//        int productChoice;
//        do {
//            try {
//                MenuProduct();
//                switch (productChoice) {
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Lỗi lựa chọn: ACTION MENU PRODUCT");
//                productChoice = 0;
//            }
//        }
//        while (productChoice != 7);
//    }
//}
