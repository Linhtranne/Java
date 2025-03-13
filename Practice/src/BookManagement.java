import java.util.*;

public class BookManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> bookList = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n************ MENU ************");
            System.out.println("1. Danh sách sách");
            System.out.println("2. Thêm mới sách");
            System.out.println("3. Tính lợi nhuận của các sách");
            System.out.println("4. Cập nhật sách");
            System.out.println("5. Xóa sách");
            System.out.println("6. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("7. Tìm kiếm sách theo tác giả");
            System.out.println("8. Tìm kiếm sách theo khoảng giá bán");
            System.out.println("9. Thống kê sách theo mỗi tác giả");
            System.out.println("10. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    if (bookList.isEmpty()) {
                        System.out.println("Danh sách sách trống!");
                    } else {
                        for (Book b : bookList) {
                            b.displayData();
                            System.out.println("----------------------------");
                        }
                    }
                    break;
                case 2:
                    Book newBook = new Book();
                    newBook.inputData(scanner);
                    bookList.add(newBook);
                    System.out.println("Thêm sách thành công!");
                    break;
                case 3:
                    if (bookList.isEmpty()) {
                        System.out.println("Danh sách sách trống!");
                    } else {
                        for (Book b : bookList) {
                            b.calInterest();
                            System.out.println("Lợi nhuận của sách " + b.getBookName() + ": " + b.getInterest());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sách cần cập nhật: ");
                    String updateId = scanner.nextLine();
                    boolean foundUpdate = false;
                    for (Book b : bookList) {
                        if (b.getBookId().equals(updateId)) {
                            System.out.println("Nhập thông tin mới cho sách:");
                            b.inputData(scanner);
                            System.out.println("Cập nhật thành công!");
                            foundUpdate = true;
                            break;
                        }
                    }
                    if (!foundUpdate) {
                        System.out.println("Không tìm thấy sách có mã: " + updateId);
                    }
                    break;
                case 5:
                    System.out.print("Nhập mã sách cần xóa: ");
                    String deleteId = scanner.nextLine();
                    boolean foundDelete = false;
                    Iterator<Book> iterator = bookList.iterator();
                    while (iterator.hasNext()) {
                        Book b = iterator.next();
                        if (b.getBookId().equals(deleteId)) {
                            iterator.remove();
                            System.out.println("Xóa thành công!");
                            foundDelete = true;
                            break;
                        }
                    }
                    if (!foundDelete) {
                        System.out.println("Không tìm thấy sách có mã: " + deleteId);
                    }
                    break;
                case 6:
                    if (bookList.isEmpty()) {
                        System.out.println("Danh sách sách trống!");
                    } else {
                        bookList.sort(Comparator.comparingDouble(Book::getInterest));
                        System.out.println("Sắp xếp thành công theo lợi nhuận tăng dần!");
                    }
                    break;
                case 7:
                    System.out.print("Nhập tác giả cần tìm: ");
                    String searchAuthor = scanner.nextLine();
                    boolean foundAuthor = false;
                    for (Book b : bookList) {
                        if (b.getAuthor().equalsIgnoreCase(searchAuthor)) {
                            b.displayData();
                            System.out.println("----------------------------");
                            foundAuthor = true;
                        }
                    }
                    if (!foundAuthor) {
                        System.out.println("Không tìm thấy sách của tác giả: " + searchAuthor);
                    }
                    break;
                case 8:
                    System.out.print("Nhập khoảng giá bán (min max): ");
                    double min = Double.parseDouble(scanner.next());
                    double max = Double.parseDouble(scanner.next());
                    scanner.nextLine();
                    boolean foundPrice = false;
                    for (Book b : bookList) {
                        if (b.getExportPrice() >= min && b.getExportPrice() <= max) {
                            b.displayData();
                            System.out.println("----------------------------");
                            foundPrice = true;
                        }
                    }
                    if (!foundPrice) {
                        System.out.println("Không có sách nào trong khoảng giá bán từ " + min + " đến " + max);
                    }
                    break;
                case 9:
                    if (bookList.isEmpty()) {
                        System.out.println("Danh sách sách trống!");
                    } else {
                        int bookCount = bookList.size();
                        String[] authors = new String[bookCount];
                        int[] counts = new int[bookCount];
                        int authorCount = 0;

                        for (int i = 0; i < bookCount; i++) {
                            String author = bookList.get(i).getAuthor();
                            boolean found = false;
                            for (int j = 0; j < authorCount; j++) {
                                if (authors[j].equals(author)) {
                                    counts[j]++;
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                authors[authorCount] = author;
                                counts[authorCount] = 1;
                                authorCount++;
                            }
                        }

                        for (int i = 0; i < authorCount; i++) {
                            System.out.println("Tác giả: " + authors[i] + " - Số lượng sách: " + counts[i]);
                        }
                    }
                    break;
                case 10:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Chức năng chưa được triển khai.");
            }
        } while (choice != 10);

        scanner.close();
    }
}

class Book {
    private String bookId;
    private String bookName;
    private double importPrice;
    private double exportPrice;
    private String title;
    private String author;
    private double interest;
    private int year;

    public Book() {}

    public Book(String bookId, String bookName, double importPrice, double exportPrice, String title, String author, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.author = author;
        this.year = year;
        calInterest();
    }

    public void calInterest() {
        this.interest = this.exportPrice - this.importPrice;
    }

    public void inputData(Scanner scanner) {
        while (true) {
            System.out.print("Nhập mã sách: ");
            this.bookId = scanner.nextLine();
            if (this.bookId.matches("B\\d{4}")) break;
            System.out.println("Mã sách không hợp lệ! Phải có dạng Bxxxx.");
        }

        while (true) {
            System.out.print("Nhập tên sách: ");
            this.bookName = scanner.nextLine();
            if (this.bookName.length() >= 6 && this.bookName.length() <= 100) break;
            System.out.println("Tên sách không hợp lệ!");
        }

        while (true) {
            System.out.print("Nhập giá nhập: ");
            try {
                this.importPrice = Double.parseDouble(scanner.nextLine());
                if (this.importPrice > 0) break;
                System.out.println("Giá nhập phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Giá nhập phải là số!");
            }
        }

        while (true) {
            System.out.print("Nhập giá bán: ");
            try {
                this.exportPrice = Double.parseDouble(scanner.nextLine());
                if (this.exportPrice >= this.importPrice * 1.1) break;
                System.out.println("Giá bán phải lớn hơn giá nhập ít nhất 10%");
            } catch (NumberFormatException e) {
                System.out.println("Giá bán phải là số!");
            }
        }

        while (true) {
            System.out.print("Nhập tiêu đề sách: ");
            this.title = scanner.nextLine();
            if (!this.title.trim().isEmpty()) break;
            System.out.println("Tiêu đề không được để trống!");
        }

        while (true) {
            System.out.print("Nhập tác giả: ");
            this.author = scanner.nextLine();
            if (!this.author.trim().isEmpty()) break;
            System.out.println("Tác giả không được để trống!");
        }

        while (true) {
            System.out.print("Nhập năm xuất bản: ");
            try {
                this.year = Integer.parseInt(scanner.nextLine());
                if (this.year > 1970) break;
                System.out.println("Năm xuất bản phải sau năm 1970");
            } catch (NumberFormatException e) {
                System.out.println("Năm xuất bản phải là số nguyên!");
            }
        }

        calInterest();
    }

    public void displayData() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Giá Nhập: " + importPrice);
        System.out.println("Giá Bán: " + exportPrice);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Năm xuất bản: " + year);
        System.out.println("Lợi nhuận: " + interest);
    }

    public String getBookId() { return bookId; }
    public String getBookName() { return bookName; }
    public double getImportPrice() { return importPrice; }
    public double getExportPrice() { return exportPrice; }
    public double getInterest() { return interest; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
        calInterest();
    }
}
