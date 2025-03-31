import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 5000000;

        System.out.println("Số dư hiện tại: " + balance + " đồng");
        System.out.println("Nhập số tiền muốn rút: ");

        try {
            double amount = scanner.nextDouble();

            if (amount <= 0) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
            } else if (amount > balance) {
                System.out.println("Lỗi: Số tiền rút vượt quá số dư!");
            } else if (balance - amount < 50000) {
                System.out.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
            } else {
                balance -= amount;
                System.out.println("Rút tiền thành công! Số dư còn lại: " + balance + " đồng");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
        }
    }
}