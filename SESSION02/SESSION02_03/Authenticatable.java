package SESSION02.SESSION02_03;
@FunctionalInterface
public interface Authenticatable {
    String getPassword();

    default void isAuthenticated() {
        System.out.println("Đang kiểm tra xác thực...");
    }

    static String encrypt(String rawPassword) {
        return rawPassword.replaceAll(".", "*");
    }
}
