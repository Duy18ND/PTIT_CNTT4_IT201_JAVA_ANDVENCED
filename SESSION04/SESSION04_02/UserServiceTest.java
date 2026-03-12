package SESSION04.SESSION04_02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService service;

    @BeforeEach
    void setUp() {
        // Khởi tạo đối tượng mới trước mỗi bài test để đảm bảo tính độc lập
        service = new UserService();
    }

    @Test
    @DisplayName("TC01: Biên hợp lệ - Đúng 18 tuổi")
    void TC01_age18_validBoundary() {
        assertTrue(service.checkRegistrationAge(18), "18 tuổi phải đăng ký được chứ!");
    }

    @Test
    @DisplayName("TC02: Dưới biên - 17 tuổi không được đăng ký")
    void TC02_age17_invalid() {
        assertFalse(service.checkRegistrationAge(17), "17 tuổi là chưa đủ tuổi rồi");
    }

    @Test
    @DisplayName("TC03: Dữ liệu lỗi - Tuổi âm phải ném ngoại lệ")
    void TC03_negativeAge_exception() {
        // Đây chính là lệnh assertThrows của JUnit 6.0.3/5.x
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.checkRegistrationAge(-1);
        });

        // Kiểm tra xem tin nhắn báo lỗi có đúng không
        assertEquals("Age cannot be negative", exception.getMessage());
    }
}