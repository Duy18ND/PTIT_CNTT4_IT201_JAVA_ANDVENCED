package SESSION11.SESSION11_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên bệnh nhân cần tìm: ");
        String patientName = sc.nextLine();

        // GIẢI PHÁP: Lọc bỏ các ký tự nguy hiểm (' ; --)
        String safeName = sanitizeInput(patientName);

        String sql = "SELECT * FROM Patients WHERE full_name = '" + safeName + "'";
        System.out.println("Câu lệnh SQL an toàn sẽ chạy: " + sql);

        // Thực thi với Statement (giả định đã có connection)
        // Statement stmt = conn.createStatement();
        // ResultSet rs = stmt.executeQuery(sql);
    }

    // Hàm làm sạch dữ liệu đầu vào
    private static String sanitizeInput(String input) {
        if (input == null) return "";
        // Loại bỏ dấu nháy đơn, dấu chấm phẩy, và ký hiệu comment của SQL
        return input.replace("'", "")
                .replace(";", "")
                .replace("--", "");
    }
}
