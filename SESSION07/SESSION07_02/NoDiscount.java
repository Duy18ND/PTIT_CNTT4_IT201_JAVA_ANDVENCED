package SESSION07.SESSION07_02;

public class NoDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount;
    }
}
