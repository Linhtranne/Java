import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        System.out.print("Nhập số phần tử của danh sách: ");
        int n = scanner.nextInt();
        System.out.println("Nhập các phần tử của danh sách:");
        for(int i = 0; i < n; i++) {
            String x = scanner.next();
            list.add(x);
        }
        System.out.println("Danh sách trước khi sắp xếp:");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for(int i = 0; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++) {
                if(list.get(i).length() > list.get(j).length()) {
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                } else if(list.get(i).length() == list.get(j).length()) {
                    if(list.get(i).compareTo(list.get(j)) > 0) {
                        String temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                    }
                }
            }
        }
        System.out.println("Danh sách sau khi sắp xếp:");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
