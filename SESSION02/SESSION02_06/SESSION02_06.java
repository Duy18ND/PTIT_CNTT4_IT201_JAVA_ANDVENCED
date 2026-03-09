package SESSION02.SESSION02_06;
public class SESSION02_06 {
        public static void main(String[] args) {
            UserProcessor upperCaseProcessor = UserUtils::convertToUpperCase;
            User myUser = new User("admin_java_8");
            System.out.println("--- KẾT QUẢ XỬ LÝ USERNAME ---");
            System.out.println("Username gốc: " + myUser.getUsername());
            String processedName = upperCaseProcessor.process(myUser);
            System.out.println("Username sau khi process: " + processedName);
        }
}
