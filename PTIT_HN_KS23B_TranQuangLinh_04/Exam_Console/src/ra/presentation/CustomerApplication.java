package ra.presentation;
import ra.bussiness.CustomerBusiness;
import ra.entity.Customer;
import java.util.Scanner;

public class CustomerApplication {
    public static final Customer[] customers = new Customer[0];
    public static void main(String[] args) {
        CustomerBusiness customerBusiness = new CustomerBusiness();
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println(" ----------------------------Customer Menu----------------------------");
            System.out.println("1. Hiển thị thông tin khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Chỉnh sửa thông tin khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Tìm kiếm khách hàng ");
            System.out.println("6. Sắp xếp ");
            System.out.println("0. Thoát");
            System.out.println("Chọn chức năng: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    customerBusiness.displayCustomer();
                    break;
                case 2:
                    customerBusiness.addCustomer(sc);
                    break;
                case 3:
                    customerBusiness.updateCustomer(sc);
                    break;
                case 4:
                    customerBusiness.deleteCustomer(sc);
                    break;
                case 5:
                    customerBusiness.searchCustomer();
                    break;
                case 6:
                    customerBusiness.sortCustomer();
                default:
                    System.out.println("Chức năng không tồn tại");
            }
        } while (choice != 0);
    }

}
