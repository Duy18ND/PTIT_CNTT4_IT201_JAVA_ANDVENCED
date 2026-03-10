package SESSION03.SESSION03_04;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public record User(String username) {};

    public static void main(String[] args) {
        List<User> list= Arrays.asList(new User("duy18nd"), new User("helloWorld"), new User("duy18nd"));

        Set<User> listSet = list.stream().collect(Collectors.toSet());
        System.out.println(listSet);
    }

}