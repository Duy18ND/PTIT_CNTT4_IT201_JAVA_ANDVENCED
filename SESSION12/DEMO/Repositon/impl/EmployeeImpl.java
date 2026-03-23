package SESSION12.DEMO.Repositon.impl;

import SESSION11.Demo_CRUD.DBUtility;
import SESSION12.DEMO.Repositon.EmployeesRepositon;
import SESSION12.DEMO.entity.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl implements EmployeesRepositon {
    @Override
    public List<Employees> getAllEmployee() {
        List<Employees> employeesList = new ArrayList<>();
        Connection con = DBUtility.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from Employee";
            try {
                pstmt = con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Employees employee = new Employees();
                    employee.setEmployee_id(rs.getInt("employee_id"));
                    employee.setFull_name(rs.getString("full_name"));
                    employee.setGender(rs.getBoolean("gender"));
                    employee.setBirthday(rs.getDate("birthday"));
                    employee.setAddress(rs.getString("address"));
                    employee.setCompany(rs.getString("company"));
                    employee.setSalary(rs.getDouble("salary"));
                    employeesList.add(employee);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return employeesList;
    }

    @Override
    public boolean addEmployee(Employees employee) {
        return false;
    }
    @Override
    public boolean updateEmployee(Employees employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        return false;
    }
}
