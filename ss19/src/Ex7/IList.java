package Ex7;

import java.util.List;

public interface IList {
    boolean containsNegative(List<Integer> list);

    static void printList(List<Integer> list) {
        for (Integer number : list) {
            System.out.println(number);
        }
    }
}
