import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào một số nguyên tố: ");
        try {
            int number = scanner.nextInt();
            checkIsNumber(number);
            checkPrimeNumber(number);
            System.out.println("Số "+ number +" là số nguyên tố " );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void checkPrimeNumber(int number) throws Exception {
        if (number < 2) {
            throw new Exception("Số phải lớn hơn 2");
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                throw new Exception("Số không phải là số nguyên tố");
            }
        }
    }
    public static void checkIsNumber(int number) throws Exception {
            throw new Exception("Bạn phải nhập 1 số nguyên");
    }
}
