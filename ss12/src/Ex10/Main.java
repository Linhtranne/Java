package Ex10;

public class Main {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCard(1000000);
        PaymentMethod debitCard = new DebitCard(1000000);
        PaymentMethod cash = new Cash(1000000);
        creditCard.processPayment();
        creditCard.processPayment(1020, "USD");
        System.out.println();
        debitCard.processPayment();
        debitCard.processPayment(1010, "EUR");
        System.out.println();
        cash.processPayment();
        cash.processPayment(1000, "JPY");
    }
}
