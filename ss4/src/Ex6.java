import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên N: ");
        int N = scanner.nextInt();
        if (N < 0) {
            N = -N;
        }
        int sum = 0;
        while (N > 0) {
            sum += N % 10;
            N /= 10;
        }
        System.out.println("Tổng các chữ số là: " + sum);

        scanner.close();
    }
}