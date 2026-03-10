package SESSION03.DEMO;

public class Demo_Java17 {

    // ==========================================
    // 1. SEALED CLASSES (Lớp niêm phong)
    // Tác dụng: Kiểm soát chặt chẽ ai được phép kế thừa Class/Interface này.
    // ==========================================
    /*
     * Ví dụ: Trong hệ thống, Character chỉ được phép là Hero hoặc Monster.
     * Cấm bất kỳ class rác nào bên ngoài được implements cái interface này.
     */
    public sealed interface Character permits Hero, Monster {}

    // Dùng luôn Record (Java 16) kết hợp với Sealed Interface
    public record Hero(String name, int level) implements Character {}
    public record Monster(String type, int damage) implements Character {}


    public static void main(String[] args) {
        System.out.println("=== 4 TÍNH NĂNG ĐỈNH CAO CỦA JAVA 17 ===");

        demoTextBlocks();
        demoSwitchExpression("Mage");

        Character myHero = new Hero("Arthur", 99);
        demoPatternMatching(myHero);
    }

    // ==========================================
    // 2. TEXT BLOCKS (Khối văn bản - """ """)
    // Tác dụng: Cứu tinh khi phải viết câu lệnh SQL, JSON hoặc HTML dài dòng.
    // ==========================================
    public static void demoTextBlocks() {
        // CÁCH CŨ (Cực kỳ khổ sở vì phải cộng chuỗi \n, \t, +)
        String oldSql = "SELECT username, email \n" +
                "FROM users \n" +
                "WHERE status = 'ACTIVE'";

        // CÁCH MỚI (Java 17): Viết SQL như gõ thẳng vào Database!
        String newSql = """
                SELECT username, email
                FROM users
                WHERE status = 'ACTIVE'
                """;

        System.out.println("1. Text Blocks SQL:\n" + newSql);
    }

    // ==========================================
    // 3. SWITCH EXPRESSIONS (Switch kiểu mới)
    // Tác dụng: Viết Switch như một hàm trả về giá trị, KHÔNG CẦN lệnh 'break'.
    // ==========================================
    public static void demoSwitchExpression(String role) {
        // Trả thẳng kết quả vào biến 'hp', dùng dấu mũi tên -> rất gọn
        int baseHp = switch (role) {
            case "Warrior" -> 1000;
            case "Mage", "Healer" -> 500; // Gộp nhiều case chung 1 dòng
            case "Assassin" -> 700;
            default -> throw new IllegalArgumentException("Class nhân vật không hợp lệ!");
        };
        System.out.println("2. Switch Expression - Máu cơ bản của " + role + " là: " + baseHp);
    }

    // ==========================================
    // 4. PATTERN MATCHING FOR INSTANCEOF
    // Tác dụng: Kiểm tra kiểu dữ liệu xong, Java TỰ ĐỘNG ép kiểu luôn.
    // ==========================================
    public static void demoPatternMatching(Character obj) {
        // CÁCH CŨ: Kiểm tra xong phải tạo biến mới để ép kiểu (Casting)
        /*
        if (obj instanceof Hero) {
            Hero h = (Hero) obj; // Rất thừa thãi!
            System.out.println(h.name());
        }
        */

        // CÁCH MỚI (Java 17): Khai báo luôn biến 'h' hoặc 'm' ngay trong lệnh if
        if (obj instanceof Hero h) {
            System.out.println("3. Pattern Matching - Hero xuất trận: " + h.name() + " (Lv " + h.level() + ")");
        } else if (obj instanceof Monster m) {
            System.out.println("3. Pattern Matching - Quái vật tấn công: Sát thương " + m.damage());
        }
    }
}