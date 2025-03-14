public class Ex4 {
    public static class book {
        private String title;
        private String author;
        private double price;
        private String getTitle() {
            return title;
        }
        private void setTitle(String title) {
            this.title = title;
        }
        private String getAuthor() {
            return author;
        }
        private void setAuthor(String author) {
            this.author = author;
        }
        private double getPrice() {
            return price;
        }
        private void setPrice(double price) {
            this.price = price;
        }

    }
    public static void main(String[] args) {
        book book = new book();
        book.setTitle("Java");
        book.setAuthor("Join");
        book.setPrice(50.0);
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Price: " + book.getPrice());
    }
}

