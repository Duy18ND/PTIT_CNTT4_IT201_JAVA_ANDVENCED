package SESSION08.DEMO.factory;

public class StudentCard implements  LibraryCard{
    @Override
    public void showPrivileges() {
        System.out.println("Thẻ Sinh Viên: Mượn tối đa 3 cuốn sách trong 7 ngày.");
    }
}
