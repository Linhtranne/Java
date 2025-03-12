
public class Ex8 {
    public static class BankAccount {
        private String accountNumber;
        private String accountHolder;
        private double balance;
        public BankAccount(String accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Nạp tiền thành công. Số dư mới: " + balance);
            } else {
                System.out.println("Số tiền nạp không hợp lệ.");
            }
        }
        public void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Số dư không đủ.");
            } else if (amount > 0) {
                balance -= amount;
                System.out.println("Rút tiền thành công. Số dư mới: " + balance);
            } else {
                System.out.println("Số tiền rút không hợp lệ.");
            }
        }
        public void transfer(BankAccount recipient, double amount) {
            if (amount > balance) {
                System.out.println("Số dư không đủ để chuyển tiền.");
            } else if (amount > 0) {
                this.balance -= amount;
                recipient.balance += amount;
                System.out.println("Chuyển tiền thành công. Số dư mới: " + this.balance);
            } else {
                System.out.println("Số tiền chuyển không hợp lệ.");
            }
        }
        public void display() {
            System.out.println("Số tài khoản: " + accountNumber);
            System.out.println("Chủ tài khoản: " + accountHolder);
            System.out.println("Số dư: " + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123456", "Nguyen Van A", 5000);
        BankAccount account2 = new BankAccount("789012", "Tran Thi B", 3000);
        account1.display();
        account2.display();
        account1.deposit(2000);
        account1.display();
        account2.withdraw(1000);
        account2.display();
        account1.transfer(account2, 1500);
        account1.display();
        account2.display();
    }
}