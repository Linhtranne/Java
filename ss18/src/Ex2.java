import java.util.Map;
public class Ex2 {

    public static void main(String[] args) {
        Map<String, Integer> products = Map.of(
            "Laptop", 1000,
            "Chuột", 20,
            "Bàn phím", 50,
            "Tai nghe", 200
        );
        if (products.containsKey("Laptop")) {
            System.out.println("Laptop có trong danh sách");
        } else {
            System.out.println("Laptop không có trong danh sách");
        }
        if (products.containsValue(1000)) {
            System.out.println("sản phẩm trên có giá 1000");
        } else {
            System.out.println(" sản phẩm trên không có giá bằng 1000");
        }
    }
}
