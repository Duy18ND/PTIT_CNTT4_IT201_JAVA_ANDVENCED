package SESSION08.SESSION08_01.Device;

public class AriConditioner implements Device {
    @Override
    public void turnOn() {
        System.out.println("Điều hòa: Khởi động");
    }

    @Override
    public void turnOff() {
        System.out.println("Điều hòa: Tắt điều hòa");
    }

    @Override
    public String getName() {
        return "Điều hòa";
    }
}
