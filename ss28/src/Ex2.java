import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employees_data";
        String user = "linhtranne";
        String password = "123456";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");

            connection.setAutoCommit(false);
            System.out.println("Đã tắt chế độ auto-commit.");

            String insertSQL1 = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            String insertSQL2 = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement1 = connection.prepareStatement(insertSQL1);
                 PreparedStatement preparedStatement2 = connection.prepareStatement(insertSQL2)) {

                preparedStatement1.setInt(1, 1);
                preparedStatement1.setString(2, "linh");
                preparedStatement1.setString(3, "tuhithanahihi@gmail.com");
                preparedStatement1.executeUpdate();
                System.out.println("Câu lệnh INSERT 1 thực hiện thành công.");

                preparedStatement2.setInt(1, 1);
                preparedStatement2.setString(2, "he");
                preparedStatement2.setString(3, "hehehe@gmail.com");
                preparedStatement2.executeUpdate();
                System.out.println("Câu lệnh INSERT 2 thực hiện thành công.");
            }

            connection.commit();
            System.out.println("Đã commit thay đổi.");
        } catch (SQLException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Đã rollback thay đổi.");
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
        try (Connection verifyConnection = DriverManager.getConnection(url, user, password);
             PreparedStatement verifyStatement = verifyConnection.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            verifyStatement.setInt(1, 1);
            try (ResultSet resultSet = verifyStatement.executeQuery()) {
                if (!resultSet.next()) {
                    System.out.println("Không có dữ liệu nào được thêm vào cơ sở dữ liệu.");
                } else {
                    System.out.println("Dữ liệu vẫn tồn tại trong cơ sở dữ liệu:");
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Email: " + resultSet.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
    }
}