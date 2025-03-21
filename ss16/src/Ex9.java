import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.print("Nhập số phần tử của danh sách: ");
        int n = scanner.nextInt();
        System.out.println("Nhập các phần tử của danh sách:");
        for(int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
        }
        List<Integer> prime = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            if(isPrime(x)) {
                prime.add(x);
            } else if(x % 2 == 0) {
                even.add(x);
            } else {
                odd.add(x);
            }
        }
        System.out.println("Danh sách các số nguyên tố:");
        for(int i = 0; i < prime.size(); i++) {
            System.out.println(prime.get(i));
        }
        System.out.println("Danh sách các số chẵn:");
        for(int i = 0; i < even.size(); i++) {
            System.out.println(even.get(i));
        }
        System.out.println("Danh sách các số lẻ:");
        for(int i = 0; i < odd.size(); i++) {
            System.out.println(odd.get(i));
        }
    }

    private static boolean isPrime(int x) {
        if(x < 2) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(x); i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
