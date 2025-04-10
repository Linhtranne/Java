package business.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class connectionDB {
    private static final String DRIVER = "";
    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER_NAME = "linhtranne";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Có lỗi trong quá trình kết nối với CSDL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Có lỗi không xác định trong quá trình kết nối: " + e.getMessage());
        }
        return conn;
    }
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.fillInStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Đã kết nối với database!");
            closeConnection(conn);
        } else {
            System.out.println("Kết nối thất bại.");
        }
    }

}
