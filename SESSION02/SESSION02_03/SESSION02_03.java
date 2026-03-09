package SESSION02.SESSION02_03;

public class SESSION02_03 {
    public static void main(String[] args) {
        //Khởi tạo Authenticatable mới
        Authenticatable userAuth = () -> "Admin12345";
        //In mật khẩu hiện tại
        System.out.println("Mật khẩu hiện tại: "+ userAuth.getPassword());

        //Default
        userAuth.isAuthenticated();

        //Static
        System.out.println("Mã hóa mật khẩu: "+ Authenticatable.encrypt(userAuth.getPassword()));
    }
}
