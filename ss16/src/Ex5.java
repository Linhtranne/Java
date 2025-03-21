import java.util.ArrayList;
import java.util.List;
public class Ex5 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Số lần xuất hiện của từng phần tử trong danh sách:");
        for(int i = 0; i < list.size(); i++) {
            int count = 0;
            for(int j = 0; j < list.size(); j++) {
                if(list.get(i) == list.get(j)) {
                    count++;
                }
            }
            System.out.println("Phần tử " + list.get(i) + " xuất hiện " + count + " lần");
            for(int j = i + 1; j < list.size(); j++) {
                if(list.get(i) == list.get(j)) {
                    list.remove(j);
                    j--;
                }
            }
        }



    }
}
