package Linhtq_Java8.ra.presentation;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import Linhtq_Java8.ra.entity.Customer;
import Linhtq_Java8.ra.business.CustomerBusiness;
import Linhtq_Java8.ra.entity.Order;
import Linhtq_Java8.ra.business.OrderBusiness;

public class ShopManagement {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        int choice;
        do {
            System.out.println("**********************SHOP MENU*******************");
            System.out.println("1. Quản lý khách hàng");
            System.out.println("2. Quản lý đơn hàng");
            System.out.println("3. Thoát");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    menuCustomerMenu();
                    break;
                case 2:
                    menuOrderMenu();
                    break;
                case 3:
                    System.exit(0);
            }
        } while (choice != 0);
        System.out.println("Vui long chọn lại");
    }
    public static void menuCustomerMenu(){
        int choice;
        do {
            System.out.println("***********************CUSTOMER MENU******************");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị danh sách khách hàng");
            System.out.println("3. Quay lại");
            Scanner scanner1 = new Scanner(System.in) ;
            choice = scanner1.nextInt();
            scanner1.nextLine();
            switch (choice) {
                case 1:
                    CustomerBusiness.addCustomer(scanner1);
                    break;
                case 2:
                    CustomerBusiness.displayCustomers();
                    break;
                case 3:
                    System.exit(0);
            }
        } while (choice != 0);
        System.out.println("Vui long chọn lại");
    }
    public static void menuOrderMenu(){
        int choice;
        do {
            System.out.println("***********************ORDER MENU**********************");
            System.out.println("1. Danh sách đơn hàng");
            System.out.println("2. Thêm mới đơn hàng ");
            System.out.println("3. Cập nhật trạng thái đơn hàng");
            System.out.println("4. Danh sách đơn hàng quá hạn");
            System.out.println("5. Thống kê số lượng đơn hàng đã giao (Trạng thái true) ");
            System.out.println("6. Tính tổng doanh thu các đơn hàng đã giao ");
            System.out.println("7. Quay lại");
            Scanner scanner2 = new Scanner(System.in) ;
            choice = scanner2.nextInt();
            scanner2.nextLine();
            switch (choice) {
                case 1:
                   OrderBusiness.displayOrders();
                    break;
                case 2:
                    OrderBusiness.addOrder(scanner2);
                    break;
                case 3:
                   OrderBusiness.updateOrderStatus(scanner2);
                    break;
                case 4:
                    OrderBusiness.getOrderOverdue();
                    break;
                case 5:
                    OrderBusiness.getOrderDelivied();
                    break;
                case 6:
                   OrderBusiness.getTotalRevenue();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (choice != 0);
        System.out.println("Vui long chọn lại");
    }
}
