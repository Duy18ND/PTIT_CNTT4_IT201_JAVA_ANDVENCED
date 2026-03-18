package SESSION08.DEMO.factory;

public class TeacherCard implements LibraryCard {
    @Override
    public void showPrivileges() {
        System.out.println("Thẻ Giảng Viên: Mượn tối đa 10 cuốn sách trong 30 ngày.");
    }
}