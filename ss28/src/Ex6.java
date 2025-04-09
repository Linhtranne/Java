import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex6 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employees_data";
        String user = "linhtranne";
        String password = "123456";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");
            connection.setAutoCommit(false);

            String insertDepartmentSQL = "INSERT INTO departments (id, name) VALUES (?, ?)";
            try (PreparedStatement departmentStmt = connection.prepareStatement(insertDepartmentSQL)) {
                departmentStmt.setInt(1, 1); // ID của phòng ban
                departmentStmt.setString(2, "Phòng IT");
                departmentStmt.executeUpdate();
                System.out.println("Đã thêm phòng ban mới.");
            }
            String insertEmployeeSQL = "INSERT INTO employees (id, name, department_id) VALUES (?, ?, ?)";
            try (PreparedStatement employeeStmt = connection.prepareStatement(insertEmployeeSQL)) {
                // Nhân viên 1
                employeeStmt.setInt(1, 1);
                employeeStmt.setString(2, "A");
                employeeStmt.setInt(3, 1);
                employeeStmt.executeUpdate();

                // Nhân viên 2
                employeeStmt.setInt(1, 2);
                employeeStmt.setString(2, "B");
                employeeStmt.setInt(3, 1);
                employeeStmt.executeUpdate();

                System.out.println("Đã thêm nhân viên vào phòng ban.");
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
                    System.out.println("Lỗi khi rollback: " + rollbackEx.getMessage());
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Đã đóng kết nối.");
                } catch (SQLException closeEx) {
                    System.out.println("Lỗi khi đóng kết nối: " + closeEx.getMessage());
                }
            }
        }
    }
}