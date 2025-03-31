import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> validNumbers = new ArrayList<>();
        int invalidCount = 0;
        System.out.println("Nhập vào danh sách các chuỗi ");
        String input = scanner.nextLine();
        String[] strings = input.split(",");

        for (String str : strings) {
            str = str.trim();
            try {
                int number = Integer.parseInt(str);
                validNumbers.add(number);
            } catch (NumberFormatException e) {
                invalidCount++;
            }
        }

        System.out.println("Số lượng chuỗi hợp lệ: " + validNumbers.size());
        System.out.println("Số lượng chuỗi không hợp lệ: " + invalidCount);
        System.out.println("Danh sách các số nguyên đã chuyển đổi thành công: " + validNumbers);
    }
}