package SESSION13.SESSION13_04;

import java.util.List;

public class DashboardService {
    private final DashboardDAO dashboardDAO = new DashboardDAO();
    public void hienThiDashboard() {
        System.out.println("Đang tải dữ liệu cấp cứu...");
        List<BenhNhanDTO> danhSach = dashboardDAO.getDashboardData();

        if (danhSach.isEmpty()) {
            System.out.println("Không có bệnh nhân nào đang cấp cứu.");
            return;
        }

        System.out.println("=== DANH SÁCH BỆNH NHÂN CẤP CỨU (" + danhSach.size() + " người) ===");
        for (BenhNhanDTO bn : danhSach) {
            System.out.println("\nBệnh nhân: " + bn.getTenBenhNhan() + " (Mã: " + bn.getMaBenhNhan() + ") - Tình trạng: " + bn.getTinhTrang());

            List<DichVu> dsDichVu = bn.getDsDichVu();
            if (dsDichVu.isEmpty()) {
                System.out.println("Chưa có chỉ định dịch vụ/thuốc nào.");
            } else {
                for (DichVu dv : dsDichVu) {
                    System.out.println("   - Dịch vụ: " + dv.getTenDichVu() + " | Giờ CĐ: " + dv.getThoiGianChiDinh());
                }
            }
        }
    }
}