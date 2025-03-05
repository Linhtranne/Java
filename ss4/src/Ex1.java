import java.util.Scanner;
public class Ex1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập một số nguyên dương N");
        int a = scanner.nextInt();
        if( a > 0){
            int sum = 0;
            for(int i = 1; i <= a; i++){
                sum = sum+ i;
            }
            System.out.println("Tổng các số từ 1 đến"+ a +"là" + sum);
        }else {
            System.out.println("Số nhập vào không hợp lệ");
        }
    }
}
