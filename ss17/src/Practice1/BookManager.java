package Practice1;


import java.util.Comparator;
import java.util.Scanner;

public class BookManager {
    public static void addBook (Scanner scanner ){
        System.out.println("Nhập số lượng sâch muốn thêm vào");
        int n= Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            entity.Book newBook = new entity.Book();
            newBook.inputData(scanner);
            Main.listBook.add(newBook);
        }
    }
    public static void bookProfit(Scanner  scanner){
        System.out.print("Nhập ID sách cần tính lợi nhuận: ");
        String findId = scanner.nextLine();
        for (entity.Book book : Main.listBook) {
            if (book.getBookId().equalsIgnoreCase(findId)) {
                System.out.printf("Lợi nhuận của sách %s là: %.2f\n", book.getBookName(), book.getInterest());
                return;
            }
        }
        System.out.println("Không tìm thấy sách!");
    }
    public static void displayBooks() {
        if (Main.listBook.isEmpty()) {
            System.out.println("Danh sách sách trống!");
        } else {
            System.out.println("Danh sách sách:");
            for (entity.Book book : Main.listBook) {
                System.out.println(book);
            }
        }
    }

    public static void sortBooksByPrice() {
        Main.listBook.sort(Comparator.comparingDouble(entity.Book::getExportPrice).reversed());
        System.out.println("Sắp xếp sách theo giá bán giảm dần:");
        displayBooks();
    }

    public static void sortBooksByProfit() {
        Main.listBook.sort(Comparator.comparingDouble(entity.Book::getInterest).reversed());
        System.out.println("Sắp xếp sách theo lợi nhuận giảm dần:");
        displayBooks();
    }

    public static void searchBookByName(Scanner scanner) {
        System.out.print("Nhập tên sách cần tìm: ");
        String name = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (entity.Book book : Main.listBook) {
            if (book.getBookName().toLowerCase().contains(name)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách!");
        }
    }
    public static void statisticByYear() {
        System.out.println("Thống kê số lượng sách theo năm xuất bản:");
        for (int i = 0; i < Main.listBook.size(); i++) {
            int count = 0;
            int year = Main.listBook.get(i).getYear();
            boolean isCounted = false;

            for (int j = 0; j < i; j++) {
                if (Main.listBook.get(j).getYear() == year) {
                    isCounted = true;
                    break;
                }
            }

            if (!isCounted) {
                for (entity.Book book : Main.listBook) {
                    if (book.getYear() == year) {
                        count++;
                    }
                }
                System.out.println("Năm " + year + ": " + count + " sách");
            }
        }
    }

    public static void statisticByAuthor() {
        System.out.println("Thống kê số lượng sách theo tác giả:");
        for (int i = 0; i < Main.listBook.size(); i++) {
            int count = 0;
            String author = Main.listBook.get(i).getAuthor();
            boolean isCounted = false;
            for (int j = 0; j < i; j++) {
                if (Main.listBook.get(j).getAuthor().equalsIgnoreCase(author)) {
                    isCounted = true;
                    break;
                }
            }
            if (!isCounted) {
                for (entity.Book book : Main.listBook) {
                    if (book.getAuthor().equalsIgnoreCase(author)) {
                        count++;
                    }
                }
                System.out.println(author + ": " + count + " sách");
            }
        }
    }
}