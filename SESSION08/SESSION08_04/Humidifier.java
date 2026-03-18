package SESSION08.SESSION08_04;

class Humidifier implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Máy tạo ẩm: Điều chỉnh độ ẩm cho nhiệt độ " + temperature);
    }
}