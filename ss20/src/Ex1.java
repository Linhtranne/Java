import java.util.ArrayList;
public class Ex1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }
}
