package SESSION08.SESSION08_06.notification;

public class PrintReceipt implements NotificationService {
    public void send(String message) {
        System.out.println("In hóa đơn: " + message);
    }
}