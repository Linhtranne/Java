import java.util.*;
public class Ex2 {
    List<Integer> list = new ArrayList<>();
    public void addElement() {
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
    }
    public void removeElement() {
        System.out.println("Danh sách trước khi xóa:");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) % 3 == 0) {
                list.remove(i);
                i--;
            }
        }
        System.out.println("Danh sách sau khi xóa:");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
