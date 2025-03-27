import java.util.List;
import java.util.Optional;

public class Ex5 {
    public static void main(String[] args) {
        List<Integer> normalList = List.of(10, 5, 8, 20, 7);
        List<Integer> singleElementList = List.of(10);
        List<Integer> allSameList= List.of(10, 10, 10);
        System.out.println("normalList: " + findSecondLargest(normalList).orElse("Không tìm thấy số lớn thứ hai"));
        System.out.println("singleElementList: " + findSecondLargest(singleElementList).orElse("Không tìm thấy số lớn thứ hai"));
        System.out.println("allSameList: " + findSecondLargest(allSameList).orElse("Không tìm thấy số lớn thứ hai"));
    }

    private static Optional<String> findSecondLargest(List<Integer> normalList) {
        return normalList.stream()
                .distinct()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst()
                .map(String::valueOf);
    }
}
