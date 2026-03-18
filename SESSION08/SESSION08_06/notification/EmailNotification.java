package SESSION08.SESSION08_06.notification;

public class EmailNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Gửi email: " + message);
    }
}