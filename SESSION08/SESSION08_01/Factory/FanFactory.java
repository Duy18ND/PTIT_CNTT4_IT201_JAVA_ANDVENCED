package SESSION08.SESSION08_01.Factory;

import SESSION08.SESSION08_01.Device.Device;
import SESSION08.SESSION08_01.Device.Fan;

public class FanFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        System.out.println("FanFactory: Đã khởi tạo Quạt");
        return new Fan();
    }
}
