package SESSION09.luyenTap.ra.entity;
import java.util.Scanner;

public class User {
    private String userId;
    private String userName;
    private int age;
    private String role;
    private double score;

    public User() {
    }

    public User(String userId, String userName, int age, String role, double score) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.role = role;
        this.score = score;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void inputData(Scanner scanner) {
        while (true) {
            System.out.print("Nhập ID: ");
            this.userId = scanner.nextLine().trim();
            if (!this.userId.isEmpty()) {
                break;
            }
            System.out.println("Lỗi: UserID không được để trống!");
        }

        while (true) {
            System.out.print("Nhập UserName: ");
            this.userName = scanner.nextLine().trim();

            if (!this.userName.isEmpty()) {
                break;
            }
            System.out.println("Lỗi: UserName không được để trống");
        }

        while (true) {
            System.out.print("Nhập Age: ");
            try {
                this.age = Integer.parseInt(scanner.nextLine());

                if (this.age > 0) {
                    break;
                }
                System.out.println("Lỗi nhập tuổi phải lớn hơn 0");
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng kiểm tra lại!");
            }
        }
        while (true) {
            System.out.print("Nhập Role ('ADMIN' | 'USER'): ");
            this.role = scanner.nextLine().toUpperCase().trim();

            if (this.role.equalsIgnoreCase("ADMIN") || this.role.equalsIgnoreCase("USER")) {
                break;
            }
            System.out.println("Lỗi: Role không được để trống");
        }

        while (true) {
            System.out.print("Nhập Score: ");
            try {
                this.score = Double.parseDouble(scanner.nextLine());

                if (this.score >= 0) {
                    break;
                }
                System.out.println("Score không được âm. Vui lòng kiểm tra lại!");
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng kiểm tra lại!");
            }
        }
    }

    public void displayInfo() {
        System.out.println("ID: " + getUserId());
        System.out.println("UserName: " + getUserName());
        System.out.println("Age : " + getUserName());
        System.out.println("Role: " + getUserName());
        System.out.println("Score: " + getUserName());
    }
}
