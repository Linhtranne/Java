import java.util.HashMap;
public class Ex1 {

    public static void main(String[] args) {
        HashMap<String, Integer> student = new HashMap<>();
        student.put("A", 10);
        student.put("B", 10);
        student.put("C", 9);
        student.put("D", 9);
        student.put("E", 9);
        System.out.println(student);
        System.out.println(student.get("A"));
    }
}
