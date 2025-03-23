package ra.entity;
import java.util.Scanner;

import static ra.varidate.varidateCustomer.*;

public class Customer implements IApp {
    private String customerID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String customerType;

    public Customer() {}

    public Customer(String customerId, String firstName, String lastName, String dateOfBirth, boolean gender, String address, String phoneNumber, String email, String customerType) {
        this.customerID = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
    }

    public String getCustomerId() {
        return customerID;
    }

    public void setCustomerId(String customerId) {
        this.customerID = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập ID người dùng (bắt đầu bằng chữ “C” và kết hợp với 4 kí tự số phía sau ): ");
        do {
            customerID = sc.nextLine();
            if (!varidateCustomerID(customerID)) {
                System.out.println("ID không hợp lệ, vui lòng nhập lại: ");
            }
        } while (!varidateCustomerID(customerID));

        System.out.println("Nhập tên khách hàng(tối đa 50 kí tự): ");
        do{
            firstName = sc.nextLine();
            if (!varidateName(firstName)) {
                System.out.println("Tên không hợp lệ, vui lòng nhập lại: ");
            }
        }while (!varidateName(firstName));
        System.out.println("Nhập họ khách hàng(tối đa 50 kí tự): ");
        do{
            lastName = sc.nextLine();
            if (!varidateName(lastName)) {
                System.out.println("Họ không hợp lệ, vui lòng nhập lại: ");
            }
        }while (!varidateName(lastName));
        System.out.println("Nhập ngày sinh của khách hàng : ");
        do{
            dateOfBirth = sc.nextLine();
            if (!varidateDateOfBirth(dateOfBirth)) {
                System.out.println("Ngày sinh không hợp lệ, vui lòng nhập lại: ");
            }
        }while(!varidateDateOfBirth(dateOfBirth));
        System.out.println("Nhập giới tính của khách hàng(1 - Nam, 2 - Nữ): ");
        gender = sc.nextBoolean();
        System.out.println("Nhập địa chỉ của khách hàng( tối đa 255 ký tự): ");
        do {
            address = sc.nextLine();
            if (!varidateAddress(address)) {
                System.out.println("Địa chỉ không hợp lệ, vui lòng nhập lại: ");
            }
        } while (!varidateAddress(address));
        System.out.println("Nhập số điện thoại của khách hàng(không trùng lặp, định dạng số điện thoại Việt Nam): ");
        do {
            phoneNumber = sc.nextLine();
            if (!varidatePhone(phoneNumber)) {
                System.out.println("Số điện thoại không hợp lệ, vui lòng nhập lại: ");
            }
        } while (!varidatePhone(phoneNumber));
        System.out.println("Nhập email của khách hàng(không trùng lặp, định dạng gmail): ");
        do {
            email = sc.nextLine();
            if (!varidateEmail(email)) {
                System.out.println("Email không hợp lệ, vui lòng nhập lại: ");
            }
        } while (!varidateEmail(email));
        System.out.println("Nhập loại khách hàng(cá nhân, doanh nghiệp): ");
        do {
            customerType = sc.nextLine();
            if (!varidateCustomerType(customerType)) {
                System.out.println("Loại khách hàng không hợp lệ, vui lòng nhập lại: ");
            }
        } while (!varidateCustomerType(customerType));
    }
    @Override
    public void displayData() {
        System.out.println("ID người dùng: " + customerID);
        System.out.println("Tên khách hàng: " + firstName);
        System.out.println("Họ khách hàng: " + lastName);
        System.out.println("Ngày sinh của khách hàng: " + dateOfBirth);
        System.out.println("Giới tính của khách hàng: " + gender);
        System.out.println("Địa chỉ của khách hàng: " + address);
        System.out.println("Số điện thoại của khách hàng: " + phoneNumber);
        System.out.println("Email của khách hàng: " + email);
        System.out.println("Loại khách hàng: " + customerType);
    }
}
