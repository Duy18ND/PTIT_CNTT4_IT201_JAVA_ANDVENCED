package SESSION08.SESSION08_05;

class Fan implements Observer {
    private String speed = "Tắt";

    public void setLow() {
        speed = "Thấp";
        System.out.println("Quạt: Chạy tốc độ thấp");
    }

    public void setHigh() {
        speed = "Mạnh";
        System.out.println("Quạt: Nhiệt độ cao, chạy tốc độ mạnh");
    }

    @Override
    public void update(int temp) {
        if (temp > 30) {
            setHigh();
        }
    }

    public String getStatus() {
        return "Quạt: " + speed;
    }
}