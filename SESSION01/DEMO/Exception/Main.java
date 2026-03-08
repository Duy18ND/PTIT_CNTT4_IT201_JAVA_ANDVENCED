package SESSION01.DEMO.Exception;

public class Main {
    public static void main(String[] args) {
        try {
            double area = getAreaTriage(2,0,4);
            System.out.println("Diện tích tam giác là: " + area);
        } catch (TriageException e) {
            System.out.println("Lỗi tính toán: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy bình thường ở đây...");
    }

    public static double getAreaTriage(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new TriageException("3 cạnh phải lớn hơn 0");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new TriageException("Tổng 2 cạnh bất kỳ phải lớn hơn cạnh còn lại");
        }

        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}