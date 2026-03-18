package SESSION09.KiemTra;

public class DigitalProduct extends Product{
    private double Mb;

    public DigitalProduct(String id, String name, double price, double mb) {
        super(id, name, price);
        Mb = mb;
    }

    public double getMb() {
        return Mb;
    }

    public void setMb(double mb) {
        Mb = mb;
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: "+ getId());
        System.out.println("Name: "+ getName());
        System.out.println("Weight: "+ getMb());
        System.out.println("Price: "+ getPrice());
        System.out.println("----------------------------------");
    }
}
