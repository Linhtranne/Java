import java.util.Map;
import java.util.LinkedHashMap;
public class Ex3 {
    public static void main(String[] args) {
        Map<String, Integer> products = new LinkedHashMap<>();
        products.put("laptop", 1000);
        products.put("Chuột ", 20);
        products.put("Bàn phím", 50);
        products.put("Tai nghe", 200);
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        products.put("laptop", 3000);
        System.out.println("Khi sửa giá Laptop");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        products.remove("laptop");
        System.out.println("Khi xóa laptop");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
