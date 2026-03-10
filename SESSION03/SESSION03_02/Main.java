package SESSION03.SESSION03_02;

import java.util.Arrays;
import java.util.List;

public class Main {
    static void main(String[] args) {
        List<String> list = Arrays.asList("alice@yahoo.com", "bob@yahoo.com", "charlie@gmail.com");
        List<String> result = list.stream().filter(s -> s.endsWith("@gmail.com")).map(s -> s.split("@")[0]).toList();
        System.out.println(result);
    }
}
