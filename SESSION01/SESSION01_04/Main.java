package SESSION01.SESSION01_04;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            processUserData();
        } catch (IOException e) {
            System.out.println("Đã tóm được lỗi tại main: " + e.getMessage());
        }

        System.out.println("Chương trình JVM vẫn an toàn và kết thúc bình thường.");
    }

    public static void processUserData() throws IOException {
        saveToFile();
    }

    public static void saveToFile() throws IOException {
        throw new IOException("Lỗi ghi file cứng! Ổ đĩa bị đầy.");
    }
}