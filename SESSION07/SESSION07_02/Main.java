package SESSION07.SESSION07_02;

public class Main {
    public static void main(String[] args) {
        double totalAmount = 1000000;
        OrderCalculator calculator = new OrderCalculator();

        calculator.setDiscountStrategy(new PercentageDiscount(10));
        System.out.println("Đơn hàng: tổng tiền 1.000.000, áp dụng PercentageDiscount 10%");
        System.out.println("Số tiền sau khi giảm: " + calculator.calculateTotal(totalAmount));

        calculator.setDiscountStrategy(new FixedDiscount(50000));
        System.out.println("Đơn hàng: tổng tiền 1.000.000, áp dụng FixedDiscount 50.000");
        System.out.println("Số tiền sau khi giảm: " + calculator.calculateTotal(totalAmount));

        calculator.setDiscountStrategy(new NoDiscount());
        System.out.println("Đơn hàng: tổng tiền 1.000.000, áp dụng NoDiscount");
        System.out.println("Số tiền sau khi giảm: " + calculator.calculateTotal(totalAmount));

        calculator.setDiscountStrategy(new PercentageDiscount(15));
        System.out.println("Đơn hàng: tổng tiền 1.000.000, áp dụng HolidayDiscount 15%");
        System.out.println("Số tiền sau khi giảm: " + calculator.calculateTotal(totalAmount));


    }
}
