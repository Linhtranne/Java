package StudentList.business.config;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "";
    private static final String URL = "jdbc:mysql://localhost:3306/StudentManagement";
    private static final String USER_NAME = "lịnhtranne";
    private static final String PASSWORD = "123456";

    public static ConnectionDB openConnection() {
        ConnectionDB conn = null;
        try {
            conn = (ConnectionDB) DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Có lỗi trong quá trình kết nối với CSDL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Có lỗi không xác định trong quá trình kết nối: " + e.getMessage());
        }
        return conn;
    }

    public static void closeConnection(ConnectionDB conn, CallableStatement callSt) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (callSt != null) {
            try {
                callSt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}