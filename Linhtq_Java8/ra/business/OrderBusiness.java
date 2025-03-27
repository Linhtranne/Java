package Linhtq_Java8.ra.business;
import Linhtq_Java8.ra.entity.Order;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderBusiness{
    private static List<Order> orders = new ArrayList<>();

    public static void addOrder(Scanner scanner) {
        Order order = new Order();
        order.inputData(scanner);
        orders.add(order);
        System.out.println("Đơn hàng đã được thêm thành công!");
    }
    public static void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("Không có đơn hàng nào trong danh sách.");
        } else {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    public static void updateOrderStatus(Scanner scanner) {
        System.out.print("Nhập mã đơn hàng cần cập nhật: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Order order : orders) {
            if (order.getId() == id) {
                System.out.print("Nhập trạng thái mới (true/false): ");
                boolean status = scanner.nextBoolean();
                order.setStatus(status);
                System.out.println("Trạng thái đơn hàng đã được cập nhật!");
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng với mã đã nhập.");
    }

    public static void getOrderDelivied() {
        orders.stream()
                .filter(Order::isStatus)
                .toList();
    }

    public static void getOrderOverdue() {
        LocalDate today = LocalDate.now();
        orders.stream()
                .filter(order -> order.getOrderDate().isBefore(today) && !order.isStatus())
                .toList();
    }


    public static void getTotalRevenue() {
        orders.stream()
                .filter(Order::isStatus)
                .mapToDouble(Order::getTotalAmount)
                .sum();
    }
}