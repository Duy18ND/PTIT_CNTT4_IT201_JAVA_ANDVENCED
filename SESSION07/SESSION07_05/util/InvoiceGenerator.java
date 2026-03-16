package SESSION07.SESSION07_05.util;

import SESSION07.SESSION07_05.entity.Order;
import SESSION07.SESSION07_05.entity.OrderItem;

public class InvoiceGenerator {
    public void printInvoice(Order order) {
        System.out.println("=== HÓA ĐƠN ===");
        System.out.println("Khách: " + order.getCustomer().getName());
        for (OrderItem item : order.getItems()) {
            System.out.printf("%s - Số lượng: %d - Đơn giá: %,.0f - Thành tiền: %,.0f\n",
                    item.getProduct().getName(), item.getQuantity(), item.getProduct().getPrice(), item.getSubTotal());
        }
        System.out.printf("Tổng tiền: %,.0f\n", order.getTotalAmount());
        System.out.printf("Giảm giá: %,.0f\n", (order.getTotalAmount() - order.getFinalAmount()));
        System.out.printf("Cần thanh toán: %,.0f\n", order.getFinalAmount());
    }
}