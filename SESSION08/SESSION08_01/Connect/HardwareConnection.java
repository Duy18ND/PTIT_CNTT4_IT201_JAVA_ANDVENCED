package SESSION08.SESSION08_01.Connect;

public class HardwareConnection {
    private static HardwareConnection instance;
    private boolean isConnected = false;

    private HardwareConnection() {
    }

    public static HardwareConnection getInstance() {
        if (instance == null) {
            instance = new HardwareConnection();
        }
        return instance;
    }

    public void Connected() {
        if (!isConnected) {
            System.out.println("HardwareConnection: Đã kết nối phần cứng.");
            isConnected = true;
        }
    }

    public void Disconnected() {
        if (isConnected) {
            System.out.println("HardwareConnection: Đã ngắt kết nối phần cứng.");
            isConnected = false;
        }
    }

    public boolean isConnected() {
        return isConnected;
    }
}
