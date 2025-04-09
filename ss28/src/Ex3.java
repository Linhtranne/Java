import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bank_transfer";
        String user = "linhtranne";
        String password = "123456";

        Connection connection = null;

        int accountA = 1;
        int accountB = 2;
        double transferAmount = 500.00;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");

            connection.setAutoCommit(false);

            String deductSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ? AND balance >= ?";
            try (PreparedStatement deductStmt = connection.prepareStatement(deductSQL)) {
                deductStmt.setDouble(1, transferAmount);
                deductStmt.setInt(2, accountA);
                deductStmt.setDouble(3, transferAmount);

                int rowsUpdated = deductStmt.executeUpdate();
                if (rowsUpdated == 0) {
                    throw new SQLException("Không đủ số dư trong tài khoản A.");
                }
                System.out.println("Đã trừ tiền từ tài khoản A.");
            }

            String addSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            try (PreparedStatement addStmt = connection.prepareStatement(addSQL)) {
                addStmt.setDouble(1, transferAmount);
                addStmt.setInt(2, accountB);

                int rowsUpdated = addStmt.executeUpdate();
                if (rowsUpdated == 0) {
                    throw new SQLException("Không tìm thấy tài khoản B.");
                }
                System.out.println("Đã cộng tiền vào tài khoản B.");
            }

            connection.commit();
            System.out.println("Giao dịch thành công!");

        } catch (SQLException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Đã rollback giao dịch.");
                } catch (SQLException rollbackEx) {
                    rollbackEx.fillInStackTrace();
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Đã đóng kết nối.");
                } catch (SQLException closeEx) {
                    closeEx.fillInStackTrace();
                }
            }
        }
    }
}