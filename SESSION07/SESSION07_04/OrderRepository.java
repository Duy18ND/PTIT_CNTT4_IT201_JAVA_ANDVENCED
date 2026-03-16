package SESSION07.SESSION07_04;

import java.util.List;

public interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}
