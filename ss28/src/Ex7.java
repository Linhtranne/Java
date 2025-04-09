import java.sql.*;

public class Ex7 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/orders";
        String user = "linhtranne";
        String password = "123456";

        testIsolationLevel(Connection.TRANSACTION_READ_UNCOMMITTED, "READ_UNCOMMITTED", url, user, password);
        testIsolationLevel(Connection.TRANSACTION_READ_COMMITTED, "READ_COMMITTED", url, user, password);
        testIsolationLevel(Connection.TRANSACTION_REPEATABLE_READ, "REPEATABLE_READ", url, user, password);
        testIsolationLevel(Connection.TRANSACTION_SERIALIZABLE, "SERIALIZABLE", url, user, password);
    }

    private static void testIsolationLevel(int isolationLevel, String levelName, String url, String user, String password) {
        try (Connection connection1 = DriverManager.getConnection(url, user, password);
             Connection connection2 = DriverManager.getConnection(url, user, password)) {

            connection1.setTransactionIsolation(isolationLevel);
            connection1.setAutoCommit(false);
            connection2.setAutoCommit(false);
            String insertSQL = "INSERT INTO orders (customer_name, status) VALUES (?, ?)";
            try (PreparedStatement insertStmt = connection2.prepareStatement(insertSQL)) {
                insertStmt.setString(1, "A");
                insertStmt.setString(2, "Đang chờ");
                insertStmt.executeUpdate();
                System.out.println("Connection2: Đã chèn dữ liệu nhưng chưa commit.");
            }

            String selectSQL = "SELECT * FROM orders";
            try (Statement selectStmt = connection1.createStatement();
                 ResultSet rs = selectStmt.executeQuery(selectSQL)) {
                System.out.println("Connection1: Kết quả:");
                while (rs.next()) {
                    System.out.printf("Order ID: %d, Customer Name: %s, Status: %s%n",
                            rs.getInt("order_id"), rs.getString("customer_name"), rs.getString("status"));
                }
            }

            connection2.rollback();
            System.out.println("Connection2: Đã rollback.");

        } catch (SQLException e) {
            e.fillInStackTrace();
        }
    }
}