import java.util.HashSet;
public class Ex8 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3};
        int k = 6;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    set.add(arr[i] + " " + arr[j]);
                }
            }
        }
        System.out.println("Các cặp số có tổng bằng " + k + " là: ");
        System.out.println(set);
    }
}
