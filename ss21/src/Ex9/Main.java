package Ex9;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        // Khởi tạo một số tài khoản mẫu
        accounts.add(new BankAccount("123", 1000000));
        accounts.add(new BankAccount("456", 2000000));
        accounts.add(new BankAccount("789", 3000000));

        while (true) {
            System.out.println("Chọn chức năng");
            System.out.println("1. Gửi tiền");
            System.out.println("2. Rút tiền");
            System.out.println("3. Chuyển tiền");
            System.out.println("4. Thoát");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Nhập số tài khoản:");
                    String accountId = scanner.nextLine();
                    BankAccount account = findAccount(accounts, accountId);
                    if (account == null) {
                        System.out.println("Tài khoản không tồn tại");
                        break;
                    }
                    System.out.println("Nhập số tiền gửi:");
                    double depositAmount = scanner.nextDouble();
                    try {
                        account.deposit(depositAmount);
                        System.out.println("Gửi tiền thành công. Số dư hiện tại: " + account.getBalance());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Nhập số tài khoản:");
                    accountId = scanner.nextLine();
                    account = findAccount(accounts, accountId);
                    if (account == null) {
                        System.out.println("Tài khoản không tồn tại");
                        break;
                    }
                    System.out.println("Nhập số tiền rút:");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        account.withdraw(withdrawAmount);
                        System.out.println("Rút tiền thành công. Số dư hiện tại: " + account.getBalance());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Nhập số tài khoản nguồn:");
                    String sourceAccountId = scanner.nextLine();
                    BankAccount sourceAccount = findAccount(accounts, sourceAccountId);
                    if (sourceAccount == null) {
                        System.out.println("Tài khoản nguồn không tồn tại");
                        break;
                    }
                    System.out.println("Nhập số tài khoản đích:");
                    String targetAccountId = scanner.nextLine();
                    BankAccount targetAccount = findAccount(accounts, targetAccountId);
                    if (targetAccount == null) {
                        System.out.println("Tài khoản đích không tồn tại");
                        break;
                    }
                    System.out.println("Nhập số tiền chuyển:");
                    double transferAmount = scanner.nextDouble();
                    try {
                        sourceAccount.transfer(targetAccount, transferAmount);
                        System.out.println("Chuyển tiền thành công. Số dư tài khoản nguồn: " + sourceAccount.getBalance());
                        System.out.println("Số dư tài khoản đích: " + targetAccount.getBalance());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Thoát chương trình");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private static BankAccount findAccount(List<BankAccount> accounts, String accountId) {
        for (BankAccount account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }
}
