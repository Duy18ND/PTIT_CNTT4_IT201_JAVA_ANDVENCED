package SESSION12.DEMO.entity;

import java.util.Date;

public class Employees {
    private Integer employee_id;
    private String full_name;
    private Boolean gender;
    private Date birthday;
    private String address;
    private String company;
    private Double salary;

    public Employees() {
    }
    public Employees(Integer employee_id, String full_name, Boolean gender, Date birthday, String address, String company, Double salary) {
        this.employee_id = employee_id;
        this.full_name = full_name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
