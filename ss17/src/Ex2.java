import java.util.HashSet;
import java.util.Scanner;
public class Ex2 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("JavaScript");
        System.out.println("Nhập chuỗi cần kiểm tra: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (set.contains(str)) {
            System.out.println("Chuỗi " + str + " có trong set");
        } else {
            System.out.println("Chuỗi " + str + " không có trong set");
        }

    }
}
