package SESSION13.SESSION13_04;
import java.sql.Timestamp;
public class DichVu {
    private int maDichVu;
    private String tenDichVu;
    private Timestamp thoiGianChiDinh;

    public DichVu() {}

    // Getters và Setters
    public int getMaDichVu() { return maDichVu; }
    public void setMaDichVu(int maDichVu) { this.maDichVu = maDichVu; }
    public String getTenDichVu() { return tenDichVu; }
    public void setTenDichVu(String tenDichVu) { this.tenDichVu = tenDichVu; }
    public Timestamp getThoiGianChiDinh() { return thoiGianChiDinh; }
    public void setThoiGianChiDinh(Timestamp thoiGianChiDinh) { this.thoiGianChiDinh = thoiGianChiDinh; }
}