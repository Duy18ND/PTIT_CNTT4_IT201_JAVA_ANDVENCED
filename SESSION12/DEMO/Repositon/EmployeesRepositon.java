package SESSION12.DEMO.Repositon;
import SESSION12.DEMO.entity.Employees;
import java.util.List;

public interface EmployeesRepositon {
    List<Employees> getAllEmployee();
    boolean addEmployee(Employees employee);
    boolean updateEmployee(Employees employee);
    boolean deleteEmployee(int id);
}
