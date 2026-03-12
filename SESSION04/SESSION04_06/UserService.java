package SESSION04.SESSION04_06;

import java.time.LocalDate;
import java.util.List;

public class UserService {

    public User updateProfile(User existingUser,
                              UserProfile newProfile,
                              List<User> allUsers) {

        // kiểm tra ngày sinh tương lai
        if (newProfile.getBirthDate().isAfter(LocalDate.now())) {
            return null;
        }

        String newEmail = newProfile.getEmail();

        // kiểm tra email trùng với user khác
        for (User user : allUsers) {

            if (user != existingUser &&
                    user.getEmail().equalsIgnoreCase(newEmail)) {

                return null;
            }
        }

        // cập nhật hồ sơ
        existingUser.setEmail(newEmail);
        existingUser.setBirthDate(newProfile.getBirthDate());

        return existingUser;
    }
}