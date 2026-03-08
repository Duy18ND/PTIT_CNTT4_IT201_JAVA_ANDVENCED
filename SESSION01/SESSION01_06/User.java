package SESSION01.SESSION01_06;

public class User {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuổi đăng ký không thể là số âm");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}