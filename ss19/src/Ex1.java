import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex1 {
    public static void main(String[] args) {
        List<String> listArr = Arrays.asList("Java", "", "Lambda", "Stream", "", "Functional");
        Predicate<String> notEmpty = s -> !s.isEmpty();
        List<String> list = listArr.stream().filter(notEmpty).collect(Collectors.toList());
        System.out.println(list);
    }
}
