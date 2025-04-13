package presentation;

import presentation.department.DepartmentMain;
import presentation.employee.EmployeeMain;
import presentation.statistic.StatisticMain;
import businness.dao.pesion.AccountDao;
import businness.dao.pesion.AccountDaoImp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountDao accountDao = new AccountDaoImp();

        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.print("Tài khoản: ");
            String username = scanner.nextLine();
            System.out.print("Mật khẩu: ");
            String password = scanner.nextLine();

            int loginResult = accountDao.login(username, password);
            if (loginResult == 1) {
                System.out.println(" Đăng nhập thành công!");
                isLoggedIn = true;
            } else {
                System.out.println(" Sai tài khoản hoặc mật khẩu, vui lòng thử lại.");
            }
        }

        int choice;
        do {
            System.out.println(" HỆ THỐNG QUẢN LÝ");
            System.out.println("1. Quản lý phòng ban");
            System.out.println("2. Quản lý nhân viên");
            System.out.println("3. Thống kê");
            System.out.println("0. Đăng xuất và thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    DepartmentMain.run();
                    break;
                case 2:
                    EmployeeMain.run();
                    break;
                case 3:
                    StatisticMain.run();
                    break;
                case 0:
                    accountDao.logout();
                    System.out.println(" Đăng xuất thành công");
                    break;
                default:
                    System.out.println(" Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }
}
