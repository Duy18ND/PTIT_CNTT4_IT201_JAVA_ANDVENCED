package SESSION07.SESSION07_05.repository;

import SESSION07.SESSION07_05.entity.Order;
import java.util.List;

public interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}