import java.util.Map;
import java.util.LinkedHashMap;

public class Ex6 {
    public static void main(String[] args) {
        Map<String, Integer> students = new LinkedHashMap<>();
        students.put("Học sinh 1", 7);
        students.put("Học sinh 2", 8);
        students.put("Học sinh 3", 4);
        students.put("Học sinh 4", 6);
        students.put("Học sinh 5", 9);
        students.put("Học sinh 6", 5);
        students.put("Học sinh 7", 3);
        students.put("Học sinh 8", 10);
        students.put("Học sinh 9", 2);
        students.put("Học sinh 10", 7);
        System.out.println("Danh sách học sinh và điểm số:");
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        double totalScore = 0;
        for (int score : students.values()) {
            totalScore += score;
        }
        double averageScore = totalScore / students.size();
        System.out.println("Điểm trung bình của tất cả các học sinh: " + averageScore);
        students.entrySet().removeIf(entry -> entry.getValue() < 5);
        System.out.println("Danh sách học sinh sau khi xóa học sinh có điểm dưới 5:");
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}