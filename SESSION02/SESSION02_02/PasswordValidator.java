package SESSION02.SESSION02_02;

@FunctionalInterface
public interface PasswordValidator {
    boolean isValid(String password);
}
