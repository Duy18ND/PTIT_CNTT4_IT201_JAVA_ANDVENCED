package SESSION13.SESSION13_04;

public class Main {
    static void main(String[] args) {
        /*
        Phân tích &Đề xuất (Đa giải pháp)
        Input:
            Trạng thái/Khoa(Ví dụ:Lấy tất cả bệnh nhân đang ở trạng thái 'DANG_CAP_CUU').Không cần truyền tham số cụ
            thể từng người.
        Output:
            List<BenhNhanDTO>,với mỗi DTO chứa các field cơ bản (mã, tên)và một List<DichVu> dsDichVu.

        So sánh &Lựa chọn
            Giải pháp 1: Dùng LEFT JOIN để nối bảng BenhNhan và DichVuSuDung. Result Set trả về sẽ bị lặp lặp thông tin bệnh nhân
            Giải pháp 2:
             + SELECT * FROM BenhNhan. Đưa tất cả vào một List<BenhNhanDTO> và gom tất cả ID thành một mảng.
             + SELECT * FROM DichVuSuDung WHERE maBenhNhan IN (id1, id2, id3...)
               Duyệt Result Set này và map dịch vụ tương ứng vào đúng Object Bệnh nhân ở Bước 1
               
             + Chọn Giải pháp 1 (LEFT JOIN + In-Memory Grouping).
             + Lý do: Số lượng 500 bệnh nhân (kể cả nhân bản lên thành 3000-5000 dòng dữ liệu dịch vụ) đối với sức mạnh xử lý 
             RAM của Java và Network hiện nay chỉ tốn chưa tới 0.05 giây. Giải pháp này giải quyết Bẫy 2 (Mất dữ liệu) một 
             cách tự nhiên và an toàn nhất ở ngay tầng Database.

        Thiết kế &Triển khai
        */
        DashboardService service = new DashboardService();
        service.hienThiDashboard();
    }
}
