package SESSION08.SESSION08_01.Device;

public class Fan implements Device {
    @Override
    public void turnOn() {
        System.out.println("Quạt: Bật quạt");
    }

    @Override
    public void turnOff() {
        System.out.println("Quạt: Tắt quạt");
    }

    @Override
    public String getName() {
        return "Quạt";
    }
}
