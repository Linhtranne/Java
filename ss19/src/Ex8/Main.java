package Ex8;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IList processor = new ListProcess();

        List<Integer> list = Arrays.asList(5, 7, 10, 13, 6, 3);
        IList.printList(list);
        System.out.println("Tổng các số lẻ: " + processor.sumOddNumbers(list));
        System.out.println( processor.checkOdd(list));

    }
}