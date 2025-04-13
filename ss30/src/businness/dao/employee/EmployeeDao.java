package businness.dao.employee;
import businness.model.employees.Employees;
import businness.model.employees.Gender;
import businness.model.employees.EmployeesStatus;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface EmployeeDao {
    List<Employees> searchEmployeeByName(String name);
    List<Employees> searchEmployeeByAge(int age);
    List<Employees> sortEmployeesBySalaryDesc();
    List<Employees> sortEmployeesByNameAsc();
    List<Employees> getEmployeesByPage(int page);
    int getPageEmployees();
    void addEmployee(Employees employee);
    Employees getEmployeeById(String employeeId);
    void updateEmployeeName(String employeeId, String name);
    void updateEmployeeEmail(String employeeId, String email);
    void updateEmployeePhoneNumber(String employeeId, String phoneNumber);
    void updateEmployeeSex(String employeeId, Gender sex);
    void updateEmployeeSalaryGrade(String employeeId, int salaryGrade);
    void updateEmployeeSalary(String employeeId, BigDecimal salary);
    void updateEmployeeBirthDate(String employeeId, Date birthDate);
    void updateEmployeeAddress(String employeeId, String address);
    void updateEmployeeStatus(String employeeId, EmployeesStatus status);
    void updateEmployeeDepartmentId(String employeeId, int departmentId);
    void deleteEmployee(String employeeId);


}
