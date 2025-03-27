package Linhtq_Java8.ra.business;
import Linhtq_Java8.ra.entity.Order;
import java.util.List;
import java.util.Scanner;

public interface IOrderBusiness {
    void addOrder(Scanner scanner);
    void displayOrders();
    void updateOrderStatus(Scanner scanner);
    List<Order> getOrderDelivied();
    List<Order> getOrderOverdue();
    default double getTotalRevenue() {
        return 0;
    }
}
