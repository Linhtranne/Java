import java.util.function.Function;

public class Ex2 {
    public static void main(String[] args) {
        Function<Integer, Integer> function = x -> x * x + 3 * x + 2;

        System.out.println("F(1) = " + function.apply(1));
        System.out.println("F(2) = " + function.apply(2));
        System.out.println("F(3) = " + function.apply(3));
    }
}