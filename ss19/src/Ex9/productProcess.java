package Ex9;

import java.util.List;

public class productProcess implements IProduct {
    @Override
    public double calculateTotalValue(List<Product> products) {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}