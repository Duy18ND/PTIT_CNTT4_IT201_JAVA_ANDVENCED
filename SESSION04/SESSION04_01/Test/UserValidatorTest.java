//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class UserValidatorTest {
//    private final UserValidator validator = new UserValidator();
//
//    @Test
//    @DisplayName("TC01: Username hợp lệ (đúng độ dài, không khoảng trắng)")
//    void isValidUsername() {
//        //Arrange
//        String input = "user123";
//
//        //Act Thực hiện
//        boolean result = validator.isValidUsername(input);
//
//        //Assert
//        assertTrue(result, "Hợp lệ");
//    }
//}