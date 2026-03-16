package SESSION07.SESSION07_05.strategy;

public class PercentageDiscount implements DiscountStrategy {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double originalAmount) {
        return originalAmount - (originalAmount * percentage / 100);
    }
}