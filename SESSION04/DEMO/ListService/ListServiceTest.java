//package SESSION04.DEMO.ListService;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ListServiceTest {
//
//    private ListService listService;
//
//    // ==========================================
//    // VÒNG ĐỜI TEST (Test Lifecycle)
//    // ==========================================
//
//    @BeforeEach
//    void setUp() {
//        /*
//         * Hàm này tự động chạy TRƯỚC MỖI BÀI TEST.
//         * Tác dụng: Cấp cho mỗi hàm @Test bên dưới một cái listService mới tinh,
//         * không bị dính dữ liệu rác của hàm test trước đó. (Đảm bảo tính độc lập).
//         */
//        listService = new ListService();
//    }
//
//    @AfterEach
//    void tearDown() {
//        /*
//         * Hàm này tự động chạy SAU MỖI BÀI TEST.
//         * Thường dùng để dọn rác, đóng kết nối Database. Ở bài này ta dùng List ảo
//         * trong RAM nên không cần dọn dẹp gì, cứ để trống.
//         */
//    }
//
//    // ==========================================
//    // CÁC KỊCH BẢN KIỂM THỬ
//    // ==========================================
//
//    @Test
//    void addName() {
//        // 1. Kịch bản tốt: Thêm thành công
//        listService.addName("Alice");
//        assertEquals(1, listService.size(), "Size phải tăng lên 1 sau khi thêm!");
//
//        // 2. Kịch bản xấu: Cố tình thêm chuỗi rỗng -> Phải bắt được lỗi IllegalArgumentException
//        assertThrows(IllegalArgumentException.class, () -> {
//            listService.addName("   ");
//        }, "Hệ thống không chặn được việc thêm tên rỗng!");
//
//        // 3. Kịch bản xấu: Cố tình thêm trùng lặp -> Phải bắt được lỗi
//        assertThrows(IllegalArgumentException.class, () -> {
//            listService.addName("Alice"); // Thêm Alice lần 2
//        }, "Hệ thống không chặn được việc thêm tên trùng lặp!");
//    }
//
//    @Test
//    void removeName() {
//        // Chuẩn bị data trước khi test xóa
//        listService.addName("Bob");
//
//        // 1. Xóa người tồn tại -> Trả về true và size giảm
//        assertTrue(listService.removeName("Bob"), "Xóa Bob phải trả về true");
//        assertEquals(0, listService.size());
//
//        // 2. Xóa người không tồn tại -> Trả về false
//        assertFalse(listService.removeName("Charlie"), "Xóa người không có thật phải trả về false");
//    }
//
//    @Test
//    void getAllNames() {
//        listService.addName("Duy");
//        List<String> names = listService.getAllNames();
//
//        // 1. Kiểm tra danh sách lấy ra có chuẩn không
//        assertEquals(1, names.size());
//        assertEquals("Duy", names.get(0));
//
//        // 2. KIỂM TRA BẢO MẬT (Rất quan trọng):
//        // Vì ta dùng Collections.unmodifiableList ở class chính,
//        // nên nếu cố tình add trộm vào list này, nó phải báo lỗi UnsupportedOperationException
//        assertThrows(UnsupportedOperationException.class, () -> {
//            names.add("Hacker");
//        }, "Lỗi bảo mật: Danh sách trả ra chưa được khóa chặn sửa đổi!");
//    }
//
//    @Test
//    void findName() {
//        listService.addName("Charlie");
//
//        // 1. Tìm đúng tên (Thử gõ chữ thường xem nó có tìm được không)
//        Optional<String> result1 = listService.findName("char");
//
//        // assertTrue để đảm bảo cái hộp Optional KHÔNG bị rỗng
//        assertTrue(result1.isPresent(), "Phải tìm thấy Charlie!");
//        assertEquals("Charlie", result1.get());
//
//        // 2. Tìm người không tồn tại
//        Optional<String> result2 = listService.findName("Batman");
//
//        // assertFalse để đảm bảo cái hộp Optional LÀ hộp rỗng
//        assertFalse(result2.isPresent(), "Tìm Batman thì phải ra rỗng!");
//    }
//
//    @Test
//    void size() {
//        // Mới khởi tạo, giỏ đồ phải trống trơn
//        assertEquals(0, listService.size());
//
//        listService.addName("Alice");
//        listService.addName("Bob");
//
//        // Thêm 2 người, size phải là 2
//        assertEquals(2, listService.size());
//    }
//}