package SESSION07.SESSION07_04;

import java.util.ArrayList;
import java.util.List;

public class FileOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {
        System.out.println("Lưu đơn hàng vào file: " + order.getId());
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>();
    }
}
