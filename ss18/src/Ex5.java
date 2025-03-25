import java.util.Map;
    import java.util.TreeMap;

    public class Ex5 {
        public static void main(String[] args) {
            Map<String, Integer> products = Map.of(
                "Laptop", 1000,
                "Chuột", 20,
                "Bàn phím", 50,
                "Tai nghe", 200,
                "Màn hình", 1200,
                "Loa", 600
            );

            TreeMap<String, Integer> filteredProducts = new TreeMap<>((a, b) -> products.get(a).compareTo(products.get(b)));

            for (Map.Entry<String, Integer> entry : products.entrySet()) {
                if (entry.getValue() >= 500 && entry.getValue() <= 1500) {
                    filteredProducts.put(entry.getKey(), entry.getValue());
                }
            }

            for (Map.Entry<String, Integer> entry : filteredProducts.entrySet()) {
                System.out.println("sản phẩm có giá trong khoảng từ 500 đến 1500.");
                System.out.println("Tên sản phẩm: " + entry.getKey() + " - Giá: " + entry.getValue());
            }
        }
    }