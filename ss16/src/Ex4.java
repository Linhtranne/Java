import java.util.*;
public class Ex4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println("Tổng của tất cả các phần tử trong danh sách: " + sum);
    }
}
