package SESSION08.SESSION08_05;

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        System.out.println("SleepMode: Tắt đèn");
        light.off();
    }
}