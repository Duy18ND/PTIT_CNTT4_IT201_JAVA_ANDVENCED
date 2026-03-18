package SESSION09.KiemTra;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ProductDatabase db = ProductDatabase.getInstance();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            Menu();
            try {
                choice = Integer.parseInt(sc.nextLine()); // Bẫy lỗi nếu người dùng nhập chữ
                switch (choice) {
                    case 1:
                        addNewProduct(sc);
                        break;
                    case 2:
                        displayProducts();
                        break;
                    case 3:
                        updateProduct(sc);
                        break;
                    case 4:
                        deleteProduct(sc);
                        break;
                    case 5:
                        System.out.println("Chương trình kết thúc. Tạm biệt!");
                        break;
                    default:
                        System.out.println("Lựa chọn của bạn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("LỖI: Vui lòng nhập một số nguyên từ 1 đến 5!");
                choice = 0;
            }
        } while (choice != 5);
    }

    public static void Menu() {
        System.out.println("\n---------------------- QUẢN LÝ SẢN PHẨM ----------------------");
        System.out.println("1. Thêm mới sản phẩm");
        System.out.println("2. Xem danh sách sản phẩm");
        System.out.println("3. Cập nhật thông tin sản phẩm");
        System.out.println("4. Xoá sản phẩm");
        System.out.println("5. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    private static void addNewProduct(Scanner sc) {
        System.out.println("\n--- THÊM SẢN PHẨM ---");
        try {
            System.out.print("Nhập Type (1: Physical Product | 2: Digital Product): ");
            int type = Integer.parseInt(sc.nextLine());

            if (type != 1 && type != 2) {
                System.out.println("Loại sản phẩm không hợp lệ!");
                return;
            }

            System.out.print("Nhập ID: ");
            String id = sc.nextLine();
            if (db.findById(id) != null) {
                System.out.println("Lỗi: ID này đã tồn tại trong hệ thống!");
                return;
            }

            System.out.print("Nhập Name: ");
            String name = sc.nextLine();

            System.out.print("Nhập Price: ");
            double price = Double.parseDouble(sc.nextLine());

            if (type == 1) {
                System.out.print("Nhập Trọng lượng - Weight (kg): ");
                double weight = Double.parseDouble(sc.nextLine());
                db.addProduct(ProductFactory.createProduct(type, id, name, price, weight));
            } else {
                System.out.print("Nhập Dung lượng - Size (MB): ");
                double size = Double.parseDouble(sc.nextLine());
                db.addProduct(ProductFactory.createProduct(type, id, name, price, size));
            }
            System.out.println("Thêm sản phẩm thành công!");

        } catch (NumberFormatException e) {
            System.out.println("LỖI: Bạn nhập sai định dạng số (Giá, Trọng lượng hoặc Dung lượng)!");
        }
    }

    private static void displayProducts() {
        System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
        List<Product> list = db.getAllProducts();
        if (list.isEmpty()) {
            System.out.println("Kho hàng hiện đang trống.");
            return;
        }
        for (Product p : list) {
            p.displayInfo();
        }
    }

    private static void updateProduct(Scanner sc) {
        System.out.println("\n--- CẬP NHẬT SẢN PHẨM ---");
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        String id = sc.nextLine();

        Product p = db.findById(id);
        if (p == null) {
            System.out.println("Không tìm thấy sản phẩm mang ID: " + id);
            return;
        }

        try {
            System.out.print("Nhập tên mới: ");
            String name = sc.nextLine();
            if (!name.trim().isEmpty()) {
                p.setName(name);
            }

            System.out.print("Nhập giá mới: ");
            double price = Double.parseDouble(sc.nextLine());
            if (price >= 0) {
                p.setPrice(price);
            }

            if (p instanceof PhysicalProduct) {
                System.out.print("Nhập Trọng lượng mới (kg) (Nhập số âm để bỏ qua): ");
                double weight = Double.parseDouble(sc.nextLine());
                if (weight >= 0) {
                    ((PhysicalProduct) p).setWeight(weight);
                }
            } else if (p instanceof DigitalProduct) {
                System.out.print("Nhập Dung lượng mới (MB) (Nhập số âm để bỏ qua): ");
                double size = Double.parseDouble(sc.nextLine());
                if (size >= 0) {
                    ((DigitalProduct) p).setMb(size);
                }
            }
            System.out.println("Cập nhật thành công!");
        } catch (NumberFormatException e) {
            System.out.println("LỖI: Nhập sai định dạng số!");
        }
    }

    private static void deleteProduct(Scanner sc) {
        System.out.println("\n--- XÓA SẢN PHẨM ---");
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        String id = sc.nextLine();

        Product p = db.findById(id);
        if (p != null) {
            db.deleteProduct(p);
            System.out.println("Đã xóa thành công sản phẩm: " + id);
        } else {
            System.out.println("Không tìm thấy sản phẩm để xóa!");
        }
    }
}