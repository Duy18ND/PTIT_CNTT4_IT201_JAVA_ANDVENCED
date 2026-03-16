package SESSION07.SESSION07_01;

import java.util.List;

public class Order {
    //    chứa thông tin đơn hàng (mã đơn, khách hàng, danh sách sản phẩm, tổng tiền).
    private String orderID;
    private Customer customer;
    private List<Product> productList;
    private double amount;

    public Order() {
    }

    public Order(String orderID, Customer customer, List<Product> productList, double amount) {
        this.orderID = orderID;
        this.customer = customer;
        this.productList = productList;
        this.amount = amount;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
