import java.util.HashSet;
import java.util.Scanner;
public class Ex7 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        System.out.println("Nhập một đoạn văn bản: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] words = str.toLowerCase().split("\\W+");
        for (String word : words) {
            set.add(word);
        }
        for (String word : set) {
            int count = 0;
            for (String s : words) {
                if (word.equals(s)) {
                    count++;
                }
            }
            System.out.println(word+" "+ count);
        }

    }

}
