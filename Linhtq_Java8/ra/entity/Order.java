package Linhtq_Java8.ra.entity;
import java.time.LocalDate;
import java.util.Scanner;
public class Order implements IApp {
    private static int nextId = 1;
    private int id;
    private Customer customer;
    private LocalDate orderDate;
    private double totalAmount;
    private boolean status;

    public Order() {
        this.id = nextId++;
    }

    public Order(Customer customer, LocalDate orderDate, double totalAmount, boolean status) {
        this.id = nextId++;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập email khách hàng: ");
        String email = scanner.nextLine();
        this.customer = new Customer(name, email);
        System.out.print("Nhập ngày đặt hàng (yyyy-MM-dd): ");
        this.orderDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Nhập tổng số tiền: ");
        this.totalAmount = Double.parseDouble(scanner.nextLine());
        this.status = false;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Khách hàng: " + customer + " | Ngày đặt hàng: " + orderDate + " | Tổng số tiền: " + totalAmount + " | Trạng thái: " + status;
    }
}