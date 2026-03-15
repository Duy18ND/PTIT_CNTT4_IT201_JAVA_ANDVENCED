package SESSION06.SESSION06_06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulationManager {
    private static SimulationManager instance;
    private ExecutorService executorService;
    private List<TicketPool> pools;
    private boolean isPaused = false;
    private boolean isRunning = false;
    private final Object pauseLock = new Object();

    private SimulationManager() {
        pools = new ArrayList<>();
    }

    public static synchronized SimulationManager getInstance() {
        if (instance == null) {
            instance = new SimulationManager();
        }
        return instance;
    }

    public void initSimulation(int numRooms, int ticketsPerRoom, int numCounters) {
        pools.clear();
        for (int i = 0; i < numRooms; i++) {
            char roomChar = (char) ('A' + i);
            TicketPool pool = new TicketPool(String.valueOf(roomChar));
            pool.addTickets(ticketsPerRoom);
            pools.add(pool);
        }

        executorService = Executors.newFixedThreadPool(numCounters);
        isRunning = true;
        isPaused = false;

        System.out.println("Đã khởi tạo hệ thống với " + numRooms + " phòng, "
                + (numRooms * ticketsPerRoom) + " vé, " + numCounters + " quầy.");

        for (int i = 1; i <= numCounters; i++) {
            executorService.execute(new BookingCounter("Quầy " + i, pools, this));
        }
    }

    public void checkPause() {
        synchronized (pauseLock) {
            while (isPaused) {
                try {
                    pauseLock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void pauseSimulation() {
        isPaused = true;
        System.out.println("Đã tạm dừng tất cả quầy bán vé.");
    }

    public void resumeSimulation() {
        synchronized (pauseLock) {
            isPaused = false;
            pauseLock.notifyAll();
            System.out.println("Đã tiếp tục hoạt động.");
        }
    }

    public void stopSimulation() {
        isRunning = false;
        resumeSimulation();
        if (executorService != null) {
            executorService.shutdownNow();
        }
        System.out.println("Đang dừng hệ thống...");
    }

    public void addTicketsToRoom(String roomName, int count) {
        for (TicketPool pool : pools) {
            if (pool.getRoomName().equalsIgnoreCase(roomName)) {
                pool.addTickets(count);
                System.out.println("Đã thêm " + count + " vé vào phòng " + roomName);
                return;
            }
        }
        System.out.println("Không tìm thấy phòng " + roomName);
    }

    public void printStats() {
        System.out.println("\n=== THỐNG KÊ HIỆN TẠI ===");
        long totalRev = 0;
        for (TicketPool pool : pools) {
            System.out.println("Phòng " + pool.getRoomName() + ": Đã bán "
                    + pool.getSoldCount() + "/" + pool.getInitialCount() + " vé");
            totalRev += pool.getTotalRevenue();
        }
        System.out.println("Tổng doanh thu: " + String.format("%,d VNĐ", totalRev));
        System.out.println("=========================\n");
    }

    public boolean isRunning() { return isRunning; }
}