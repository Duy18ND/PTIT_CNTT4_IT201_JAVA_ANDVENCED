package SESSION02.SESSION02_06;

class UserUtils {
    public static String convertToUpperCase(User u) {
        if (u == null || u.getUsername() == null) {
            return "UNKNOWN_USER";
        }
        return u.getUsername().toUpperCase();
    }
}