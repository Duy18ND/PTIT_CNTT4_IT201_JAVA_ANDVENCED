package SESSION11.SESSION11_05;

import SESSION11.SESSION11_02.Main;

import java.sql.*;

public class DoctorDAO {
    private Main DBConnection;
    private Connection conn = DBConnection.getConnection();

    public void getAllDoctors() {
        String sql = "SELECT doctor_id, full_name, specialty FROM Doctors";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.printf("%-10s | %-20s | %-20s\n", "Mã BS", "Họ Tên", "Chuyên Khoa");
            while (rs.next()) {
                System.out.printf("%-10d | %-20s | %-20s\n",
                        rs.getInt("doctor_id"), rs.getString("full_name"), rs.getString("specialty"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public boolean addDoctor(Doctor doc) {
        String sql = "INSERT INTO Doctors (doctor_id, full_name, specialty) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, doc.getDoctorId());
            pstmt.setString(2, doc.getFullName());
            pstmt.setString(3, doc.getSpecialty());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi thêm bác sĩ (Có thể trùng ID): " + e.getMessage());
            return false;
        }
    }

    public void getSpecialtyStats() {
        String sql = "SELECT specialty, COUNT(*) as total FROM Doctors GROUP BY specialty";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.printf("%-20s | %-10s\n", "Chuyên Khoa", "Số lượng BS");
            while (rs.next()) {
                System.out.printf("%-20s | %-10d\n", rs.getString("specialty"), rs.getInt("total"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
}