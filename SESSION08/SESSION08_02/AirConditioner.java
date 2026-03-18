package SESSION08.SESSION08_02;

class AirConditioner {
    public void turnOff() {
        System.out.println("FACADE: Tắt điều hòa");
    }

    public void setTemperature(int temp) {
        System.out.println("FACADE: Điều hòa set " + temp + "°C");
    }
}
