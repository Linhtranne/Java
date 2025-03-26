package Ex9;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("He", 50),
                new Product("Hehe", 100),
                new Product("Hehehe", 150),
                new Product("Hehehehe", 200)
        );

        IProduct processor = new productProcess();

        if (processor.hasExpensiveProduct(products)) {
            products.stream()
                    .filter(product -> product.getPrice() > 100)
                    .forEach(System.out::println);
        } else {
            System.out.println("Không có sản phẩm đắt tiền");
        }

        double totalValue = processor.calculateTotalValue(products);
        System.out.println("Tổng giá trị của tất cả sản phẩm: " + totalValue);

        IProduct.printProductList(products);
    }
}