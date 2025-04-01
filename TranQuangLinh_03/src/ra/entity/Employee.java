package ra.entity;

import java.util.Scanner;
import ra.validate.Validator;
public class Employee implements IApp {
    private String employeeId;
    private String employeeName;
    private String birthday;
    private String phoneNumber;
    private boolean sex;
    private float coefficient;
    private int allowanceSalary = 0;
    private String department;
    private byte status = 1;
    public Employee() {}

    public Employee(String employeeId, String employeeName, String birthday, String phoneNumber, boolean sex, float coefficient, int allowanceSalary, String department, byte status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.coefficient = coefficient;
        this.allowanceSalary = allowanceSalary;
        this.department = department;
        this.status = status;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public int getAllowanceSalary() {
        return allowanceSalary;
    }

    public void setAllowanceSalary(int allowanceSalary) {
        this.allowanceSalary = allowanceSalary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
    @Override
    public void inputData(Scanner sc) {
        while (true) {
            System.out.print("Nhập mã nhân viên: ");
            this.employeeId = sc.nextLine();
            if (Validator.checkEmployeeId(this)) break;
            else System.out.println("Mã nhân viên không hợp lệ. Nó phải bắt đầu bằng 'NV' và theo sau là 4 chữ số.");
        }

        while (true) {
            System.out.print("Nhập tên nhân viên: ");
            this.employeeName = sc.nextLine();
            if (Validator.checkEmployeeName(this)) break;
            else System.out.println("Tên nhân viên không hợp lệ. Nó không được để trống.");
        }

        while (true) {
            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            this.birthday = sc.nextLine();
            if (Validator.checkBirthday(this)) break;
            else System.out.println("Ngày sinh không hợp lệ. Nó phải có định dạng dd/MM/yyyy.");
        }

        while (true) {
            System.out.print("Nhập số điện thoại: ");
            this.phoneNumber = sc.nextLine();
            if (Validator.checkPhoneNumber(this)) break;
            else System.out.println("Số điện thoại không hợp lệ. Nó phải là số điện thoại hợp lệ của Việt Nam.");
        }
            System.out.print("Nhập giới tính (true cho nam, false cho nữ): ");
            this.sex = sc.nextBoolean();

        while (true) {
            System.out.print("Nhập hệ số lương: ");
            this.coefficient = sc.nextFloat();
            if (Validator.checkCoefficient(this)) break;
            else System.out.println("Hệ số lương không hợp lệ. Nó phải lớn hơn 0.");
        }

        while (true) {
            System.out.print("Nhập phụ cấp lương: ");
            this.allowanceSalary = sc.nextInt();
            if (Validator.checkAllowanceSalary(this)) break;
            else System.out.println("Phụ cấp lương không hợp lệ. Nó phải lớn hơn 0.");
        }

        sc.nextLine();

        while (true) {
            System.out.print("Nhập phòng ban: ");
            this.department = sc.nextLine();
            if (Validator.checkDepartment(this)) break;
            else System.out.println("Phòng ban không hợp lệ. Nó không được để trống.");
        }
    }

    @Override
    public void displayData() {
        float totalSalary = BASE_SALARY * coefficient + allowanceSalary;
        System.out.println("ID nhân viên: " + employeeId);
        System.out.println("Tên nhân viên: " + employeeName);
        System.out.println("Ngày sinh: " + birthday);
        System.out.println("Số điện thoại: " + phoneNumber);
        System.out.println("Giới tính: " + (sex ? "Nam" : "Nữ"));
        System.out.println("Tổng lương: " + totalSalary);
        System.out.println("Phòng ban: " + department);
        System.out.println("Trạng thái: " + (status == 1 ? "đang làm việc" : status == 2 ? "đang nghỉ phép" : "đã nghỉ việc"));
        System.out.println("--------------------------------------------------------");
    }

    public int calculateSalary() {
        return (int) (BASE_SALARY * coefficient + allowanceSalary);
    }
}
