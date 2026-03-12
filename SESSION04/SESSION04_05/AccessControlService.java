package SESSION04.SESSION04_05;

public class AccessControlService {

    public boolean canPerformAction(User user, Action action) {

        if (user == null || action == null) {
            return false;
        }

        Role role = user.getRole();

        switch (role) {

            case ADMIN:
                return true;

            case MODERATOR:
                return action == Action.LOCK_USER || action == Action.VIEW_PROFILE;

            case USER:
                return action == Action.VIEW_PROFILE;

            default:
                return false;
        }
    }
}
