import java.util.Scanner;

        public class Ex4 {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int sum = 0;
                int number;

                System.out.println("Nhập số:");

                while (true) {
                    number = scanner.nextInt();
                    if (number == 0) {
                        break;
                    }
                    sum += number;
                }

                System.out.println("Tổng các số đã nhập: " + sum);
            }
        }


