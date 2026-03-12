package SESSION04.SESSION04_01; // Địa chỉ nhà của file này

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    private UserValidator userValidator;

    @BeforeEach
    void setUp() {
        // Khởi tạo đối tượng trước mỗi bài test
        userValidator = new UserValidator();
    }

    @AfterEach
    void tearDown() {
        // Dọn dẹp nếu cần (thường để trống)
    }

    @Test
    @DisplayName("Kiểm tra username hợp lệ")
    void isValidUsername() {
        // Viết logic test của bạn ở đây
        boolean result = userValidator.isValidUsername("user123");
        assertTrue(result);
    }
}