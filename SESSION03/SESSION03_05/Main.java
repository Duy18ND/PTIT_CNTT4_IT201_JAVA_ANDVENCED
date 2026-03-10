package SESSION03.SESSION03_05;

import java.util.Arrays;
import java.util.List;

public class Main {
    static void main(String[] args) {
        List<User> list = Arrays.asList(new User("duy18nd"), new User("poodledog"), new User("dovanbinh123"));
        //In 3 user dài nhất
        list.stream()
                .sorted((a, b) -> b.getUserName().length() - a.getUserName().length())
                .limit(3)
                .forEach(user -> System.out.println(user.getUserName()));
    }
}
