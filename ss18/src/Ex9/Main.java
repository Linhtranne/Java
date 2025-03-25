package Ex9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Product> productMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Cập nhật số lượng hoặc giá sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Tính tổng giá trị sản phẩm trong kho");
            System.out.println("5. Thoát");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    calculateTotalValue();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Nhập mã sản phẩm: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        double price;
        while (true) {
            System.out.print("Nhập giá sản phẩm: ");
            price = scanner.nextDouble();
            if (price >= 0) break;
            System.out.println("Giá sản phẩm phải là số không âm. Vui lòng nhập lại.");
        }
        int quantity;
        while (true) {
            System.out.print("Nhập số lượng sản phẩm: ");
            quantity = scanner.nextInt();
            if (quantity >= 0) break;
            System.out.println("Số lượng sản phẩm phải là số không âm. Vui lòng nhập lại.");
        }
        Product product = new Product(id, name, price, quantity);
        productMap.put(id, product);
        System.out.println("Sản phẩm đã được thêm: " + product);
    }

    private static void updateProduct() {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        int id = scanner.nextInt();
        Product product = productMap.get(id);
        if (product == null) {
            System.out.println("Sản phẩm không tồn tại. Vui lòng nhập lại.");
            return;
        }
        System.out.println("Chọn thuộc tính cần cập nhật:");
        System.out.println("1. Giá sản phẩm");
        System.out.println("2. Số lượng sản phẩm");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                double price;
                while (true) {
                    System.out.print("Nhập giá mới: ");
                    price = scanner.nextDouble();
                    if (price >= 0) break;
                    System.out.println("Giá sản phẩm phải là số không âm. Vui lòng nhập lại.");
                }
                product.setPrice(price);
                break;
            case 2:
                int quantity;
                while (true) {
                    System.out.print("Nhập số lượng mới: ");
                    quantity = scanner.nextInt();
                    if (quantity >= 0) break;
                    System.out.println("Số lượng sản phẩm phải là số không âm. Vui lòng nhập lại.");
                }
                product.setQuantity(quantity);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
        }
        System.out.println("Sản phẩm đã được cập nhật: " + product);
    }

    private static void deleteProduct() {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int id = scanner.nextInt();
        Product product = productMap.remove(id);
        if (product == null) {
            System.out.println("Sản phẩm không tồn tại. Vui lòng nhập lại.");
        } else {
            System.out.println("Sản phẩm đã được xóa: " + product);
        }
    }

    private static void calculateTotalValue() {
        double totalValue = 0;
        for (Product product : productMap.values()) {
            totalValue += product.getTotalValue();
        }
        System.out.println("Tổng giá trị sản phẩm trong kho: " + totalValue);
    }
}