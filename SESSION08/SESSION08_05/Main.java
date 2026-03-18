package SESSION08.SESSION08_05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // thiết bị
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        // sensor
        TemperatureSensor sensor = new TemperatureSensor();
        sensor.attach(fan);
        sensor.attach(ac);

        // tạo command
        Command sleepMode = new SleepModeCommand(Arrays.asList(
                new LightOffCommand(light),
                new ACSetCommand(ac),
                new FanLowCommand(fan)
        ));

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Kích hoạt chế độ ngủ");
            System.out.println("2. Thay đổi nhiệt độ");
            System.out.println("3. Xem trạng thái");
            System.out.println("4. Thoát");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sleepMode.execute();
                    break;

                case 2:
                    System.out.print("Nhập nhiệt độ: ");
                    int t = sc.nextInt();
                    sensor.setTemperature(t);
                    break;

                case 3:
                    System.out.println(fan.getStatus());
                    System.out.println(ac.getStatus());
                    break;

                case 4:
                    return;
            }
        }
    }
}