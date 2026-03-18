package SESSION08.DEMO.TongHop.model;

public class AirCondition implements Device {
    private boolean isOn;
    private float temperature;

    public AirCondition(boolean isOn, float temperature) {
        this.isOn = isOn;
        this.temperature = temperature;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Bật điều hòa");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Tắt điều hòa");
    }
}
