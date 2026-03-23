package SESSION12.DEMO.Test;

import SESSION12.DEMO.Repositon.EmployeesRepositon;
import SESSION12.DEMO.Repositon.impl.EmployeeImpl;

public class Main {
    public static void main(String[] args) {
        EmployeesRepositon empList = new EmployeeImpl();
        System.out.println(empList.getAllEmployee());
    }
}
