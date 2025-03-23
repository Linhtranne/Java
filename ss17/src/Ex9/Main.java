package Ex9;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("1", "hehe", "he", 2025));
        bookSet.add(new Book("2", "hehehe", "ha", 2024));

        List<Book> filteredBooks = new ArrayList<>(bookSet);
        Collections.sort(filteredBooks, Comparator.comparing(Book::getTitle));
        for (Book book : filteredBooks) {
            System.out.println(book);
        }
    }
}