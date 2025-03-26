package Ex8;

import java.util.List;

public class ListProcess implements IList {
    @Override
    public int sumOddNumbers(List<Integer> list) {
        return list.stream()
                   .filter(number -> number % 2 != 0)
                   .mapToInt(Integer::intValue)
                   .sum();
    }
}