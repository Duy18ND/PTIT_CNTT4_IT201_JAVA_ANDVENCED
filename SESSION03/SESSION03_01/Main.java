package SESSION03.SESSION03_01;

import java.util.Arrays;
import java.util.List;

public class Main {
    static void main(String[] args) {
        User alice = new User("Đỗ Kim Thu", "thuy@gmail.com", User.Status.ACTIVE);
        User bob = new User("Bob", "Bob@gmail.com", User.Status.INACTIVE);
        User charlie = new User("Charlie", "Charlie@gmail.com", User.Status.ACTIVE);

        List<User> list = Arrays.asList(alice,bob,charlie);

        list.stream().forEach(System.out::println);
    }
}
