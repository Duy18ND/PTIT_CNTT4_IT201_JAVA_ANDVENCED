package SESSION02.SESSION02_02;

public class SESSION02_02 {
    public static void main(String[] args) {
        PasswordValidator p1 = pass -> pass.length() >= 8;
        //Kiểm tra khoảng trắng trong pass
        PasswordValidator checkSpace = password -> password.contains(" ");
        //ít nhất 1 ký tự viết hoa
        PasswordValidator checkRegex = password -> password.matches(".*[A-Z].*");

        //Kiểm tra
        String pass1 = "Admin123";
        String pass2 = "abc12 ";
        System.out.println("Mật khẩu: " + pass1 + " | Dài hơn 8 ký tự?: " + p1.isValid(pass1) + " | Khoảng trắng?: " + checkSpace.isValid(pass1) + " | Có ít nhất 1 chữ cái?: " + checkRegex.isValid(pass1));
        System.out.println("Mật khẩu: " + pass2 + " | Dài hơn 8 ký tự?: " + p1.isValid(pass2) + " | Khoảng trắng?: " + checkSpace.isValid(pass2) + " | Có ít nhất 1 chữ cái?: " + checkRegex.isValid(pass2));
    }
}
