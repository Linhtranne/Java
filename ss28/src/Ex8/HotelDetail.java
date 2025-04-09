package Ex8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelDetail {
    public static boolean isCustomerExists(Connection connection, int customerId) throws SQLException {
        String query = "SELECT COUNT(*) FROM customers WHERE customer_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public static boolean isRoomAvailable(Connection connection, int roomId) throws SQLException {
        String query = "SELECT availability FROM rooms WHERE room_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, roomId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean("availability");
                }
            }
        }
        return false;
    }

    public static void markRoomUnavailable(Connection connection, int roomId) throws SQLException {
        String update = "UPDATE rooms SET availability = FALSE WHERE room_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(update)) {
            stmt.setInt(1, roomId);
            stmt.executeUpdate();
        }
    }

    public static void addBooking(Connection connection, int customerId, int roomId) throws SQLException {
        String insert = "INSERT INTO bookings (customer_id, room_id, booking_date, status) VALUES (?, ?, NOW(), 'Confirmed')";
        try (PreparedStatement stmt = connection.prepareStatement(insert)) {
            stmt.setInt(1, customerId);
            stmt.setInt(2, roomId);
            stmt.executeUpdate();
        }
    }

    public static void logFailedBooking(Connection connection, int customerId, int roomId, String reason) throws SQLException {
        String insert = "INSERT INTO failed_bookings (customer_id, room_id, reason) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(insert)) {
            stmt.setInt(1, customerId);
            stmt.setInt(2, roomId);
            stmt.setString(3, reason);
            stmt.executeUpdate();
        }
    }
}