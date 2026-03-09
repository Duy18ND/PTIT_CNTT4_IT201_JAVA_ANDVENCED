package SESSION02.SESSION02_05;

class SuperAdmin implements UserActions, AdminActions {
    @Override
    public void logActivity(String activity) {
        System.out.println("--- Bắt đầu ghi log của SuperAdmin ---");
        AdminActions.super.logActivity(activity);
        System.out.println("--- Kết thúc ghi log ---");
    }
}