import java.util.ArrayList;
import java.util.List;
public class Ex6 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(5);
        System.out.println("Danh sách trước khi xóa:");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for(int i = 0; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++) {
                if(list.get(i) == list.get(j)) {
                    list.remove(j);
                    j--;
                }
            }
        }
        System.out.println("Danh sách sau khi xóa:");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}

