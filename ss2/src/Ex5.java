import java.util.Scanner;

public class Ex5 {
    public static double areaCaculate(double length, double width) {
        return length * width;
    }
    public static double prerimeterCaculate(double length, double width) {
        return 2 * (length + width);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chiều dài hình chữ nhật: ");
        double length = scanner.nextDouble();
        System.out.print("Nhập chiều rộng hình chữ nhật: ");
        double width = scanner.nextDouble();
        double area = areaCaculate(length, width);
        double prerimeter = prerimeterCaculate(length, width);
        System.out.println("Diện tích hình chữ nhật là: " + area);
        System.out.println("Chu vi hình chữ nhật là: " + prerimeter);
    }
}
