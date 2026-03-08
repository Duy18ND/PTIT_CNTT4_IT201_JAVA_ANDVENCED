package SESSION01.DEMO.ThucHanh;

import java.util.Date;
import java.util.Scanner;

public class Employee {
    private String empId; //4 ký tự bắt đầu chữ E
    private String fullName; // ít nhất 2 ký tự
    private boolean gender;
    private Date birthday;
    private String address; //Tối thiểu 2 ký tự
    private float yearlnWorks; //số thực > 0
    private double salary; //lương tối thiểu 0
    private Scanner sc = new Scanner(System.in);

    //    1.       Lớp có 2 constructor có tham số và không có tham số
    public Employee() {
    }

    public Employee(String empId, String fullName, boolean gender, Date birthday, String address, float yearlnWorks, double salary) {
        this.empId = empId;
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.yearlnWorks = yearlnWorks;
        this.salary = salary;
    }

//    2.       Có đầy đủ các hàm getter và setter

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getYearlnWorks() {
        return yearlnWorks;
    }

    public void setYearlnWorks(float yearlnWorks) {
        this.yearlnWorks = yearlnWorks;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //    3.       Cài đặt hàm input() để nhập dữ liệu
    public void input() {

    }

    //    4.       Override hàm toString() để hiển thị dữ liệ
    @Override
    public String toString() {
        return super.toString();
    }

    //    5.       Validate dữ liệu khi nhập vào
    public String inputId() {
        while (true) {
            System.out.println("Nhập ID nhân viên: (E + 3 ký tự, VD: E001)");
            String id = sc.nextLine();
            if (id.matches("^E.{3}$")) return id;
            System.out.println("Lỗi: Mã phải có 4 ký tự, bắt đầu bằng chữ E!");
        }
    }

    private String inputString(String fieldName, int minLength) {
        while (true) {
            System.out.print("Nhập " + fieldName + ": ");
            String str = sc.nextLine();
            if (str.length() >= minLength) return str;
            System.out.println("Lỗi: " + fieldName + " phải tối thiểu " + minLength + " ký tự!");
        }
    }
//    6.       Tất cả các trường dữ liệu bắt buộc phải nhập

//    7.       Tạo lớp Test có hàm main sau đó khai báo, khởi tạo đối tượng của lớp Employee và gọi test cho các hàm input(), toString()

}
