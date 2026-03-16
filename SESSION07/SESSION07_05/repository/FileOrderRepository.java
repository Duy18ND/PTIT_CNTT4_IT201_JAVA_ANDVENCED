package SESSION07.SESSION07_05.repository;

import SESSION07.SESSION07_05.entity.Order;
import java.util.ArrayList;
import java.util.List;

public class FileOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {
        System.out.println("Đã lưu đơn hàng " + order.getOrId() + " vào file.");
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>();
    }
}