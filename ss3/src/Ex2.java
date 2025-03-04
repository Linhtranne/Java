import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số thứ nhất: ");
        int num1 = scanner.nextInt();
        System.out.print("Nhập số thứ hai: ");
        int num2 = scanner.nextInt();
        System.out.print("Nhập số thứ ba: ");
        int num3 = scanner.nextInt();
        if (num1 == num2 && num2 == num3) {
            System.out.println("Ba số nguyên bằng nhau");
        } else {
            int max;
            if (num1 > num2) {
                if (num1 > num3) {
                    max = num1;
                } else {
                    max = num3;
                }
            } else {
                if (num2 > num3) {
                    max = num2;
                } else {
                    max = num3;
                }
            }
            System.out.println("Số lớn nhất là: " + max);
        }
        scanner.close();
    }
}
