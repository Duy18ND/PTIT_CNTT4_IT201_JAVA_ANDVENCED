package SESSION08.SESSION08_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        RemoteControl remote = new RemoteControl();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Gán nút");
            System.out.println("2. Nhấn nút");
            System.out.println("3. Undo");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Chọn nút:");
                    int slot = sc.nextInt();

                    System.out.println("1.Light ON 2.Light OFF 3.Fan ON 4.Fan OFF 5.AC Set Temp");
                    int type = sc.nextInt();

                    Command cmd = null;

                    switch (type) {
                        case 1: cmd = new LightOnCommand(light); break;
                        case 2: cmd = new LightOffCommand(light); break;
                        case 3: cmd = new FanOnCommand(fan); break;
                        case 4: cmd = new FanOffCommand(fan); break;
                        case 5:
                            System.out.print("Nhập nhiệt độ: ");
                            int t = sc.nextInt();
                            cmd = new ACSetTemperatureCommand(ac, t);
                            break;
                    }

                    remote.setCommand(slot, cmd);
                    break;

                case 2:
                    System.out.print("Nhấn nút: ");
                    int press = sc.nextInt();
                    remote.pressButton(press);
                    break;

                case 3:
                    remote.undo();
                    break;

                case 4:
                    return;
            }
        }
    }
}