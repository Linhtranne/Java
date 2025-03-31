import java.util.Scanner;
public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Nhập vào chỉ số của mảng: ");
        int index = scanner.nextInt();
        try {
            System.out.println("Giá trị của phần tử tại chỉ số " + index + " là " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Chỉ số vượt quá giới hạn của mảng");

        }
    }
}
