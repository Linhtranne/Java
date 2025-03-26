package Ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập x:");
        int x = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập y:");
        int y = Integer.parseInt(sc.nextLine());

        System.out.println("Cộng: " + Math.add(x, y));
        System.out.println("Trừ: " + Math.subtract(x, y));
        System.out.println("Nhân: " + Math.multiply(x, y));
        try {
            System.out.println("Chia: " + Math.divide(x, y));
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}