import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        if(n == 0){
            System.out.println("Mảng rỗng");
        }else{
            System.out.println("Nhập các phần tử của mảng:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] result = new int[n];
            int evenIndex = 0;
            for (int num : arr) {
                if (num % 2 == 0) {
                    result[evenIndex++] = num;
                }
            }
            for (int num : arr) {
                if (num % 2 != 0) {
                    result[evenIndex++] = num;
                }
            }
            System.out.println("Mảng sau khi sắp xếp:");
            for (int i = 0; i < evenIndex; i++) {
                System.out.print(result[i] + " ");
            }
        }
    }
}
