import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập kích thước của mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các giá trị cho mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        int maxOdd = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;
        boolean hasOdd = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && arr[i] % 2 != 0) {
                hasOdd = true;
                if (arr[i] > maxOdd) {
                    maxOdd = arr[i];
                }
                if (arr[i] < minOdd) {
                    minOdd = arr[i];
                }
            }
        }

        if (hasOdd) {
            System.out.println("Giá trị lẻ nguyên dương lớn nhất: " + maxOdd);
            System.out.println("Giá trị lẻ nguyên dương nhỏ nhất: " + minOdd);
        } else {
            System.out.println("Không có phần tử lẻ trong mảng");
        }
    }
}