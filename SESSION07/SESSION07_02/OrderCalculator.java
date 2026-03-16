package SESSION07.SESSION07_02;

public class OrderCalculator {
    private DiscountStrategy discountStrategy;

    public OrderCalculator() {
        this.discountStrategy = new NoDiscount();
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal(double totalAmount) {
        return discountStrategy.applyDiscount(totalAmount);
    }
}
