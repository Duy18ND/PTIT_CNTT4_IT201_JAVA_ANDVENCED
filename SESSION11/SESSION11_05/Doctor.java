package SESSION11.SESSION11_05;

public class Doctor {
    private int doctorId;
    private String fullName;
    private String specialty;

    public Doctor(int doctorId, String fullName, String specialty) {
        this.doctorId = doctorId;
        this.fullName = fullName;
        this.specialty = specialty;
    }
    public int getDoctorId() { return doctorId; }
    public String getFullName() { return fullName; }
    public String getSpecialty() { return specialty; }
}