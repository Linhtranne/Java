import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số đầu tiên (num1): ");
        double num1 = scanner.nextDouble();
        System.out.print("Nhập ký hiệu phép toán (+, -, *, /): ");
        String operator = scanner.next();
        System.out.print("Nhập số thứ hai (num2): ");
        double num2 = scanner.nextDouble();
        switch (operator) {
            case "+":
                System.out.println("Kết quả: " + (num1 + num2));
                break;
            case "-":
                System.out.println("Kết quả: " + (num1 - num2));
                break;
            case "*":
                System.out.println("Kết quả: " + (num1 * num2));
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Không thể chia cho 0.");
                } else {
                    System.out.println("Kết quả: " + (num1 / num2));
                }
                break;
            default:
                System.out.println("Phép toán không hợp lệ.");
                break;
        }
        scanner.close();
    }
}
