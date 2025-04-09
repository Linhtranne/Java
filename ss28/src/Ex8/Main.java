package Ex8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotel_management";
    private static final String DB_USER = "linhtranne";
    private static final String DB_PASSWORD = "123456";

    public static void main(String[] args) {
        bookRoom(1, 1);
        bookRoom(2, 1);
        bookRoom(3, 2);
    }

    public static void bookRoom(int customerId, int roomId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            connection.setAutoCommit(false);

            if (!HotelDetail.isCustomerExists(connection, customerId)) {
                HotelDetail.logFailedBooking(connection, customerId, roomId, "Khách hàng không tồn tại");
                connection.rollback();
                System.out.println("Giao dịch thất bại: Khách hàng không tồn tại.");
                return;
            }

            if (!HotelDetail.isRoomAvailable(connection, roomId)) {
                HotelDetail.logFailedBooking(connection, customerId, roomId, "Phòng đã được đặt");
                connection.rollback();
                System.out.println("Giao dịch thất bại: Phòng đã được đặt.");
                return;
            }

            HotelDetail.markRoomUnavailable(connection, roomId);
            HotelDetail.addBooking(connection, customerId, roomId);

            connection.commit();
            System.out.println("Giao dịch thành công: Đã đặt phòng.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}