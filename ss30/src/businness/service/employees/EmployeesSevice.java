package businness.service.employees;

import businness.model.employees.Employees;
import businness.model.employees.Gender;
import businness.model.employees.EmployeesStatus;
import businness.service.AppSevice;

import java.sql.Date;
import java.util.List;

public interface EmployeesSevice extends AppSevice {

    int getPageEmployees();
    List<Employees> getEmployeesByPage(int page);

    void addEmployee(Employees employee);

    Employees getEmployeeById(String employeeId);

    void updateEmployeeName(String employeeId, String name);
    void updateEmployeeEmail(String employeeId, String email);
    void updateEmployeePhoneNumber(String employeeId, String phoneNumber);
    void updateEmployeeSex(String employeeId, Gender sex);
    void updateEmployeeSalaryGrade(String employeeId, int salaryGrade);
    void updateEmployeeSalary(String employeeId, Double salary);
    void updateEmployeeBirthDate(String employeeId, Date birthDate);
    void updateEmployeeAddress(String employeeId, String address);
    void updateEmployeeStatus(String employeeId, EmployeesStatus status);
    void updateEmployeeDepartmentId(String employeeId, int departmentId);

    void deleteEmployee(String employeeId);

    List<Employees> searchEmployeeByName(String name);
    List<Employees> searchEmployeeByAge(int age);

    List<Employees> sortEmployeesBySalaryDesc();
    List<Employees> sortEmployeesByNameAsc();
}
