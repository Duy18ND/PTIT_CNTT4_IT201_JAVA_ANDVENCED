package SESSION04.DEMO.ListService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ListService {

    // Khởi tạo một cái giỏ rỗng để chứa dữ liệu
    private List<String> names = new ArrayList<>();

    // 1. THÊM DỮ LIỆU (Có ràng buộc logic)
    public void addName(String name) {
        // Bắt lỗi 1: Tên không được rỗng hoặc chứa toàn dấu cách
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên không được để trống!");
        }
        // Bắt lỗi 2: Không cho phép thêm người trùng tên
        if (names.contains(name)) {
            throw new IllegalArgumentException("Tên này đã tồn tại!");
        }
        names.add(name);
    }

    // 2. XÓA DỮ LIỆU
    public boolean removeName(String name) {
        // Hàm remove của List sẽ trả về true nếu xóa thành công, false nếu không tìm thấy
        return names.remove(name);
    }

    // 3. LẤY DANH SÁCH (Bảo mật dữ liệu)
    public List<String> getAllNames() {
        // Mẹo thực chiến: Trả về một danh sách "Chỉ đọc" (Unmodifiable)
        // Để ngăn chặn kẻ xấu ở ngoài gọi hàm này xong tự ý .add() thêm vào danh sách gốc
        return Collections.unmodifiableList(names);
    }

    // 4. TÌM KIẾM (Ứng dụng Stream và Optional đã học)
    public Optional<String> findName(String keyword) {
        return names.stream()
                // Chuyển hết về chữ thường để tìm kiếm không phân biệt hoa/thường
                .filter(n -> n.toLowerCase().contains(keyword.toLowerCase()))
                .findFirst();
    }

    // 5. LẤY SỐ LƯỢNG
    public int size() {
        return names.size();
    }
}