package Ex7;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        try {
            students.add(new Student("A", "S001", 3.5));
            students.add(new GraduateStudent("B", "G001", 3.8, "Java", "C"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        for (Student student : students) {
            student.getDetails();
            System.out.println();
        }
    }
}
