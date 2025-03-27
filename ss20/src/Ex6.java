import java.util.List;
import java.time.DateTimeException;
public class Ex6 {
    public static void main(String[] args) {
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        System.out.println("Thời điểm xử lí: " + java.time.LocalTime.now());
        items.stream().distinct().forEach(item -> System.out.println(item + ": " + items.stream().filter(i -> i.equals(item)).count()));
    }

}
