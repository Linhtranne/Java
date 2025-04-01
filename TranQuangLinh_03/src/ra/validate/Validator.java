package ra.validate;

import ra.entity.Employee;
import java.time.LocalTime;

public class Validator {
    public static boolean checkEmployeeId(Employee employee) {
        return employee.getEmployeeId().matches("^NV\\d{4}$");
    }

    public static boolean checkEmployeeName(Employee employee) {
        return employee.getEmployeeName().matches("^[a-zA-Z\\s]+$");
    }

    public static boolean checkPhoneNumber(Employee employee) {
        return employee.getPhoneNumber().matches("^0[3,5,7,8,9]\\d{8}$");
    }

    public static boolean checkBirthday(Employee employee) {
        return employee.getBirthday().matches("^\\d{2}/\\d{2}/\\d{4}$");
    }

    public static boolean checkSex(Employee employee) {
        return employee.getSex() || !employee.getSex();
    }

    public static boolean checkCoefficient(Employee employee) {
        return employee.getCoefficient() > 0;
    }

    public static boolean checkDepartment(Employee employee) {
        return employee.getDepartment().matches("^[a-zA-Z\\s]+$");
    }

    public static boolean checkAllowanceSalary(Employee employee) {
        return employee.getAllowanceSalary() > 0;
    }

    public static boolean checkStatus(Employee employee) {
        return employee.getStatus() >= 1 && employee.getStatus() <= 3;
    }
}