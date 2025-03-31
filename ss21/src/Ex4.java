import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào một số nguyên: ");
        try {
            int number = scanner.nextInt();
            System.out.println("Bạn đã nhập: " + number);
        } catch (Exception e) {
            System.out.println("Lỗi: Bạn phải nhập số nguyên!");
        } finally {
            System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
        }
    }
}