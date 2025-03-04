import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập c: ");
        double c = scanner.nextDouble();
        if (a == 0 && b == 0) {
            if (c == 0) {
                System.out.println("Phương trình có vô số nghiệm.");
            } else {
                System.out.println("Phương trình vô nghiệm.");
            }
        } else if (a == 0) {
            double x = -c / b;
            System.out.println("Phương trình bậc nhất có nghiệm: x = " + x);
        } else {
            double delta = (b * b) - (4 * a * c);
            System.out.println("Giá trị Delta: " + delta);
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Phương trình có 2 nghiệm phân biệt:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("Phương trình có nghiệm kép: x = " + x);
            } else {
                System.out.println("Phương trình vô nghiệm.");
            }
        }
        scanner.close();
    }
}

