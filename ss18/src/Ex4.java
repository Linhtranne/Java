import java.util.Map;
import java.util.TreeMap;

public class Ex4 {
    public static void main(String[] args) {
        TreeMap<String, Integer> employees = new TreeMap<>();
        employees.put("NV001", 5000);
        employees.put("NV002", 6000);
        employees.put("NV003", 7000);
        employees.put("NV004", 8000);
        employees.put("NV005", 9000);
        System.out.println("Danh sách nhân viên:");
        for (Map.Entry<String, Integer> entry : employees.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        employees.put("NV003", 7500);
        System.out.println("khi cập nhật lương của NV003:");
        for (Map.Entry<String, Integer> entry : employees.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        employees.remove("NV002");
        System.out.println("khi xóa NV002:");
        for (Map.Entry<String, Integer> entry : employees.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}