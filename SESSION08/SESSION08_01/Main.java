package SESSION08.SESSION08_01;

import SESSION08.SESSION08_01.Connect.HardwareConnection;
import SESSION08.SESSION08_01.Device.Device;
import SESSION08.SESSION08_01.Factory.AirConditionerFactory;
import SESSION08.SESSION08_01.Factory.DeviceFactory;
import SESSION08.SESSION08_01.Factory.FanFactory;
import SESSION08.SESSION08_01.Factory.LightFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Device> deviceList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            Menu();
            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> HardwareConnection.getInstance().Connected();
                    case 2 -> case2();
                    case 3 -> case3();
                    case 4 -> System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    default -> System.out.println("Lựa chọn của bạn không hợp lệ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Lựa chọn của bạn không hợp lệ. Vui lòng nhập số nguyên");
                choice = 0;
            }
        } while (choice != 4);
    }

    public static void Menu() {
        System.out.println("\n===== HỆ THỐNG SMART HOME =====");
        System.out.println("1. Kết nối phần cứng");
        System.out.println("2. Tạo thiết bị mới");
        System.out.println("3. Bật/Tắt thiết bị");
        System.out.println("4. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public static void case2(){
        //Kiểm tra đã kết nối phần cứng chưa?
        if (!HardwareConnection.getInstance().isConnected()) {
            System.out.println("Lỗi: Bạn phải kết nối phần cứng trước khi thêm!");
            return;
        }
        try {
            System.out.println("Chọn loại: 1. Đèn, 2. Quạt, 3. Điều hòa");
            System.out.print("Chọn: ");
            int type = Integer.parseInt(sc.nextLine());

            DeviceFactory factory = null;
            if (type == 1) factory = new LightFactory();
            else if (type == 2) factory = new FanFactory();
            else if (type == 3) factory = new AirConditionerFactory();
            else {
                System.out.println("Lựa chọn của bạn không hợp lệ!");
                return;
            }
            Device newDevice = factory.createDevice();
            deviceList.add(newDevice);
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số 1 or 2 or 3");
        }
    }
    public static void case3(){
        if (!HardwareConnection.getInstance().isConnected()) {
            System.out.println("Lỗi: Bạn phải kết nối phần cứng trước khi thêm!");
            return;
        }
        if (deviceList.isEmpty()) {
            System.out.println("Thiết bị chưa được khởi tạo");
            return;
        }

        for (int i = 0; i < deviceList.size(); i++) {
            System.out.println((i + 1) + ". " + deviceList.get(i).getName());
        }
        System.out.print("Chọn thiết bị để điều khiển: ");
        try {
            int index = Integer.parseInt(sc.nextLine()) - 1;
            Device selectDevice = deviceList.get(index);

            System.out.print("Hành động: (1. Bật || 2. Tắt): ");
            String action = sc.nextLine();

            if (action.equals("1")) selectDevice.turnOn();
            else if (action.equals("2")) selectDevice.turnOff();
            else System.out.println("Hành động không hợp lệ!");

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Nhập sai định dạng");
        }
    }
}