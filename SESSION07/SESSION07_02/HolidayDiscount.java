package SESSION07.SESSION07_02;

public class HolidayDiscount implements DiscountStrategy{
    private double percenteage;

    public HolidayDiscount(double percenteage) {
        this.percenteage = percenteage;
    }

    public double getPercenteage() {
        return percenteage;
    }

    public void setPercenteage(double percenteage) {
        this.percenteage = percenteage;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - (totalAmount * percenteage / 100);
    }
}
