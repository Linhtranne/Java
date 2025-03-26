package Ex8;

import java.util.List;
import java.util.function.Predicate;

public interface IList {
    int sumOddNumbers(List<Integer> list);

    static void printList(List<Integer> list) {
        for (Integer number : list) {
            System.out.println(number);
        }
    }

    default boolean checkOdd(List<Integer> list) {
        Predicate<Integer> isOdd = number -> number % 2 != 0;
        return list.stream().anyMatch(isOdd);
    }
}