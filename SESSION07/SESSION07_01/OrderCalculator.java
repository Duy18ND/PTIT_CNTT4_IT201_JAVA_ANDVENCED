package SESSION07.SESSION07_01;

public class OrderCalculator {
    public double caculateTotal(Order order){
        double total = 0;

        for(Product product: order.getProductList()){
            total += product.getPrice();
        }
        if(total == 0){
            System.out.println("Không có sẵn phẩm nào!");
        }
        return total;
    }
}
