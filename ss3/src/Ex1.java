import  java.util.Scanner;
public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số : ");
        int number = scanner.nextInt();
        if( number % 2 == 0 ){
            System.out.println("Số " + number +" là số chẵn");
        }
        else if ( number % 2 != 0 ){
            System.out.println("Số " + number +" là số lẻ");
        }
        else{
            System.out.println("Số" + number +" không phải chẵn cũng không phải lẻ");
        }
    }
}
