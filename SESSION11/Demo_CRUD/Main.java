package SESSION11.Demo_CRUD;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAOImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("========= QUẢN LÝ SẢN PHẨM =========");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm mới");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng (1-5): ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    showData(dao);
                    break;
                case 2:
                    System.out.println("--- NHẬP THÔNG TIN SẢN PHẨM MỚI ---");
                    Product newP = inputProduct(sc, null);
                    if (dao.addProduct(newP)) {
                        System.out.println("=> Thêm thành công!");
                    } else {
                        System.err.println("=> Thêm thất bại!");
                    }
                    break;
                case 3:
                    System.out.print("Nhập ID sản phẩm cần sửa: ");
                    int editId = Integer.parseInt(sc.nextLine());
                    System.out.println("--- NHẬP THÔNG TIN MỚI ---");
                    Product editP = inputProduct(sc, editId);
                    if (dao.edit(editId, editP)) {
                        System.out.println("=> Cập nhật thành công!");
                    } else {
                        System.out.println("=> Không tìm thấy ID hoặc lỗi cập nhật.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    int delId = Integer.parseInt(sc.nextLine());
                    if (dao.delete(delId)) {
                        System.out.println("=> Xóa thành công!");
                    } else {
                        System.out.println("=> Không tìm thấy ID hoặc lỗi khi xóa.");
                    }
                    break;
                case 5:
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // Hàm phụ: Nhập dữ liệu từ bàn phím
    private static Product inputProduct(Scanner sc, Integer id) {
        System.out.print("Tên sản phẩm: ");
        String name = sc.nextLine();
        System.out.print("Nhà sản xuất: ");
        String producer = sc.nextLine();
        System.out.print("Năm sản xuất: ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("Giá bán: ");
        double price = Double.parseDouble(sc.nextLine());

        // Mặc định ngày hết hạn là ngày hôm nay cho nhanh, bạn có thể tự nhập thêm nếu muốn
        return new Product(id, name, producer, year, new Date(), price);
    }

    // Hàm phụ: In dữ liệu
    private static void showData(ProductDAO dao) {
        System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
        List<Product> list = dao.getProduct();
        if (list.isEmpty()) {
            System.out.println("(Dữ liệu trống)");
        } else {
            for (Product p : list) {
                System.out.println(p);
            }
        }
        System.out.println("--------------------------\n");
    }
}