import java.util.ArrayList;
public class Ex2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int sum = list.stream().filter(n -> n % 2 != 0).reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }
}
