import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex4 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bank_accounts";
        String user = "linhtranne";
        String password = "123456";

        Connection connectionA = null;
        Connection connectionB = null;

        int account1 = 1;
        int account2 = 2;
        double transferAmount = 500.00;

        try {
            connectionA = DriverManager.getConnection(url, user, password);
            connectionB = DriverManager.getConnection(url, user, password);

            connectionA.setAutoCommit(false);
            connectionB.setAutoCommit(false);
            String deductSQL = "UPDATE bank_accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
            try (PreparedStatement deductStmt = connectionA.prepareStatement(deductSQL)) {
                deductStmt.setDouble(1, transferAmount);
                deductStmt.setInt(2, account1);
                deductStmt.setDouble(3, transferAmount);

                int rowsUpdated = deductStmt.executeUpdate();
                if (rowsUpdated == 0) {
                    throw new SQLException("Không đủ số dư trong tài khoản A.");
                }
                System.out.println("Đã trừ tiền từ tài khoản A.");
            }
            String addSQL = "UPDATE bank_accounts SET balance = balance + ? WHERE account_id = ?";
            try (PreparedStatement addStmt = connectionB.prepareStatement(addSQL)) {
                addStmt.setDouble(1, transferAmount);
                addStmt.setInt(2, account2);

                int rowsUpdated = addStmt.executeUpdate();
                if (rowsUpdated == 0) {
                    throw new SQLException("Không tìm thấy tài khoản B.");
                }
                System.out.println("Đã cộng tiền vào tài khoản B.");
            }
            connectionA.commit();
            connectionB.commit();
            System.out.println("Giao dịch thành công!");

        } catch (SQLException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            try {
                if (connectionA != null) {
                    connectionA.rollback();
                    System.out.println("Đã rollback kết nối A.");
                }
                if (connectionB != null) {
                    connectionB.rollback();
                    System.out.println("Đã rollback kết nối B.");
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.fillInStackTrace();
            }
        } finally {
            try {
                if (connectionA != null) {
                    connectionA.close();
                    System.out.println("Đã đóng kết nối A.");
                }
                if (connectionB != null) {
                    connectionB.close();
                    System.out.println("Đã đóng kết nối B.");
                }
            } catch (SQLException closeEx) {
                closeEx.fillInStackTrace();
            }
        }
    }
}