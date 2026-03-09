package SESSION02.SESSION02_04;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SESSION02_04 {
    public static void main(String[] args) {
        //Khởi tạo new User
        Supplier<User> userFactory = User::new;
        //Get giá trị
        User defaultUser = userFactory.get();

        //Test
        List<User> users = new ArrayList<>();
        users.add(defaultUser);
        users.add(new User("Admin_NguyenVanA"));
        users.add(new User("Manager_TranThiB"));

        //In
        users.stream().map(User::getUsername).forEach(System.out::println);
    }
}
