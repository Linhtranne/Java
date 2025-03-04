import java.util.Scanner;
public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tháng");
        int month = scanner.nextInt();
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            System.out.println("Tháng " + month + " có 31 ngày");
        }
        else if (month == 2){
            System.out.println("Tháng 2 có 28 hoặc 29 ngày");
        }else if (month == 4 || month == 6 || month == 9 || month == 11){
            System.out.println("Tháng " + month + " có 31 ngày");
        }else{
            System.out.println("Tháng không hợp lệ");
        }
        scanner.close();
    }
}
