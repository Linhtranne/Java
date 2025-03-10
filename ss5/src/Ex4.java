import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước của mảng: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Kích thước rỗng");
            return;
        }
        int[] arr = new int[n];
        System.out.println("Nhập các giá trị cho mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.println();
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        System.out.print("Mảng sau khi đảo ngược: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}