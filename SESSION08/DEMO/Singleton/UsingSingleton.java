package SESSION08.DEMO.Singleton;

public class UsingSingleton {
    public static void main(String[] args) {

        // ÔN TẬP: Dòng dưới đây sẽ BÁO LỖI đỏ lòm vì constructor đã bị private
        // Singleton obj = new Singleton();

        // 1. Gọi lần đầu: Hệ thống sẽ khởi tạo ra 1 object mới
        Singleton s1 = Singleton.getInstance();
        System.out.println(s1.hello());

        // 2. Gọi lần hai: Hệ thống KHÔNG khởi tạo mới, mà lấy lại chính object s1
        Singleton s2 = Singleton.getInstance();

        // 3. CHỨNG MINH (Test kiểm tra khi ôn bài):
        // Nếu s1 và s2 cùng trỏ về 1 vùng nhớ, nó sẽ in ra "true"
        System.out.println("s1 và s2 có phải là cùng một đối tượng? " + (s1 == s2));
    }
}