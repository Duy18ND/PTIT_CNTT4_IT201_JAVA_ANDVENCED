package SESSION13.SESSION13_04;

import java.util.List;

public class BenhNhanDTO {
    private int maBenhNhan;
    private String tenBenhNhan;
    private String tinhTrang;

    // Khai báo List để chứa nhiều Dịch vụ bên trong 1 Bệnh nhân
    private List<DichVu> dsDichVu;

    public BenhNhanDTO() {}

    // Getters và Setters
    public int getMaBenhNhan() { return maBenhNhan; }
    public void setMaBenhNhan(int maBenhNhan) { this.maBenhNhan = maBenhNhan; }
    public String getTenBenhNhan() { return tenBenhNhan; }
    public void setTenBenhNhan(String tenBenhNhan) { this.tenBenhNhan = tenBenhNhan; }
    public String getTinhTrang() { return tinhTrang; }
    public void setTinhTrang(String tinhTrang) { this.tinhTrang = tinhTrang; }
    public List<DichVu> getDsDichVu() { return dsDichVu; }
    public void setDsDichVu(List<DichVu> dsDichVu) { this.dsDichVu = dsDichVu; }
}