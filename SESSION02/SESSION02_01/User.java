package SESSION02.SESSION02_01;

public class User {
    private String username;
    private boolean isAdmin;

    // Constructor mặc định
    public User() {
        this.username = "guest_user";
        this.isAdmin = false;
    }

    // Constructor có tham số
    public User(String username, boolean isAdmin) {
        this.username = username;
        this.isAdmin = isAdmin;
    }

    public String getUsername() { return username; }
    public boolean isAdmin() { return isAdmin; }

    @Override
    public String toString() {
        return "User{username='" + username + "', isAdmin=" + isAdmin + "}";
    }
}
