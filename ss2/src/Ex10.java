import java.math.BigInteger;
import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên lớn thứ nhất: ");
        String input1 = scanner.nextLine();
        System.out.print("Nhập số nguyên lớn thứ hai: ");
        String input2 = scanner.nextLine();
        BigInteger num1 = new BigInteger(input1);
        BigInteger num2 = new BigInteger(input2);
        BigInteger sum = num1.add(num2);
        BigInteger difference = num1.subtract(num2);
        BigInteger product = num1.multiply(num2);
        BigInteger quotient = BigInteger.ZERO;
        BigInteger remainder = BigInteger.ZERO;
        try {
            quotient = num1.divide(num2);          // Tính thương
            remainder = num1.mod(num2);            // Tính dư
        } catch (ArithmeticException e) {
            System.out.println("Không thể chia cho 0.");
        }

        BigInteger power = num1.pow(10);           // Lũy thừa bậc 10 của số đầu tiên
        System.out.println("Kết quả các phép toán:");
        System.out.println("Tổng: " + sum.toString());
        System.out.println("Hiệu: " + difference.toString());
        System.out.println("Tích: " + product.toString());
        if (!num2.equals(BigInteger.ZERO)) {
            System.out.println("Thương: " + quotient.toString());
            System.out.println("Dư: " + remainder.toString());
        }
        System.out.println("Lũy thừa bậc 10 của số thứ nhất: " + power.toString());
    }
}

