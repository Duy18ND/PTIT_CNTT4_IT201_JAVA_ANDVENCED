package SESSION07.SESSION07_01;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private List<Order> orders;

    public OrderRepository(List<Order> orders) {
        this.orders = orders;
    }

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void saveOrder(Order order){
        orders.add(order);
    }
    public Order findOrderById(String orderID){
        for(Order o: orders){
            if(o.getOrderID().equals(orderID)){
                return o;
            }
        }
        return null;
    }
}
