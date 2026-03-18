package SESSION08.DEMO.factory;

public class CardFactory {
    // Hàm Factory chuyên trách việc đẻ object dựa trên tham số đầu vào
    // Thường dùng static để gọi trực tiếp mà không cần new CardFactory()
    public static LibraryCard getCard(String cardType) {
        if (cardType == null) {
            return null;
        }

        switch (cardType.toUpperCase()) {
            case "STUDENT":
                return new StudentCard();
            case "TEACHER":
                return new TeacherCard();
            // Mở rộng cực dễ: Sau này có thẻ VIP thì nhét thêm case "VIP" vào đây
            default:
                throw new IllegalArgumentException("Loại thẻ không hợp lệ: " + cardType);
        }
    }
}