import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        while (true) {
            System.out.print("Nhập số phần tử của mảng (N): ");
            N = scanner.nextInt();
            if (N > 0) {
                break;
            } else {
                System.out.println("N phải là số nguyên dương. Vui lòng nhập lại.");
            }
        }

        int[] arr = new int[N];
        System.out.println("Nhập các giá trị của mảng:");
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int value : arr) {
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        System.out.println("Các phần tử theo thứ tự số lần xuất hiện tăng dần:");
        for (Map.Entry<Integer, Integer> entry : entryList) {
            System.out.println("Giá trị: " + entry.getKey() + " - Số lần xuất hiện: " + entry.getValue());
        }
    }
}