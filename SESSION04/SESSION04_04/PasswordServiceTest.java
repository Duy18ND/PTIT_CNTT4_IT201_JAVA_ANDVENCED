package SESSION04.SESSION04_04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordServiceTest {

    PasswordService service;

    @BeforeEach
    void setUp() {
        service = new PasswordService();
    }

    @Test
    void testStrongPassword() {
        String result = service.evaluatePasswordStrength("Abc123!@");

        assertEquals("Mạnh", result);
    }

    @Test
    void testMediumPasswords() {

        assertAll(
                () -> assertEquals("Trung bình",
                        service.evaluatePasswordStrength("abc123!@")), // thiếu chữ hoa

                () -> assertEquals("Trung bình",
                        service.evaluatePasswordStrength("ABC123!@")), // thiếu chữ thường

                () -> assertEquals("Trung bình",
                        service.evaluatePasswordStrength("Abcdef!@")), // thiếu số

                () -> assertEquals("Trung bình",
                        service.evaluatePasswordStrength("Abc12345")) // thiếu ký tự đặc biệt
        );
    }

    @Test
    void testWeakPasswords() {

        assertAll(
                () -> assertEquals("Yếu",
                        service.evaluatePasswordStrength("Ab1!")), // quá ngắn

                () -> assertEquals("Yếu",
                        service.evaluatePasswordStrength("password")), // chỉ chữ thường

                () -> assertEquals("Yếu",
                        service.evaluatePasswordStrength("ABC12345")) // chỉ chữ hoa + số
        );
    }
}