package Ex1;

public class Main {
    public static void main(String[] args) {
        Account account1 = Account.getInstance();
        Account account2 = Account.getInstance();

        if (account1 == account2) {
            System.out.println("Chỉ có một đối tượng Account được tạo.");
        } else {
            System.out.println("Có nhiều đối tượng Account được tạo.");
        }
    }
}