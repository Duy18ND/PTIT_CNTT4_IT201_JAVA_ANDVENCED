package SESSION07.SESSION07_05.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orId;
    private Customer customer;
    private List<OrderItem> items;
    private double totalAmount;
    private double finalAmount;

    public Order(String orId, Customer customer) {
        this.orId = orId;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public String getOrId() { return orId; }
    public void setOrId(String orId) { this.orId = orId; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public List<OrderItem> getItems() { return items; }
    public void addItem(OrderItem item) { this.items.add(item); }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public double getFinalAmount() { return finalAmount; }
    public void setFinalAmount(double finalAmount) { this.finalAmount = finalAmount; }
}