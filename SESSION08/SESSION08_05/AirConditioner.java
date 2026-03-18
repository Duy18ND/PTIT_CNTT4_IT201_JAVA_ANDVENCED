package SESSION08.SESSION08_05;

class AirConditioner implements Observer {
    private int temperature = 25;

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Điều hòa: Nhiệt độ = " + temp);
    }

    @Override
    public void update(int temp) {
        if (temp > 30) {
            System.out.println("Điều hòa: Nhiệt độ = " + temperature);
        }
    }

    public String getStatus() {
        return "Điều hòa: " + temperature + "°C";
    }
}