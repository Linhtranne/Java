package ra.business;
import ra.entity.Employee;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class EmployeeBusiness {
    static List<Employee> employees = new ArrayList<>();
    static int MAX_EMPLOYEES = 100;

    public static void displayEmployeeList() {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
        } else {
            System.out.println("Danh sách nhân viên: ");
            for (Employee employee : employees) {
                employee.displayData();
            }
        }
    }

    public static void AddNewEmployee() {
        Scanner sc = new Scanner(System.in);
        if (employees.size() == MAX_EMPLOYEES) {
            System.out.println("Danh sách nhân viên đã đầy, không thể thêm mới nhân viên nữa.");
        } else {
            System.out.print("Nhập số lượng nhân viên cần thêm: ");
            int n = sc.nextInt();
            sc.nextLine();
            if (n <= 0 || n > MAX_EMPLOYEES) {
                System.out.println("Số lượng nhân viên cần thêm không hợp lệ. Vui lòng nhập lại.");
            } else {
                for (int i = 0; i < n; i++) {
                    Employee employee = new Employee();
                    employee.inputData(sc);
                    employees.add(employee);
                }
            }
        }
    }


    public static void editEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên cần chỉnh sửa: ");
        String employeeId = sc.nextLine();
        Employee employee = findEmployeeById(employeeId);
        if (employee == null) {
            System.out.println("Không tìm thấy nhân viên.");
        } else {
            System.out.println("Thông tin nhân viên hiện tại:");
            employee.displayData();
            System.out.println("Chọn thuộc tính cần sửa:");
            System.out.println("1. Tên nhân viên");
            System.out.println("2. Ngày sinh");
            System.out.println("3. Số điện thoại");
            System.out.println("4. Giới tính");
            System.out.println("5. Hệ số lương");
            System.out.println("6. Phụ cấp lương");
            System.out.println("7. Phòng ban");
            System.out.print("Chọn thuộc tính: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên nhân viên mới: ");
                    employee.setEmployeeName(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhập ngày sinh mới (dd/MM/yyyy): ");
                    employee.setBirthday(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhập số điện thoại mới: ");
                    employee.setPhoneNumber(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhập giới tính mới (true cho nam, false cho nữ): ");
                    employee.setSex(sc.nextBoolean());
                    break;
                case 5:
                    System.out.print("Nhập hệ số lương mới: ");
                    employee.setCoefficient(sc.nextFloat());
                    break;
                case 6:
                    System.out.print("Nhập phụ cấp lương mới: ");
                    employee.setAllowanceSalary(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Nhập phòng ban mới: ");
                    employee.setDepartment(sc.nextLine());
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    return;
            }
            System.out.println("Chỉnh sửa thông tin nhân viên thành công.");
        }
    }

    public static void DeleteEmployee() {
        Scanner sc = new Scanner(System.in);
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
        } else {
            System.out.print("Nhập mã nhân viên cần xóa: ");
            String employeeId = sc.nextLine();
            boolean isExisted = false;
            for (Employee employee : employees) {
                if (employee.getEmployeeId().equals(employeeId)) {
                    isExisted = true;
                    employees.remove(employee);
                    System.out.println("Xóa nhân viên thành công.");
                    break;
                }
            }
            if (!isExisted) {
                System.out.println("Không tìm thấy nhân viên có mã " + employeeId);
            }
        }
    }

    public static void SearchEmployee() {
        Scanner sc = new Scanner(System.in);
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
        } else {
            System.out.println("1. Tìm kiếm theo tên nhân viên");
            System.out.println("2. Tìm kiếm theo phòng ban");
            System.out.println("3. Tìm kiếm theo khoảng lương");
            System.out.print("Chọn tiêu chí tìm kiếm: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên nhân viên cần tìm: ");
                    String employeeName = sc.nextLine();
                    boolean isExisted = false;
                    for (Employee employee : employees) {
                        if (employee.getEmployeeName().contains(employeeName)) {
                            isExisted = true;
                            employee.displayData();
                        }
                    }
                    if (!isExisted) {
                        System.out.println("Không tìm thấy kết quả phù hợp.");
                    }
                    break;
                case 2:
                    System.out.print("Nhập phòng ban cần tìm: ");
                    String department = sc.nextLine();
                    isExisted = false;
                    for (Employee employee : employees) {
                        if (employee.getDepartment().contains(department)) {
                            isExisted = true;
                            employee.displayData();
                        }
                    }
                    if (!isExisted) {
                        System.out.println("Không tìm thấy kết quả phù hợp.");
                    }
                    break;
                case 3:
                    System.out.print("Nhập lương thấp nhất: ");
                    int minSalary = sc.nextInt();
                    System.out.print("Nhập lương cao nhất: ");
                    int maxSalary = sc.nextInt();
                    isExisted = false;
                    for (Employee employee : employees) {
                        if (employee.calculateSalary() >= minSalary && employee.calculateSalary() <= maxSalary) {
                            isExisted = true;
                            employee.displayData();
                        }
                    }
                    if (!isExisted) {
                        System.out.println("Không tìm thấy kết quả phù hợp.");
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }

        }
    }
    public static void SortEmployee() {
        Scanner sc = new Scanner(System.in);
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
        } else {
            System.out.println("1. Sắp xếp theo tên nhân viên");
            System.out.println("2. Sắp xếp theo lương");
            System.out.print("Chọn tiêu chí sắp xếp: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    employees.sort(Comparator.comparing(Employee::getEmployeeName));
                    displayEmployeeList();
                    break;
                case 2:
                    employees.sort((e1, e2) -> Float.compare(e1.calculateSalary(), e2.calculateSalary()));
                    displayEmployeeList();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
    private static Employee findEmployeeById(String employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }
}
