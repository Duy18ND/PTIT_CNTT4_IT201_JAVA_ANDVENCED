package SESSION07.SESSION07_01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Tạo sản phẩm
        Product p1 = new Product("SP01","Laptop A16", 2000000);
        Product p2 = new Product("SP02","Chuột", 300000);

        System.out.println("Đã thêm sản phẩm: SP01, SP02");
        //Cần phải có class Product service, cài đặt hàm addProduct(Product p)
        //Để lưu product vào trong collection kiểu Product

        //Tạo khách hàng
        Customer c1 = new Customer("Nguyễn Văn A", "abc@gmail.com","Hà đông, Hà Nội");
        Customer c2 = new Customer("Nguyễn Văn B", "abcd@gmail.com","Hà Tĩnh, Hà Nội");
        System.out.println("Đã thêm khách thành công");
        //Cần phải có CustomerService chứa phương thức  thêm khách hàng để lưu customer

        //Tạo đơn hàng
        List<Product> productList = new ArrayList<>();

        productList.add(p1);
        productList.add(p2);

        OrderCalculator oc = new OrderCalculator();
        Order o1 = new Order("ORD001", c1, productList, 0);
        System.out.println("Đơn hàng ORD001 đã được tạo");

        System.out.println("Tổng tiền: "+oc.caculateTotal(o1));

        OrderRepository repo = new OrderRepository();

        repo.saveOrder(o1);
        System.out.println("Đã lưu đơn hàng: "+o1.getOrderID());

        EmailService es = new EmailService();
        es.sendEmail(o1);
    }
}
