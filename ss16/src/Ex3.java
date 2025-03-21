import java.util.*;
public class Ex3 {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        int min = list.get(0);
        int max = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) < min) {
                min = list.get(i);
            }
            if(list.get(i) > max) {
                max = list.get(i);
            }
        }
        System.out.println("Phần tử nhỏ nhất trong danh sách: " + min);
        System.out.println("Phần tử lớn nhất trong danh sách: " + max);
    }
}
