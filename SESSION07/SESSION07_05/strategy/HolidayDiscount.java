package SESSION07.SESSION07_05.strategy;

public class HolidayDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double originalAmount) {
        return originalAmount * 0.7;
    }
}