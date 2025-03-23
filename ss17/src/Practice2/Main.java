package Practice2;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager manager = new ProductManager(scanner);

        while (true) {
            displayMenu();
            System.out.print("Chọn chức năng (1-10): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manager.inputMultipleProducts();
                    break;
                case 2:
                    manager.displayAllProducts();
                    break;
                case 3:
                    manager.calculateAllProfits();
                    break;
                case 4:
                    manager.sortByProfit();
                    break;
                case 5:
                    manager.statisticByPriceRange();
                    break;
                case 6:
                    manager.searchByName();
                    break;
                case 7:
                    manager.importProduct();
                    break;
                case 8:
                    manager.sellProduct();
                    break;
                case 9:
                    manager.updateStatus();
                    break;
                case 10:
                    System.out.println("Thoát chương trình!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    public class ProductManager {
        private Scanner scanner;

        public ProductManager(Scanner scanner) {
            this.scanner = scanner;
        }

        public void inputMultipleProducts() {
            System.out.print("Nhập số lượng sản phẩm cần thêm: ");
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < n; i++) {
                System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1) + ":");
                new Product().inputData(scanner);
            }
        }

        public void displayAllProducts() {
            if (Product.getProducts().isEmpty()) {
                System.out.println("Chưa có sản phẩm nào!");
                return;
            }
            Product.getProducts().forEach(Product::displayData);
        }

        public void calculateAllProfits() {
            Product.getProducts().forEach(Product::calProfit);
            System.out.println("Đã tính lợi nhuận cho tất cả sản phẩm!");
        }

        public void sortByProfit() {
            Product.getProducts().sort(Comparator.comparing(Product::getProfit).reversed());
            System.out.println("Đã sắp xếp theo lợi nhuận giảm dần!");
            displayAllProducts();
        }

        public void statisticByPriceRange() {
            System.out.print("Nhập giá từ: ");
            float fromPrice = Float.parseFloat(scanner.nextLine());
            System.out.print("Nhập giá đến: ");
            float toPrice = Float.parseFloat(scanner.nextLine());

            long count = Product.getProducts().stream()
                    .filter(p -> p.getExportPrice() >= fromPrice && p.getExportPrice() <= toPrice)
                    .count();
            System.out.println("Số sản phẩm trong khoảng giá " + fromPrice + " - " + toPrice + ": " + count);
        }

        public void searchByName() {
            System.out.print("Nhập tên sản phẩm cần tìm: ");
            String name = scanner.nextLine();
            List<Product> results = Product.getProducts().stream()
                    .filter(p -> p.getProductName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());

            if (results.isEmpty()) {
                System.out.println("Không tìm thấy sản phẩm nào!");
            } else {
                results.forEach(Product::displayData);
            }
        }

        public void importProduct() {
            System.out.print("Nhập mã sản phẩm cần nhập: ");
            String id = scanner.nextLine();
            Product product = Product.getProducts().stream()
                    .filter(p -> p.getProductId().equals(id))
                    .findFirst()
                    .orElse(null);

            if (product == null) {
                System.out.println("Không tìm thấy sản phẩm!");
                return;
            }

            System.out.print("Nhập số lượng cần thêm: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            product.setQuantity(product.getQuantity() + quantity);
            System.out.println("Đã cập nhật số lượng!");
        }

        public void sellProduct() {
            System.out.print("Nhập tên sản phẩm cần bán: ");
            String name = scanner.nextLine();
            Product product = Product.getProducts().stream()
                    .filter(p -> p.getProductName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);

            if (product == null) {
                System.out.println("Không tìm thấy sản phẩm!");
                return;
            }

            System.out.print("Nhập số lượng cần bán: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            if (quantity > product.getQuantity()) {
                System.out.println("Không đủ số lượng để bán!");
            } else {
                product.setQuantity(product.getQuantity() - quantity);
                System.out.println("Đã bán sản phẩm!");
            }
        }

        public void updateStatus() {
            System.out.print("Nhập mã sản phẩm cần cập nhật trạng thái: ");
            String id = scanner.nextLine();
            Product product = Product.getProducts().stream()
                    .filter(p -> p.getProductId().equals(id))
                    .findFirst()
                    .orElse(null);

            if (product == null) {
                System.out.println("Không tìm thấy sản phẩm!");
                return;
            }

            product.setStatus(!product.isStatus());
            System.out.println("Đã cập nhật trạng thái!");
        }
    }

    private static void displayMenu() {
        System.out.println("***********************MENU**************************");
        System.out.println("1. Nhập thông tin n sản phẩm");
        System.out.println("2. Hiển thị thông tin các sản phẩm");
        System.out.println("3. Tính lợi nhuận các sản phẩm");
        System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
        System.out.println("5. Thống kê các sản phẩm theo giá");
        System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
        System.out.println("7. Nhập sản phẩm");
        System.out.println("8. Bán sản phẩm");
        System.out.println("9. Cập nhật trạng thái sản phẩm");
        System.out.println("10. Thoát");
    }
}