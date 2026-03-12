package SESSION04.SESSION04_03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserProcessorTest {

    UserProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new UserProcessor();
    }

    @Test
    void testValidEmail_shouldReturnSameEmail() {

        // Arrange
        String email = "user@gmail.com";

        // Act
        String result = processor.processEmail(email);

        // Assert
        assertEquals("user@gmail.com", result);
    }

    @Test
    void testEmailWithoutAtSymbol_shouldThrowException() {

        // Arrange
        String email = "usergmail.com";

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail(email);
        });
    }

    @Test
    void testEmailWithoutDomain_shouldThrowException() {

        // Arrange
        String email = "user@";

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail(email);
        });
    }

    @Test
    void testEmailNormalization_shouldConvertToLowercase() {

        // Arrange
        String email = "Example@Gmail.com";

        // Act
        String result = processor.processEmail(email);

        // Assert
        assertEquals("example@gmail.com", result);
    }
}