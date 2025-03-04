import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập hệ số a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập hệ số b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập hệ số c: ");
        double c = scanner.nextDouble();
        System.out.print("Nhập hệ số d: ");
        double d = scanner.nextDouble();
        if (a == 0) {
            System.out.println("Phương trình trở thành phương trình bậc hai dạng: bx^2 + cx + d = 0");

            if (b == 0) {
                if (c == 0) {
                    if (d == 0) {
                        System.out.println("Phương trình có vô số nghiệm.");
                    } else {
                        System.out.println("Phương trình vô nghiệm.");
                    }
                } else {
                    double x = -d / c;
                    System.out.println("Phương trình có nghiệm duy nhất: x = " + x);
                }
            } else {
                double delta = c * c - 4 * b * d;

                if (delta < 0) {
                    System.out.println("Phương trình vô nghiệm.");
                } else if (delta == 0) {
                    double x = -c / (2 * b);
                    System.out.println("Phương trình có nghiệm kép: x = " + x);
                } else {
                    double x1 = (-c + Math.sqrt(delta)) / (2 * b);
                    double x2 = (-c - Math.sqrt(delta)) / (2 * b);
                    System.out.println("Phương trình có hai nghiệm phân biệt: ");
                    System.out.println("x1 = " + x1);
                    System.out.println("x2 = " + x2);
                }
            }
        } else {
            System.out.println("Phương trình là bậc ba: ax^3 + bx^2 + cx + d = 0");
            double p = (3 * a * c - b * b) / (3 * a * a);
            double q = (2 * b * b * b - 9 * a * b * c + 27 * a * a * d) / (27 * a * a * a);
            double delta = (q * q) / 4 + (p * p * p) / 27;
            if (delta > 0) {
                double u = Math.cbrt(-q / 2 + Math.sqrt(delta));
                double v = Math.cbrt(-q / 2 - Math.sqrt(delta));
                double x1 = u + v - b / (3 * a);
                System.out.println("Phương trình có một nghiệm thực: ");
                System.out.println("x1 = " + x1);
            } else if (delta == 0) {
                double u = Math.cbrt(-q / 2);
                double x1 = 2 * u - b / (3 * a);
                double x2 = -u - b / (3 * a);
                System.out.println("Phương trình có nghiệm thực: ");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = x3 = " + x2);
            } else {
                double r = Math.sqrt(-p / 3);
                double phi = Math.acos(-q / (2 * Math.sqrt(-(p * p * p) / 27)));
                double x1 = 2 * r * Math.cos(phi / 3) - b / (3 * a);
                double x2 = 2 * r * Math.cos((phi + 2 * Math.PI) / 3) - b / (3 * a);
                double x3 = 2 * r * Math.cos((phi + 4 * Math.PI) / 3) - b / (3 * a);
                System.out.println("Phương trình có ba nghiệm thực: ");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
                System.out.println("x3 = " + x3);
            }
        }
    }
}