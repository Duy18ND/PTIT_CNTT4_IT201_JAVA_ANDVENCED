package SESSION09.demo;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("\n===== BỘ BÍ KÍP VƯỢT QUA MỌI KỲ THI JAVA =====");
            System.out.println("1. Regex: Kiểm tra Email và Số điện thoại chuẩn VN");
            System.out.println("2. Chuyển đổi cơ số: Thập phân (Hệ 10) <-> Nhị phân (Hệ 2)");
            System.out.println("3. Thuật toán: Kiểm tra số Nguyên tố & In N số đầu tiên");
            System.out.println("4. Thuật toán thi: Dãy Fibonacci & Tính Giai thừa");
            System.out.println("5. Thuật toán thi: Kiểm tra Chuỗi đối xứng (Palindrome)");
            System.out.println("6. Thoát");

            choice = getIntInput("👉 Chọn bài toán cần test (1-6): ");

            // 🔥 TÍNH NĂNG: Java 14 Switch Expression (Không cần break)
            switch (choice) {
                case 1 -> testRegex();
                case 2 -> testNumberConversion();
                case 3 -> testPrimeNumber();
                case 4 -> testFibonacciAndFactorial();
                case 5 -> testPalindrome();
                case 6 -> System.out.println("👋 Chúc bạn thi đạt điểm A+ nhé!");
                default -> System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    // =================================================================
    // 1. REGEX (Biểu thức chính quy) - Bài toán bắt lỗi form đăng ký
    // =================================================================
    private static void testRegex() {
        System.out.println("\n--- BÀI 1: KIỂM TRA ĐỊNH DẠNG BẰNG REGEX ---");

        // 🔥 GIẢI THÍCH REGEX EMAIL:
        // ^ : Bắt đầu chuỗi
        // [a-zA-Z0-9._-]+ : Tên email gồm chữ, số, dấu chấm, gạch ngang/dưới (ít nhất 1 ký tự)
        // @ : Ký tự @ bắt buộc
        // [a-zA-Z0-9.-]+ : Tên miền (gmail, yahoo...)
        // \. : Dấu chấm
        // [a-zA-Z]{2,} : Đuôi tên miền (.com, .vn, .edu) dài ít nhất 2 ký tự
        // $ : Kết thúc chuỗi
        String emailRegex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // 🔥 GIẢI THÍCH REGEX SỐ ĐIỆN THOẠI VN:
        // ^(0|\+84) : Bắt đầu bằng 0 hoặc +84
        // [3|5|7|8|9] : Đầu số mạng di động VN hiện tại
        // [0-9]{8}$ : Theo sau là đúng 8 chữ số, kết thúc chuỗi. (Tổng cộng 10 số)
        String phoneRegex = "^(0|\\+84)[3|5|7|8|9][0-9]{8}$";

        System.out.print("Nhập Email cần kiểm tra: ");
        String email = sc.nextLine().trim();
        if (Pattern.matches(emailRegex, email)) {
            System.out.println("✅ Email hợp lệ!");
        } else {
            System.out.println("❌ Email KHÔNG hợp lệ!");
        }

        System.out.print("Nhập Số ĐT Việt Nam: ");
        String phone = sc.nextLine().trim();
        if (phone.matches(phoneRegex)) { // Dùng thẳng string.matches() cho gọn
            System.out.println("✅ Số điện thoại hợp lệ!");
        } else {
            System.out.println("❌ Số điện thoại KHÔNG hợp lệ!");
        }
    }

    // =================================================================
    // 2. CHUYỂN ĐỔI CƠ SỐ (Hệ 10 sang Hệ 2 và ngược lại)
    // =================================================================
    private static void testNumberConversion() {
        System.out.println("\n--- BÀI 2: CHUYỂN ĐỔI CƠ SỐ ---");
        int num = getIntInput("Nhập số nguyên (Hệ 10) cần chuyển sang Nhị phân: ");

        // 🔥 Cách 1: Dùng hàm có sẵn của Java (Nhanh nhất)
        String binaryBuiltIn = Integer.toBinaryString(num);

        // 🔥 Cách 2: Thuật toán làm thủ công (Để đi thi viết giấy hoặc giảng viên yêu cầu)
        StringBuilder binaryManual = new StringBuilder();
        int temp = num;
        if (temp == 0) binaryManual.append("0");
        while (temp > 0) {
            binaryManual.insert(0, temp % 2); // Lấy phần dư chèn vào đầu chuỗi
            temp = temp / 2; // Chia đôi lấy phần nguyên
        }

        System.out.println("✅ Nhị phân (Dùng hàm Java): " + binaryBuiltIn);
        System.out.println("✅ Nhị phân (Code thủ công): " + binaryManual);

        // --- CHUYỂN NGƯỢC LẠI TỪ NHỊ PHÂN SANG THẬP PHÂN ---
        System.out.print("\nNhập một chuỗi Nhị phân (VD: 1010) để chuyển sang Thập phân: ");
        String binStr = sc.nextLine().trim();

        // Kiểm tra xem chuỗi có hợp lệ (chỉ chứa 0 và 1) bằng Regex không
        if (!binStr.matches("^[01]+$")) {
            System.out.println("❌ Chuỗi nhị phân không hợp lệ!");
            return;
        }

        // Ép kiểu Nhị phân (cơ số 2) về số nguyên
        int decimal = Integer.parseInt(binStr, 2);
        System.out.println("✅ Hệ thập phân của " + binStr + " là: " + decimal);
    }

    // =================================================================
    // 3. SỐ NGUYÊN TỐ (Prime Number)
    // =================================================================
    private static void testPrimeNumber() {
        System.out.println("\n--- BÀI 3: SỐ NGUYÊN TỐ ---");
        int n = getIntInput("Nhập số N để in ra danh sách các số Nguyên tố từ 1 đến N: ");

        System.out.print("👉 Các số nguyên tố là: ");
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // Xuống dòng
    }

    // 🔥 THUẬT TOÁN TỐI ƯU KIỂM TRA NGUYÊN TỐ:
    // Chỉ cần chạy vòng lặp từ 2 đến Căn bậc 2 của n là đủ (Tiết kiệm 50% thời gian xử lý)
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false; // Nếu chia hết cho bất kỳ số nào -> Không phải nguyên tố
        }
        return true;
    }

    // =================================================================
    // 4. FIBONACCI & GIAI THỪA
    // =================================================================
    private static void testFibonacciAndFactorial() {
        System.out.println("\n--- BÀI 4: FIBONACCI VÀ GIAI THỪA ---");
        int n = getIntInput("Nhập N (dưới 20) để tính: ");

        // Tính Giai thừa (N!)
        long factorial = 1; // Dùng kiểu long vì giai thừa tăng rất nhanh
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("✅ Giai thừa " + n + "! = " + factorial);

        // Tính dãy Fibonacci (Số sau = tổng 2 số trước)
        System.out.print("✅ Dãy Fibonacci " + n + " phần tử đầu tiên: ");
        long a = 0, b = 1, next;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    // =================================================================
    // 5. CHUỖI ĐỐI XỨNG (Palindrome) - Ví dụ: "madam", "12321"
    // =================================================================
    private static void testPalindrome() {
        System.out.println("\n--- BÀI 5: CHUỖI ĐỐI XỨNG ---");
        System.out.print("Nhập một chuỗi hoặc số: ");
        String str = sc.nextLine().trim();

        // Dùng StringBuilder để đảo ngược chuỗi siêu nhanh
        String reversedStr = new StringBuilder(str).reverse().toString();

        // Bỏ qua phân biệt hoa thường để kiểm tra
        if (str.equalsIgnoreCase(reversedStr)) {
            System.out.println("✅ ĐÂY LÀ CHUỖI ĐỐI XỨNG! (" + str + " <-> " + reversedStr + ")");
        } else {
            System.out.println("❌ KHÔNG phải chuỗi đối xứng!");
        }
    }

    // =================================================================
    // BỨC TƯỜNG THÉP CHỐNG CRASH KHI NHẬP SỐ
    // =================================================================
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ LỖI: Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }
}