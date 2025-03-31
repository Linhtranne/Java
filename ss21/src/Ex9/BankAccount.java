package Ex9;

class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount() {}

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền gửi phải lớn hơn 0");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền rút phải lớn hơn 0");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Số dư không đủ để rút tiền");
        }
        balance -= amount;
    }

    public void transfer(BankAccount targetAccount, double amount) {
        if (targetAccount == null) {
            throw new IllegalArgumentException("Tài khoản đích không tồn tại");
        }
        this.withdraw(amount);
        targetAccount.deposit(amount);
    }
}