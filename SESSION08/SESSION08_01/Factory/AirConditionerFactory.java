package SESSION08.SESSION08_01.Factory;

import SESSION08.SESSION08_01.Device.AriConditioner;
import SESSION08.SESSION08_01.Device.Device;

public class AirConditionerFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        System.out.println("AirConditionerFactory: Đã khởi tạo Điều hòa");
        return new AriConditioner();
    }
}
