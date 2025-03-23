import java.util.HashSet;
public class Ex6 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set2.add(30);
        set2.add(40);
        set2.add(50);
        set2.add(60);
        set.retainAll(set2);
        set.stream().sorted();
    }
}
