import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employees_data";
        String user = "linhtranne";
        String password = "123456";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");

            boolean autoCommit = connection.getAutoCommit();
            System.out.println("Trạng thái auto-commit ban đầu: " + autoCommit);

            connection.setAutoCommit(false);
            System.out.println("Đã tắt chế độ auto-commit.");

            String insertSQL = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setInt(1, 1);
                preparedStatement.setString(2, "linh");
                preparedStatement.setString(3, "tuhithanahihi@gmail.com");
                int rowsInserted = preparedStatement.executeUpdate();
                System.out.println("Số dòng được chèn: " + rowsInserted);
            }

            connection.commit();
            System.out.println("Đã commit thay đổi.");
            String selectSQL = "SELECT * FROM users WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
                preparedStatement.setInt(1, 1);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("Dữ liệu đã được thêm vào cơ sở dữ liệu:");
                        System.out.println("ID: " + resultSet.getInt("id"));
                        System.out.println("Name: " + resultSet.getString("name"));
                        System.out.println("Email: " + resultSet.getString("email"));
                    } else {
                        System.out.println("Không tìm thấy dữ liệu.");
                    }
                }
            }

        } catch (SQLException e) {
            e.fillInStackTrace();
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
    }
}