package SESSION02.SESSION02_05;

interface UserActions {
    default void logActivity(String activity) {
        System.out.println("[USER LOG]: " + activity);
    }
}
