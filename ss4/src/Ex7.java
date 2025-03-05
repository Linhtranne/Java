import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên dương N: ");
        int N = scanner.nextInt();
        System.out.println("Các số Happy từ 1 đến " + N + " là:");
        for (int i = 1; i <= N; i++) {
            int num = i;
            int slow = num;
            int fast = num;
            while (true) {
                int slowSum = 0;
                while (slow > 0) {
                    int digit = slow % 10;
                    slowSum += digit * digit;
                    slow /= 10;
                }
                slow = slowSum;
                int fastSum = 0;
                int fastCopy = fast;
                while (fastCopy > 0) {
                    int digit = fastCopy % 10;
                    fastSum += digit * digit;
                    fastCopy /= 10;
                }
                fast = fastSum;

                fastSum = 0;
                fastCopy = fast;
                while (fastCopy > 0) {
                    int digit = fastCopy % 10;
                    fastSum += digit * digit;
                    fastCopy /= 10;
                }
                fast = fastSum;
                if (slow == fast) {
                    break;
                }
            }
            if (slow == 1) {
                System.out.print(i + " ");
            }
        }
        scanner.close();
    }
}