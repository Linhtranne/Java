import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex5 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ShopDB";
        String user = "linhtranne";
        String password = "123456";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);

            String insertOrderSQL = "INSERT INTO Orders (customer_name, order_date) VALUES (?, ?)";
            try (PreparedStatement orderStmt = connection.prepareStatement(insertOrderSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
                orderStmt.setString(1, "linh");
                orderStmt.setDate(2, java.sql.Date.valueOf("01-01-2025"));
                orderStmt.executeUpdate();

                try (var generatedKeys = orderStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int orderId = generatedKeys.getInt(1);
                        String insertDetailSQL = "INSERT INTO OrderDetails (order_id, product_name, quantity) VALUES (?, ?, ?)";
                        try (PreparedStatement detailStmt = connection.prepareStatement(insertDetailSQL)) {

                            detailStmt.setInt(1, orderId);
                            detailStmt.setString(2, "Áo");
                            detailStmt.setInt(3, 2);
                            detailStmt.executeUpdate();

                            detailStmt.setInt(1, orderId);
                            detailStmt.setString(2, "Quần");
                            detailStmt.setInt(3, -1);
                            detailStmt.executeUpdate();
                        }
                    }
                }
            }

            connection.commit();
            System.out.println("Giao dịch thành công!");

        } catch (SQLException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            try {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("Đã rollback giao dịch.");
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.fillInStackTrace();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                    System.out.println("Đã đóng kết nối.");
                }
            } catch (SQLException closeEx) {
                closeEx.fillInStackTrace();
            }
        }
    }
}