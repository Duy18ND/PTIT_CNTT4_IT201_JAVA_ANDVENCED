package SESSION07.SESSION07_04;

public class EmailService implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Gửi email: "+ message);
    }
}
