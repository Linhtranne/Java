import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương (N): ");
        int N = scanner.nextInt();
        StringBuilder romanNum = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            while (N >= entry.getValue()) {
                romanNum.append(entry.getKey());
                N -= entry.getValue();
            }
        }
        System.out.println("Chữ số La Mã: " + romanNum.toString());
    }
}