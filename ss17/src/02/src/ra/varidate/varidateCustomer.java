package ra.varidate;

public class varidateCustomer {
    public static boolean varidateCustomerID(String customerID) {
        return customerID.matches("^C\\d{4}$");
    }

    public static boolean varidateName(String name) {
        return name.matches("^[a-zA-Z\\s]{1,50}$");
    }

    public static boolean varidateDateOfBirth(String dateOfBirth) {
        return dateOfBirth.matches("^\\d{2}/\\d{2}/\\d{4}$");
    }
    public static boolean varidateAddress(String address) {
        return address.matches("^[a-zA-Z0-9\\s]{1,255}$");
    }
    public static boolean varidatePhone(String phone) {
        return phone.matches("^(\\d{3})\\d{4}$");
    }
    public static boolean varidateEmail(String email) {
        return email.matches("^[a-zA-Z0-9]+@gmail.com$");
    }
    public static boolean varidateCustomerType(String customerType) {
        return customerType.matches("^[a-zA-Z\\s]{1,50}$");
    }
}
