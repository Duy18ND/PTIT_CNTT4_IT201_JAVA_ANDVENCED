package SESSION09.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// =================================================================
// 1. SINGLETON PATTERN: Hệ thống ghi log (Nhật ký) duy nhất
// =================================================================
class SystemLogger {
    // 🔥 TÍNH NĂNG: Singleton Pattern (Đảm bảo toàn bộ app chỉ xài chung 1 cuốn sổ ghi chép)
    private static SystemLogger instance;

    private SystemLogger() {}

    public static SystemLogger getInstance() {
        if (instance == null) {
            instance = new SystemLogger();
        }
        return instance;
    }

    public synchronized void log(String message) {
        System.out.println("📝 [SYSTEM LOG]: " + message);
    }
}

// =================================================================
// 2. ENTITY: Lớp chứa dữ liệu thuần túy (Mô hình 3 lớp)
// =================================================================
class Order {
    private String id;
    private String customerName;
    private double totalAmount;

    public Order(String id, String customerName, double totalAmount) {
        this.id = id;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    public String getId() { return id; }
    public double getTotalAmount() { return totalAmount; }

    @Override
    public String toString() {
        return String.format("Mã đơn: %-5s | Khách: %-15s | Tổng tiền: %-10.1f", id, customerName, totalAmount);
    }
}

// =================================================================
// 3. FACTORY PATTERN: Tách biệt logic tạo phương thức thông báo
// =================================================================
interface INotification {
    void sendNotify(Order order);
}

class AppNotification implements INotification {
    public void sendNotify(Order order) { System.out.println("📱 [APP]: Chúc mừng! Đơn " + order.getId() + " đã được xử lý."); }
}

class SmsNotification implements INotification {
    public void sendNotify(Order order) { System.out.println("💬 [SMS]: Đơn " + order.getId() + " đang trên đường giao đến bạn."); }
}

class NotificationFactory {
    // 🔥 TÍNH NĂNG: Factory Pattern (Nhà máy sản xuất cục thông báo)
    public static INotification getNotification(int type) {
        // 🔥 TÍNH NĂNG: Java 14 Switch Expression (Có mũi tên -> và trả về trực tiếp)
        return switch (type) {
            case 1 -> new AppNotification();
            case 2 -> new SmsNotification();
            default -> new AppNotification(); // Mặc định dùng App
        };
    }
}

// =================================================================
// 4. INTERFACE TRUNG GIAN (GIAO TIẾP LỎNG LẺO - LOOSE COUPLING)
// =================================================================
// 🔥 TÍNH NĂNG: Đây chính là cái "Ổ cắm trung gian".
// Tầng Main (Giao diện) chỉ biết cái này, KHÔNG quan tâm bên trong viết gì.
interface IOrderService {
    void addOrder(Order order);
    void showAllOrders();
    void processOrdersAsync(int notifyType);
}

// =================================================================
// 5. BUSINESS/SERVICE LAYER: Nơi xử lý não bộ (Triển khai Interface)
// =================================================================
class OrderServiceImpl implements IOrderService {
    private List<Order> orderList = new ArrayList<>();
    private SystemLogger logger = SystemLogger.getInstance();

    @Override
    public void addOrder(Order order) {
        orderList.add(order);
        logger.log("Đã thêm đơn hàng mới: " + order.getId());
    }

    @Override
    public void showAllOrders() {
        System.out.println("\n=========== DANH SÁCH ĐƠN HÀNG ===========");
        if (orderList.isEmpty()) {
            System.out.println("📦 Chưa có đơn hàng nào.");
            return;
        }

        // 🔥 TÍNH NĂNG: Java 8 Stream API & Lambda Expression (Sắp xếp giảm dần theo tiền)
        orderList.stream()
                .sorted((o1, o2) -> Double.compare(o2.getTotalAmount(), o1.getTotalAmount()))
                .forEach(order -> System.out.println(order.toString())); // In ra bằng Method Reference/Lambda
    }

    @Override
    public void processOrdersAsync(int notifyType) {
        if (orderList.isEmpty()) {
            System.out.println("📦 Không có đơn nào để xử lý!");
            return;
        }

        System.out.println("⏳ Hệ thống đang xử lý ngầm... Bạn có thể tiếp tục dùng Menu.");

        // Cắt danh sách hiện tại ra để xử lý, làm rỗng giỏ hàng
        List<Order> ordersToProcess = new ArrayList<>(orderList);
        orderList.clear();

        // 🔥 TÍNH NĂNG: Multithreading (Đa luồng) bằng Lambda Java 8
        // Luồng ngầm (Background Thread) chạy độc lập, không làm kẹt Menu chính
        new Thread(() -> {
            INotification notifier = NotificationFactory.getNotification(notifyType);

            for (Order order : ordersToProcess) {
                try {
                    Thread.sleep(2000); // Giả lập thời gian nấu ăn/đóng gói tốn 2 giây
                    logger.log("Xử lý xong đơn: " + order.getId());
                    notifier.sendNotify(order); // Gửi thông báo
                } catch (InterruptedException e) {
                    System.out.println("Lỗi luồng xử lý!");
                }
            }
            System.out.println("\n✅ Đã xử lý xong toàn bộ đơn hàng! (Nhấn Enter để tiếp tục)");
        }).start();
    }
}

// =================================================================
// 6. PRESENTATION LAYER (MAIN): Giao diện người dùng chống Crash
// =================================================================
public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 🔥 TÍNH NĂNG: Giao tiếp qua Interface (Dependency Inversion)
        // Kiểu dữ liệu là Interface (IOrderService), nhưng khởi tạo bằng Class cụ thể (OrderServiceImpl)
        IOrderService orderService = new OrderServiceImpl();

        int choice = 0;
        do {
            System.out.println("\n===== BẢNG ĐIỀU KHIỂN NHÀ HÀNG =====");
            System.out.println("1. Tạo đơn hàng mới");
            System.out.println("2. Xem danh sách (Sắp xếp tiền giảm dần)");
            System.out.println("3. Nhấn nút Xử lý toàn bộ đơn hàng (Chạy ngầm)");
            System.out.println("4. Thoát");

            choice = getIntInput("👉 Chọn chức năng (1-4): ");

            // 🔥 TÍNH NĂNG: Java 14 Switch Expression (->)
            switch (choice) {
                case 1 -> createNewOrder(orderService);
                case 2 -> orderService.showAllOrders();
                case 3 -> triggerProcessing(orderService);
                case 4 -> System.out.println("👋 Tắt hệ thống. Chúc một ngày tốt lành!");
                default -> System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        } while (choice != 4);
    }

    // --- CÁC HÀM HỖ TRỢ BÊN TRONG MAIN ---

    private static void createNewOrder(IOrderService orderService) {
        System.out.println("\n--- THÊM ĐƠN HÀNG ---");
        System.out.print("Nhập Mã đơn: ");
        String id = sc.nextLine().trim();

        System.out.print("Nhập Tên khách: ");
        String name = sc.nextLine().trim();

        // 🔥 Gọi hàm chống Crash khi nhập số
        double price = getDoubleInput("Nhập Tổng tiền: ");

        Order newOrder = new Order(id, name, price);

        // Main chỉ gọi lệnh qua Interface, không quan tâm List nằm ở đâu
        orderService.addOrder(newOrder);
    }

    private static void triggerProcessing(IOrderService orderService) {
        System.out.println("Chọn kênh báo khách: 1. Thông báo App | 2. Nhắn tin SMS");
        int type = getIntInput("Chọn: ");
        orderService.processOrdersAsync(type);
    }

    // 🔥 TÍNH NĂNG: Bức tường thành chống Crash (Exception Handling)
    // Vòng lặp vĩnh cửu bắt ép nhập đúng số nguyên mới nhả ra
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ LỖI: Vui lòng nhập SỐ, không nhập chữ hay để trống!");
            }
        }
    }

    // Hàm chống Crash tương tự nhưng dành cho số thực (tiền)
    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(sc.nextLine().trim());
                if (value < 0) {
                    System.out.println("❌ LỖI: Tiền không được âm!");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("❌ LỖI: Định dạng tiền không hợp lệ. Vui lòng nhập số!");
            }
        }
    }
}