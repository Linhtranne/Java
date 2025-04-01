package ra.presentation;

import java.util.Scanner;
import ra.business.EmployeeBusiness;

public class EmployeeApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------Employee Menu----------------------------");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm mới nhân viên");
            System.out.println("3. Chỉnh sửa thông tin nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên");
            System.out.println("6. Sắp xếp");
            System.out.println("0. Thoát chương trình");
            System.out.println("--------------------------------------------------------------------");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    EmployeeBusiness.displayEmployeeList();
                    break;
                case 2:
                    EmployeeBusiness.AddNewEmployee();
                    break;
                case 3:
                    EmployeeBusiness.editEmployee();
                    break;
                case 4:
                    EmployeeBusiness.DeleteEmployee();
                    break;
                case 5:
                    EmployeeBusiness.SearchEmployee();
                    break;
                case 6:
                    EmployeeBusiness.SortEmployee();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}