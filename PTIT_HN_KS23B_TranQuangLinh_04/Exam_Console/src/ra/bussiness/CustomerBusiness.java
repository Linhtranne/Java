package ra.bussiness;
import ra.entity.Customer;
import java.util.Scanner;
import static ra.entity.IApp.MAX_CUSTOMER;
import static ra.presentation.CustomerApplication.customers;

public class CustomerBusiness {
    public void displayCustomer() {
        if (customers.length == 0) {
            System.out.println("Không có khách hàng nào");
        } else {
            for (Customer customer : customers) {
                if (customer != null) {
                    customer.displayData();
                }
            }
        }
    }
    public void addCustomer(Scanner sc) {
        if(customers.length == MAX_CUSTOMER) {
            System.out.println("Không thể thêm mới khách hàng nữa");
        } else {
            System.out.println("Nhập số lượng khách hàng cần thêm: ");
            int n = sc.nextInt();
            if(n < 0 || n > MAX_CUSTOMER) {
                System.out.println("Số lượng không hợp lệ");
            } else {
                for(int i = 0; i < n; i++) {
                    Customer customer = new Customer();
                    customer.inputData(sc);
                    customers[i] = customer;
                }
                System.out.println("Thêm mới khách hàng thành công");
            }
        }
    }
    public void deleteCustomer(Scanner sc) {
        System.out.println("Nhập mã khách hàng cần xóa: ");
        String customerID = sc.nextLine();
        boolean isExist = false;
        for(int i = 0; i < customers.length; i++) {
            if(customers[i] != null && customers[i].getId().equals(customerID)) {
                isExist = true;
                customers[i] = null;
                System.out.println("Xóa khách hàng thành công");
                break;
            }
        }
    }
    public void updateCustomer(Scanner sc) {
        System.out.println("Nhập mã khách hàng cần chỉnh sửa: ");
        String customerID = sc.nextLine();
        boolean isExist = false;
        for(int i = 0; i < customers.length; i++) {
            if(customers[i] != null && customers[i].getId().equals(customerID)) {
                isExist = true;
                customers[i].inputData(sc);
                System.out.println("Chỉnh sửa khách hàng thành công");
                break;
            }
        }
    }
    public void sortCustomer() {
        for(int i = 0; i < customers.length - 1; i++) {
            for(int j = i + 1; j < customers.length; j++) {
                if(customers[i] != null && customers[j] != null && customers[i].getId().compareTo(customers[j].getId()) > 0) {
                    Customer temp = customers[i];
                    customers[i] = customers[j];
                    customers[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp thành công");
    }

    public void searchCustomer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã khách hàng cần tìm: ");
        String customerID = sc.nextLine();
        boolean isExist = false;
        for(int i = 0; i < customers.length; i++) {
            if(customers[i] != null && customers[i].getId().equals(customerID)) {
                isExist = true;
                customers[i].displayData();
                break;
            }
        }
        if(!isExist) {
            System.out.println("Không tìm thấy khách hàng");
        }
    }
}