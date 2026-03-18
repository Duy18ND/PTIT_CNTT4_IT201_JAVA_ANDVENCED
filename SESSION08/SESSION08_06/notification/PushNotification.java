package SESSION08.SESSION08_06.notification;

public class PushNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Gửi push notification: " + message);
    }
}
