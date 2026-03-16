package SESSION07.SESSION07_04;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {
        System.out.println("Lưu đơn hàng vào database: " + order.getId());
    }
    @Override
    public List<Order> findAll() { return new ArrayList<>(); }
}
