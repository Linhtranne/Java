package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class validator {
    public static boolean isValidDepartmentName(String name) {
        return name != null && name.length() >= 10 && name.length() <= 100;
    }

    public static boolean isValidDepartmentDescription(String desc) {
        return desc == null || desc.length() <= 255;
    }
    public static boolean isValidEmployeeId(String id) {
        return id != null && id.matches("^E\\d{4}$");
    }

    public static boolean isValidEmployeeName(String name) {
        return name != null && name.length() >= 15 && name.length() <= 150;
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(regex);
    }

    public static boolean isValidPhone(String phone) {
        String regex = "^(0[3|5|7|8|9])[0-9]{8}$";
        return phone != null && phone.matches(regex);
    }

    public static boolean isValidSalaryLevel(int level) {
        return level > 0;
    }

    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }

    public static boolean isValidDOB(String dobStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dob = LocalDate.parse(dobStr, formatter);
            return dob.isBefore(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isValidAddress(String address) {
        return address != null && !address.trim().isEmpty();
    }


}
