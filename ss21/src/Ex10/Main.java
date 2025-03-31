package Ex10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product("1", "Sản phẩm 1", 100000);
        Product product2 = new Product("2", "Sản phẩm 2", 200000);
        Product product3 = new Product("3", "Sản phẩm 3", 300000);

        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Xem danh sách sản phẩm có sẵn");
            System.out.println("2. Thêm sản phẩm vào giỏ hàng");
            System.out.println("3. Xóa sản phẩm khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5. Hiển thị tổng tiền");
            System.out.println("6. Thoát");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Danh sách sản phẩm có sẵn:");
                    System.out.println("1. " + product1.getName() + " - " + product1.getPrice());
                    System.out.println("2. " + product2.getName() + " - " + product2.getPrice());
                    System.out.println("3. " + product3.getName() + " - " + product3.getPrice());
                    break;
                case 2:
                    System.out.println("Nhập mã sản phẩm:");
                    String productId = scanner.nextLine();
                    System.out.println("Nhập số lượng:");
                    int quantity;
                    try {
                        quantity = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Lỗi: Số lượng không hợp lệ!");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();
                    try {
                        if (productId.equals("1")) {
                            cart.addToCart(product1, quantity);
                        } else if (productId.equals("2")) {
                            cart.addToCart(product2, quantity);
                        } else if (productId.equals("3")) {
                            cart.addToCart(product3, quantity);
                        } else {
                            System.out.println("Lỗi: Mã sản phẩm không hợp lệ!");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Nhập mã sản phẩm cần xóa:");
                    productId = scanner.nextLine();
                    try {
                        cart.removeFromCart(productId);
                        System.out.println("Xóa sản phẩm thành công.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    cart.displayCart();
                    break;
                case 5:
                    cart.checkout();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}