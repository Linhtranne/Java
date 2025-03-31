package Ex9;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        bookManager.addBook(new Book(1, "Book1", "Author1", "2005", 150000));
        bookManager.addBook(new Book(2, "Book2", "Author2", "2006", 200000));
        bookManager.addBook(new Book(3, "Book3", "Author3", "2007", 300000));
        bookManager.addBook(new Book(4, "Book4", "Author4", "2008", 400000));

        writeToFile(bookManager.books);
        System.out.println("Danh sách sách từ file:");
        readFromFile();

        // Display all books in memory
        System.out.println("\nDanh sách sách trong bộ nhớ:");
        bookManager.displayAllBooks();

        bookManager.updateBook(new Book(2, "Book5", "Author5", "2009", 50000));
        System.out.println("\nDanh sách sau khi cập nhật:");
        bookManager.displayAllBooks();

        bookManager.deleteBook(3);
        System.out.println("\nDanh sách sau khi xóa:");
        bookManager.displayAllBooks();

        writeToFile(bookManager.books);
        System.out.println("Đã lưu danh sách cập nhật vào file.");
    }

    public static void writeToFile(List<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
            oos.writeObject(books);
            System.out.println("Đã ghi danh sách sách vào file books.dat");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.dat"))) {
            List<Book> books = (List<Book>) ois.readObject();
            books.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}