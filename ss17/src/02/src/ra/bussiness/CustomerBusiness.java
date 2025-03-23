package ra.business;

import ra.entity.Customer;
import ra.entity.IApp;
import ra.varidate.varidateCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerBusiness {
    private List<Customer> customers = new ArrayList<>();

    public void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (Customer customer : customers) {
                customer.displayData();
            }
        }
    }

    public void addCustomer(Scanner sc) {
        if (customers.size() >= IApp.MAX_CUSTOMER) {
            System.out.println("Không thể thêm mới khách hàng nữa.");
            return;
        }
        System.out.print("Nhập số lượng khách hàng cần thêm: ");
        int count = sc.nextInt();
        sc.nextLine(); // consume newline
        for (int i = 0; i < count; i++) {
            Customer customer = new Customer();
            customer.inputData(sc);
            customers.add(customer);
            System.out.println("Thêm khách hàng thành công.");
        }
    }

    public void editCustomer(Scanner sc) {
        System.out.print("Nhập mã khách hàng cần chỉnh sửa: ");
        String customerId = sc.nextLine();
        Customer customer = findCustomerById(customerId);
        if (customer == null) {
            System.out.println("Không tìm thấy khách hàng");
            return;
        }
        customer.displayData();
        System.out.println("Chọn thuộc tính cần sửa: ");
        System.out.println("1. Tên");
        System.out.println("2. Họ");
        System.out.println("3. Ngày sinh");
        System.out.println("4. Giới tính");
        System.out.println("5. Địa chỉ");
        System.out.println("6. Số điện thoại");
        System.out.println("7. Email");
        System.out.println("8. Loại khách hàng");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        switch (choice) {
            case 1:
                System.out.print("Nhập tên mới: ");
                customer.setFirstName(sc.nextLine());
                break;
            case 2:
                System.out.print("Nhập họ mới: ");
                customer.setLastName(sc.nextLine());
                break;
            case 3:
                System.out.print("Nhập ngày sinh mới: ");
                customer.setDateOfBirth(sc.nextLine());
                break;
            case 4:
                System.out.print("Nhập giới tính mới (true - Nam, false - Nữ): ");
                customer.setGender(sc.nextBoolean());
                sc.nextLine(); // consume newline
                break;
            case 5:
                System.out.print("Nhập địa chỉ mới: ");
                customer.setAddress(sc.nextLine());
                break;
            case 6:
                System.out.print("Nhập số điện thoại mới: ");
                customer.setPhoneNumber(sc.nextLine());
                break;
            case 7:
                System.out.print("Nhập email mới: ");
                customer.setEmail(sc.nextLine());
                break;
            case 8:
                System.out.print("Nhập loại khách hàng mới: ");
                customer.setCustomerType(sc.nextLine());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
        System.out.println("Chỉnh sửa thông tin khách hàng thành công.");
    }

    public void deleteCustomer(Scanner sc) {
        System.out.print("Nhập mã khách hàng cần xóa: ");
        String customerId = sc.nextLine();
        Customer customer = findCustomerById(customerId);
        if (customer == null) {
            System.out.println("Không tìm thấy khách hàng");
            return;
        }
        customer.displayData();
        System.out.print("Bạn có chắc chắn muốn xóa khách hàng này không? (y/n): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            customers.remove(customer);
            System.out.println("Xóa khách hàng thành công.");
        } else {
            System.out.println("Hủy bỏ thao tác.");
        }
    }

    public void searchCustomer(Scanner sc) {
        System.out.println("Chọn tiêu chí tìm kiếm: ");
        System.out.println("1. Tìm kiếm theo tên khách hàng");
        System.out.println("2. Tìm kiếm theo loại khách hàng");
        System.out.println("3. Tìm kiếm theo số điện thoại");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        switch (choice) {
            case 1:
                System.out.print("Nhập tên khách hàng: ");
                String name = sc.nextLine();
                for (Customer customer : customers) {
                    if (customer.getFirstName().equalsIgnoreCase(name) || customer.getLastName().equalsIgnoreCase(name)) {
                        customer.displayData();
                    }
                }
                break;
            case 2:
                System.out.print("Nhập loại khách hàng: ");
                String type = sc.nextLine();
                for (Customer customer : customers) {
                    if (customer.getCustomerType().equalsIgnoreCase(type)) {
                        customer.displayData();
                    }
                }
                break;
            case 3:
                System.out.print("Nhập số điện thoại: ");
                String phone = sc.nextLine();
                for (Customer customer : customers) {
                    if (customer.getPhoneNumber().equals(phone)) {
                        customer.displayData();
                    }
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    public void sortCustomers(Scanner sc) {
        System.out.println("Chọn tiêu chí sắp xếp: ");
        System.out.println("1. Sắp xếp theo tên tăng dần");
        System.out.println("2. Sắp xếp theo tên giảm dần");
        System.out.println("3. Sắp xếp theo năm sinh tăng dần");
        System.out.println("4. Sắp xếp theo năm sinh giảm dần");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        switch (choice) {
            case 1:
                customers.sort((c1, c2) -> c1.getFirstName().compareToIgnoreCase(c2.getFirstName()));
                break;
            case 2:
                customers.sort((c1, c2) -> c2.getFirstName().compareToIgnoreCase(c1.getFirstName()));
                break;
            case 3:
                customers.sort((c1, c2) -> c1.getDateOfBirth().compareTo(c2.getDateOfBirth()));
                break;
            case 4:
                customers.sort((c1, c2) -> c2.getDateOfBirth().compareTo(c1.getDateOfBirth()));
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
        displayCustomers();
    }

    private Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
}