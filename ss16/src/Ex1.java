import java.util.*;
public class Ex1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Nguyen Van A");
        list.add("Nguyen Van B");
        list.add("Nguyen Van C");
        list.add("Nguyen Van D");
        list.add("Nguyen Van E");
        System.out.println("Vòng lặp for");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("Vòng lặp foreach");
        for(String s : list) {
            System.out.println(s);
        }
    }
}
