package Ex10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Employees> EmployeesMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm nhân viên mới");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Tính tổng lương của tất cả nhân viên");
            System.out.println("4. Tính lương trung bình");
            System.out.println("5. Tìm nhân viên có lương cao nhất");
            System.out.println("6. Tìm nhân viên có lương thấp nhất");
            System.out.println("7. Thoát");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addEmployees();
                    break;
                case 2:
                    displayEmployeess();
                    break;
                case 3:
                    calculateTotalSalary();
                    break;
                case 4:
                    calculateAverageSalary();
                    break;
                case 5:
                    findHighestSalaryEmployees();
                    break;
                case 6:
                    findLowestSalaryEmployees();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void addEmployees() {
        scanner.nextLine(); // Consume newline
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        double salary;
        while (true) {
            System.out.print("Nhập lương nhân viên: ");
            salary = scanner.nextDouble();
            if (salary >= 0) break;
            System.out.println("Lương phải là số không âm. Vui lòng nhập lại.");
        }
        Employees Employees = new Employees(name, salary);
        EmployeesMap.put(Employees.getId(), Employees);
        System.out.println("Nhân viên đã được thêm: " + Employees);
    }

    private static void displayEmployeess() {
        if (EmployeesMap.isEmpty()) {
            System.out.println("Không có nhân viên nào.");
        } else {
            for (Employees Employees : EmployeesMap.values()) {
                System.out.println(Employees);
            }
        }
    }

    private static void calculateTotalSalary() {
        double totalSalary = 0;
        for (Employees Employees : EmployeesMap.values()) {
            totalSalary += Employees.getSalary();
        }
        System.out.println("Tổng lương của tất cả nhân viên: " + totalSalary);
    }

    private static void calculateAverageSalary() {
        if (EmployeesMap.isEmpty()) {
            System.out.println("Không có nhân viên nào.");
            return;
        }
        double totalSalary = 0;
        for (Employees Employees : EmployeesMap.values()) {
            totalSalary += Employees.getSalary();
        }
        double averageSalary = totalSalary / EmployeesMap.size();
        System.out.println("Lương trung bình của tất cả nhân viên: " + averageSalary);
    }

    private static void findHighestSalaryEmployees() {
        if (EmployeesMap.isEmpty()) {
            System.out.println("Không có nhân viên nào.");
            return;
        }
        Employees highestSalaryEmployees = null;
        for (Employees Employees : EmployeesMap.values()) {
            if (highestSalaryEmployees == null || Employees.getSalary() > highestSalaryEmployees.getSalary()) {
                highestSalaryEmployees = Employees;
            }
        }
        System.out.println("Nhân viên có lương cao nhất: " + highestSalaryEmployees);
    }

    private static void findLowestSalaryEmployees() {
        if (EmployeesMap.isEmpty()) {
            System.out.println("Không có nhân viên nào.");
            return;
        }
        Employees lowestSalaryEmployees = null;
        for (Employees Employees : EmployeesMap.values()) {
            if (lowestSalaryEmployees == null || Employees.getSalary() < lowestSalaryEmployees.getSalary()) {
                lowestSalaryEmployees = Employees;
            }
        }
        System.out.println("Nhân viên có lương thấp nhất: " + lowestSalaryEmployees);
    }
}