package SESSION07.SESSION07_01;

public class EmailService {
    public void sendEmail(Order order){
        System.out.println("Đã gửi email đến "+ order.getCustomer().getEmail()+": Đơn hàng -> " + order.getOrderID()+" đã được tạo");
    }
}
