package SESSION08.SESSION08_01.Factory;

import SESSION08.SESSION08_01.Device.Device;
import SESSION08.SESSION08_01.Device.Light;

public class LightFactory extends DeviceFactory{
    @Override
    public Device createDevice() {
        System.out.println("LightFactory: Đã khởi tạo Đèn");
        return new Light();
    }
}
