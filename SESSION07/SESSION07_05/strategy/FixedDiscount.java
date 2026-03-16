package SESSION07.SESSION07_05.strategy;

public class FixedDiscount implements DiscountStrategy {
    private double fixedAmount;

    public FixedDiscount(double fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    @Override
    public double applyDiscount(double originalAmount) {
        return Math.max(0, originalAmount - fixedAmount);
    }
}