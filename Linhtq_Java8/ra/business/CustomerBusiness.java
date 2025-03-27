package Linhtq_Java8.ra.business;

import Linhtq_Java8.ra.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerBusiness {
    private static List<Customer> customers = new ArrayList<>();

    public static void addCustomer(Scanner scanner) {
        Customer customer = new Customer();
        customer.inputData(scanner);
        customers.add(customer);
        System.out.println("Khách hàng đã được thêm thành công!");
    }

    public static void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("Không có khách hàng nào trong danh sách.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }
}