import java.util.Scanner;
public class Ex3    {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập kích thước mảng");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các giá trị trong mảng");
        int countEven = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            if(arr[i] % 2 == 0) {
                countEven++;
            }
        }
        System.out.println("Tổng số lượng chẵn "+ countEven);
    }
}
