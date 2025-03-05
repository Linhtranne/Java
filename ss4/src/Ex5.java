import java.util.Scanner;
public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên dương N: ");
        int N = scanner.nextInt();
        System.out.println("Các số hoàn hảo nhỏ hơn " + N + " là:");
        boolean found = false;
        int i = 0;
        do {
            int sum = 0;
            int j = 1;
            do {
                if (i % j == 0) {
                    sum += j;
                }
                j++;
            } while (j <= i / 2);
            if (sum == i) {
                System.out.println(i);
                found = true;
            }
            i++;
        } while (i < N);
        if (!found) {
            System.out.println("Không có số hoàn hảo nào nhỏ hơn " + N);
        }
        scanner.close();
    }
}