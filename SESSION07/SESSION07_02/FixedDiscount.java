package SESSION07.SESSION07_02;

public class FixedDiscount implements DiscountStrategy {
    private double fixed;

    public FixedDiscount(double fixed) {
        this.fixed = fixed;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - fixed;
    }
}
