import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên dương n: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Số nhập vào không hợp lệ.");
        } else {
            System.out.println("Bảng cửu chương của " + n + ":");
            for (int i = 1; i <= 10; i++) {
                int result = n * i;
                System.out.println(n + " x " + i + " = " + result);
            }
        }
    }
}