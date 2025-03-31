import java.util.Scanner;
public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào 2 số nguyên a và b");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        try {
            System.out.println("Phép chia của a và b là: " + (a / b));
        }
        catch (ArithmeticException e) {
            System.out.println("Lỗi chia cho 0");

        }
    }
}
