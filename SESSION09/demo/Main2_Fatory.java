package SESSION09.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// =================================================================
// 1. LỚP MẸ (Abstract Class) - Bản thiết kế gốc
// =================================================================
abstract class Product {
    // Thuộc tính chung mà con nào cũng phải có
    protected String id;
    protected String name;
    protected double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // 🔥 TÍNH NĂNG: Hàm Trừu tượng (Abstract Method)
    // Mẹ chỉ tạo ra cái luật "Đã là Sản phẩm thì phải biết hiển thị thông tin"
    // Còn hiển thị thế nào thì Mẹ không viết code, bắt các Con tự định nghĩa!
    public abstract void showInfo();
}

// =================================================================
// 2. CÁC LỚP CON (Kế thừa Mẹ và có thuộc tính riêng)
// =================================================================
class Electronics extends Product {
    private int warrantyMonths; // Thuộc tính riêng: Số tháng bảo hành

    public Electronics(String id, String name, double price, int warrantyMonths) {
        super(id, name, price); // Gọi hàm khởi tạo của Mẹ để nạp id, name, price
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void showInfo() {
        // Điện tử thì in thêm cái Bảo hành
        System.out.printf("📱 [ĐIỆN TỬ]  | Mã: %-4s | Tên: %-12s | Giá: %-8.1f | Bảo hành: %d tháng\n",
                id, name, price, warrantyMonths);
    }
}

class HomeAppliance extends Product {
    private int powerWatts; // Thuộc tính riêng: Công suất tiêu thụ điện (W)

    public HomeAppliance(String id, String name, double price, int powerWatts) {
        super(id, name, price);
        this.powerWatts = powerWatts;
    }

    @Override
    public void showInfo() {
        // Gia dụng thì in thêm cái Công suất
        System.out.printf("🏠 [GIA DỤNG] | Mã: %-4s | Tên: %-12s | Giá: %-8.1f | Công suất: %d W\n",
                id, name, price, powerWatts);
    }
}

// =================================================================
// 3. FACTORY PATTERN: "Nhà máy" chuyên sản xuất Con dưới lốt Mẹ
// =================================================================
class ProductFactory {
    // 🔥 TÍNH NĂNG: Kiểu trả về là Mẹ (Product)
    // Truyền tham số type vào, Nhà máy sẽ tự "new Con" rồi trả về cho bạn
    public static Product createProduct(int type, String id, String name, double price, int extraInfo) {
        // 🔥 Java 14 Switch Lambda
        return switch (type) {
            case 1 -> new Electronics(id, name, price, extraInfo);
            case 2 -> new HomeAppliance(id, name, price, extraInfo);
            default -> null;
        };
    }
}

// =================================================================
// 4. MAIN: Lễ tân điều khiển (Chống Crash)
// =================================================================
public class Main2_Fatory {
    private static final Scanner sc = new Scanner(System.in);

    // 🔥 TÍNH NĂNG: ĐA HÌNH (Polymorphism)
    // Danh sách này khai báo kiểu MẸ (Product), nhưng chứa toàn các đối tượng CON bên trong
    private static final List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("\n===== QUẢN LÝ CỬA HÀNG ĐIỆN MÁY =====");
            System.out.println("1. Nhập kho một sản phẩm mới");
            System.out.println("2. Hiển thị toàn bộ kho hàng");
            System.out.println("3. Thoát");

            choice = getIntInput("👉 Chọn chức năng (1-3): ");

            switch (choice) {
                case 1 -> addNewProduct();
                case 2 -> displayAll();
                case 3 -> System.out.println("👋 Đã đóng cửa hàng!");
                default -> System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        } while (choice != 3);
    }

    // --- Xử lý Logic Thêm ---
    private static void addNewProduct() {
        System.out.println("\n--- THÊM SẢN PHẨM ---");
        System.out.println("Chọn loại: 1. Điện tử (Có bảo hành) | 2. Gia dụng (Có công suất)");
        int type = getIntInput("Loại SP: ");

        if (type != 1 && type != 2) {
            System.out.println("❌ Loại sản phẩm không tồn tại!");
            return;
        }

        System.out.print("Nhập Mã SP: ");
        String id = sc.nextLine().trim();
        System.out.print("Nhập Tên SP: ");
        String name = sc.nextLine().trim();
        double price = getDoubleInput("Nhập Giá bán: ");

        int extraInfo;
        if (type == 1) {
            extraInfo = getIntInput("Nhập số tháng bảo hành: ");
        } else {
            extraInfo = getIntInput("Nhập công suất (W): ");
        }

        // 🔥 TÍNH NĂNG: Upcasting kết hợp Factory
        // Biến newProduct có kiểu là Product (Mẹ), nhưng giá trị thật là Điện tử hoặc Gia dụng
        Product newProduct = ProductFactory.createProduct(type, id, name, price, extraInfo);

        productList.add(newProduct);
        System.out.println("✅ Thêm sản phẩm thành công!");
    }

    // --- Xử lý Logic Hiển thị ---
    private static void displayAll() {
        System.out.println("\n=========== KHO HÀNG CỦA BẠN ===========");
        if (productList.isEmpty()) {
            System.out.println("📦 Kho đang trống!");
            return;
        }

        // 🔥 TÍNH NĂNG: Sức mạnh thật sự của Đa hình (Polymorphism)
        for (Product p : productList) {
            // Vòng lặp chỉ quan tâm nó là Mẹ (Product).
            // Nhưng khi gọi p.showInfo(), tuỳ thuộc vào "bản chất" lúc new là Con nào,
            // hàm showInfo() của Con đó sẽ TỰ ĐỘNG được kích hoạt!
            p.showInfo();
        }
    }

    // --- Hàng rào thép chống Crash ---
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ LỖI: Chỉ được phép nhập số nguyên!");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double val = Double.parseDouble(sc.nextLine().trim());
                if (val < 0) {
                    System.out.println("❌ LỖI: Số tiền không được âm!");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("❌ LỖI: Vui lòng nhập đúng định dạng số!");
            }
        }
    }
}
