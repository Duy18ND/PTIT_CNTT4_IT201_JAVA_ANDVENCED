package SESSION07.SESSION07_05.service;

import SESSION07.SESSION07_05.entity.Customer;

public interface NotificationService {
    void send(String message, Customer customer);
}