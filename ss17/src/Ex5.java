import java.util.HashSet;
public class Ex5 {
    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);
        set2.add(8);
        set.addAll(set2);
        System.out.println(set);
    }
}
