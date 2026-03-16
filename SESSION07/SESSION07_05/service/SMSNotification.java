package SESSION07.SESSION07_05.service;

import SESSION07.SESSION07_05.entity.Customer;

public class SMSNotification implements NotificationService {
    @Override
    public void send(String message, Customer customer) {
        System.out.println("Đã gửi SMS đến: " + customer.getPhone());
    }
}