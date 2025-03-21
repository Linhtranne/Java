import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Ex7 {

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
        System.out.println("Các phần tử xuất hiện đúng một lần:");
        for(int i = 0; i < list.size(); i++) {
            int count = 0;
            for(int j = 0; j < list.size(); j++) {
                if(list.get(i) == list.get(j)) {
                    count++;
                }
            }
            if(count == 1) {
                System.out.println(list.get(i));
            }
        }
        System.out.println("Các phần tử bị trùng lặp kèm số lần xuất hiện:");
        for(int i = 0; i < list.size(); i++) {
            int count = 0;
            for(int j = 0; j < list.size(); j++) {
                if(list.get(i) == list.get(j)) {
                    count++;
                }
            }
            if(count > 1) {
                System.out.println("Phần tử " + list.get(i) + " xuất hiện " + count + " lần");
                for(int j = i + 1; j < list.size(); j++) {
                    if(list.get(i) == list.get(j)) {
                        list.remove(j);
                        j--;
                    }
                }
            }
        }
    }
}
