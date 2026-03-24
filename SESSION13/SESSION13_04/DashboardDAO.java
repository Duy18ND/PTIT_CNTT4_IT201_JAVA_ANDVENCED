package SESSION13.SESSION13_04;

import SESSION13.SESSION13_03.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class DashboardDAO {

    public List<BenhNhanDTO> getDashboardData() {
        Map<Integer, BenhNhanDTO> patientMap = new LinkedHashMap<>();

        String sql = "SELECT bn.ma_benh_nhan, bn.ten_benh_nhan, bn.tinh_trang, " +
                "dv.ma_dich_vu, dv.ten_dich_vu, dv.thoi_gian_chi_dinh " +
                "FROM BenhNhan bn " +
                "LEFT JOIN DichVuSuDung dv ON bn.ma_benh_nhan = dv.ma_benh_nhan " +
                "WHERE bn.trang_thai_khoa = 'DANG_CAP_CUU' " +
                "ORDER BY bn.thoi_gian_nhap_vien DESC";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int maBenhNhan = rs.getInt("ma_benh_nhan");

                BenhNhanDTO dto = patientMap.get(maBenhNhan);
                if (dto == null) {
                    dto = new BenhNhanDTO();
                    dto.setMaBenhNhan(maBenhNhan);
                    dto.setTenBenhNhan(rs.getString("ten_benh_nhan"));
                    dto.setTinhTrang(rs.getString("tinh_trang"));
                    dto.setDsDichVu(new ArrayList<>());
                    patientMap.put(maBenhNhan, dto);
                }

                int maDichVu = rs.getInt("ma_dich_vu");
                if (!rs.wasNull()) {
                    DichVu dv = new DichVu();
                    dv.setMaDichVu(maDichVu);
                    dv.setTenDichVu(rs.getString("ten_dich_vu"));
                    dv.setThoiGianChiDinh(rs.getTimestamp("thoi_gian_chi_dinh"));
                    dto.getDsDichVu().add(dv);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(patientMap.values());
    }
}