package SESSION04.SESSION04_06;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserService service = new UserService();

    @Test
    void shouldUpdateProfile_whenEmailAndBirthDateValid() {

        User existing = new User("old@gmail.com",
                LocalDate.of(2000,1,1));

        UserProfile newProfile =
                new UserProfile("new@gmail.com",
                        LocalDate.of(1999,1,1));

        List<User> users = new ArrayList<>();
        users.add(existing);

        User result = service.updateProfile(existing,newProfile,users);

        assertNotNull(result);
    }

    @Test
    void shouldRejectUpdate_whenBirthDateInFuture() {

        User existing = new User("user@gmail.com",
                LocalDate.of(2000,1,1));

        UserProfile newProfile =
                new UserProfile("new@gmail.com",
                        LocalDate.now().plusDays(1));

        List<User> users = new ArrayList<>();

        User result = service.updateProfile(existing,newProfile,users);

        assertNull(result);
    }

    @Test
    void shouldRejectUpdate_whenEmailDuplicated() {

        User existing = new User("old@gmail.com",
                LocalDate.of(2000,1,1));

        User other = new User("duplicate@gmail.com",
                LocalDate.of(1998,1,1));

        UserProfile newProfile =
                new UserProfile("duplicate@gmail.com",
                        LocalDate.of(1999,1,1));

        List<User> users = new ArrayList<>();
        users.add(existing);
        users.add(other);

        User result = service.updateProfile(existing,newProfile,users);

        assertNull(result);
    }

    @Test
    void shouldAllowUpdate_whenEmailSameAsCurrent() {

        User existing = new User("user@gmail.com",
                LocalDate.of(2000,1,1));

        UserProfile newProfile =
                new UserProfile("user@gmail.com",
                        LocalDate.of(1999,1,1));

        List<User> users = new ArrayList<>();
        users.add(existing);

        User result = service.updateProfile(existing,newProfile,users);

        assertNotNull(result);
    }

    @Test
    void shouldUpdate_whenUserListEmpty() {

        User existing = new User("user@gmail.com",
                LocalDate.of(2000,1,1));

        UserProfile newProfile =
                new UserProfile("new@gmail.com",
                        LocalDate.of(1999,1,1));

        List<User> users = new ArrayList<>();

        User result = service.updateProfile(existing,newProfile,users);

        assertNotNull(result);
    }

    @Test
    void shouldReject_whenEmailDuplicateAndBirthDateFuture() {

        User existing = new User("old@gmail.com",
                LocalDate.of(2003,12,23));

        User other = new User("hihi@gmail.com",
                LocalDate.of(1989,1,5));

        UserProfile newProfile =
                new UserProfile("duy18nd@gmail.com",
                        LocalDate.now().plusDays(5));

        List<User> users = new ArrayList<>();
        users.add(existing);
        users.add(other);

        User result = service.updateProfile(existing,newProfile,users);

        assertNull(result);
    }
}