//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.time.Duration;
//import static org.junit.jupiter.api.Assertions.*;
//
//class DataValidatorTest {
//
//    // Khai báo đối tượng của class chính để test
//    private DataValidator validator;
//
//    @BeforeEach
//    void setUp() {
//        // Cấp một đối tượng mới tinh trước mỗi bài test
//        validator = new DataValidator();
//    }
//
//    @Test
//    void testAssertEquals() {
//        // Kỳ vọng "hello" đưa qua hàm toUpperCase phải biến thành "HELLO"
//        assertEquals("HELLO", validator.toUpperCase("hello"), "Hàm viết hoa sai!");
//    }
//
//    @Test
//    void testAssertTrue() {
//        // Đưa 20 tuổi vào, hàm isAdult BẮT BUỘC phải trả về true
//        assertTrue(validator.isAdult(20), "20 tuổi phải là người trưởng thành!");
//    }
//
//    @Test
//    void testAssertFalse() {
//        // Đưa số 3 vào, hàm isEven BẮT BUỘC phải trả về false (vì 3 là số lẻ)
//        assertFalse(validator.isEven(3), "Số 3 không thể là số chẵn được!");
//    }
//
//    @Test
//    void testAssertNull() {
//        // Tìm quyền của một người không tồn tại (guest), kết quả mong đợi là null
//        assertNull(validator.findRole("guest"), "Tài khoản lạ phải trả về null!");
//    }
//
//    @Test
//    void testAssertNotNull() {
//        // Tìm quyền của admin, chắc chắn phải ra một cái gì đó (không được rỗng)
//        assertNotNull(validator.findRole("admin"), "Admin phải có quyền cụ thể!");
//    }
//
//    @Test
//    void testAssertThrows() {
//        // Cố tình truyền pass có 3 ký tự ("123"), yêu cầu hàm bên kia phải chửi (văng Exception)
//        assertThrows(IllegalArgumentException.class, () -> {
//            validator.validatePassword("123");
//        }, "Lập trình viên quên bắt lỗi password ngắn rồi!");
//    }
//
//    @Test
//    void testAssertTimeout() {
//        // Yêu cầu hàm heavyProcessing phải chạy xong TRƯỚC 500 mili-giây
//        // (Bên hàm gốc đang cài đặt là mất 200ms -> Test này sẽ Pass)
//        assertTimeout(Duration.ofMillis(500), () -> {
//            validator.heavyProcessing();
//        }, "Hàm xử lý quá chậm, vi phạm giới hạn 0.5 giây!");
//    }
//
//    @Test
//    void testAssertArrayEquals() {
//        // Đưa mảng lộn xộn vào
//        int[] input = {5, 1, 9};
//        int[] expectedArr = {1, 5, 9}; // Mảng kết quả kỳ vọng
//
//        // Nhận mảng kết quả từ class gốc và đem đi so sánh
//        int[] actualArr = validator.sortNumbers(input);
//
//        assertArrayEquals(expectedArr, actualArr, "Lỗi: Thuật toán sắp xếp mảng chạy sai!");
//    }
//}