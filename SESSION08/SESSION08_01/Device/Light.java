package SESSION08.SESSION08_01.Device;

public class Light implements Device {
    @Override
    public void turnOn() {
        System.out.println("Đèn: Bật sáng");
    }

    @Override
    public void turnOff() {
        System.out.println("Đèn: Tắt sáng");
    }

    @Override
    public String getName() {
        return "Đèn";
    }
}
