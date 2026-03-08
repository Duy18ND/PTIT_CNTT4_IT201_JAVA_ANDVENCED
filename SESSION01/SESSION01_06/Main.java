package SESSION01.SESSION01_06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = new User();

        String userName = user.getName();
        if (userName != null) {
            System.out.println("Tên người dùng: " + userName.toUpperCase());
        } else {
            System.out.println("Cảnh báo: Người dùng chưa được thiết lập tên!");
        }

        try {
            user.setAge(-10);
            System.out.println("Tuổi hợp lệ: " + user.getAge());
        } catch (InvalidAgeException e) {
            logError(e);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tổng số người: ");
        String peopleInput = sc.nextLine();

        System.out.print("Nhập số nhóm để chia: ");
        String groupInput = sc.nextLine();

        try {
            int totalPeople = Integer.parseInt(peopleInput);
            int group = Integer.parseInt(groupInput);

            if (group == 0) {
                System.out.println("Cảnh báo: Không thể chia cho 0 nhóm (Đã phòng ngừa bằng if-else)");
            } else if (totalPeople < 0 || group < 0) {
                System.out.println("Cảnh báo: Dữ liệu nhập vào không được là số âm");
            } else {
                int result = totalPeople / group;
                System.out.println("Mỗi nhóm có " + result + " người");
            }
        } catch (NumberFormatException e) {
            logError(e);
        } finally {
            sc.close();
        }
    }

    public static void logError(Exception e) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);

        System.out.println("[ERROR] " + formattedDate + " - [" + e.getClass().getSimpleName() + "] - " + e.getMessage());
    }
}