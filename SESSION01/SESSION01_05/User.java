package SESSION01.SESSION01_05;

public class User {
    private int age;

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuổi đăng ký không thể là số âm!");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}