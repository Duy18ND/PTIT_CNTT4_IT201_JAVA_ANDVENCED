package SESSION03.SESSION03_03;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    static List<User> list = Arrays.asList(new User("Alice"), new User("Duy"));

    static Optional<User> findUserByUsername(String username) {
        return list.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }

    public static void main(String[] args) {
        Optional<User> result = findUserByUsername("Alice");

        result.ifPresentOrElse(
                u -> System.out.println("Welcome " + u.getUsername()),
                () -> System.out.println("Guest login")
        );
    }
}