package SESSION03.SESSION03_01;

// Đổi hẳn thành record User (Bỏ chữ s đi cho chuẩn ngữ nghĩa 1 User)
public record User(String username, String email, Status status) {

    // Khai báo Enum nằm bên trong Record
    public enum Status {
        ACTIVE, INACTIVE
    }
}