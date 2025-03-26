import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        System.out.println("Nhập danh sách chuỗi:");
            String input = scanner.nextLine();
            strings.add(input);

        int count = 0;
        for (String str : strings) {
            if (str.startsWith("A") && str.length() >= 5) {
                count++;
            }
        }

        System.out.println("Số lượng chuỗi bắt đầu bằng chữ cái 'A'" + count);
    }
}