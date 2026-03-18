package SESSION08.DEMO.TongHop.model;

public class Light implements Device {
    private boolean isOn;

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Tắt đèn");
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Bật đèn");
    }
}
