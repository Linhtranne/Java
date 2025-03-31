import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tuổi của bạn: ");
        int age = scanner.nextInt();
        try {
            checkAge(age);
            System.out.println("Chào mừng bạn!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Bạn chưa đủ 18 tuổi!");
        }
    }
}