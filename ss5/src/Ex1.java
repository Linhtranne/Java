public class Ex1 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 50, 30};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Giá trị lớn nhất trong mảng là: " + max);
    }
}