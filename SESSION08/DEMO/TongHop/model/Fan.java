package SESSION08.DEMO.TongHop.model;

public class Fan implements Device {
    private LevelWind levelWind;
    private boolean isOn;

    public Fan(LevelWind levelWind, boolean isOn) {
        this.levelWind = levelWind;
        this.isOn = isOn;
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Tắt quạt");
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Bật quạt");
    }
}
