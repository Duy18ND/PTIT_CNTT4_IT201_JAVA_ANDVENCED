package SESSION02.SESSION02_05;

interface AdminActions {
    default void logActivity(String activity) {
        System.out.println("[ADMIN LOG]: " + activity);
    }
}