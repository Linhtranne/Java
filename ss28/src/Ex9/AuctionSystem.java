package Ex9;

import java.sql.*;

public class AuctionSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/auction_system";
    private static final String DB_USER = "linhtranne";
    private static final String DB_PASSWORD = "123456";

    public static void placeBid(int auctionId, int userId, double bidAmount) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            String checkAuctionSQL = "SELECT highest_bid, status FROM auctions WHERE auction_id = ?";
            try (PreparedStatement checkAuctionStmt = connection.prepareStatement(checkAuctionSQL)) {
                checkAuctionStmt.setInt(1, auctionId);
                try (ResultSet rs = checkAuctionStmt.executeQuery()) {
                    if (!rs.next() || !"OPEN".equals(rs.getString("status"))) {
                        logFailedBid(connection, auctionId, userId, bidAmount, "Phiên đấu giá đã đóng hoặc không tồn tại");
                        connection.rollback();
                        System.out.println("Giao dịch thất bại: Phiên đấu giá không hợp lệ.");
                        return;
                    }

                    double highestBid = rs.getDouble("highest_bid");
                    if (bidAmount <= highestBid) {
                        logFailedBid(connection, auctionId, userId, bidAmount, "Giá đặt thấp hơn giá cao nhất hiện tại");
                        connection.rollback();
                        System.out.println("Giao dịch thất bại: Giá đặt không hợp lệ.");
                        return;
                    }
                }
            }

            String checkUserSQL = "SELECT balance FROM users WHERE user_id = ?";
            try (PreparedStatement checkUserStmt = connection.prepareStatement(checkUserSQL)) {
                checkUserStmt.setInt(1, userId);
                try (ResultSet rs = checkUserStmt.executeQuery()) {
                    if (!rs.next() || rs.getDouble("balance") < bidAmount) {
                        logFailedBid(connection, auctionId, userId, bidAmount, "Số dư không đủ");
                        connection.rollback();
                        System.out.println("Giao dịch thất bại: Số dư không đủ.");
                        return;
                    }
                }
            }

            String updateAuctionSQL = "UPDATE auctions SET highest_bid = ? WHERE auction_id = ?";
            try (PreparedStatement updateAuctionStmt = connection.prepareStatement(updateAuctionSQL)) {
                updateAuctionStmt.setDouble(1, bidAmount);
                updateAuctionStmt.setInt(2, auctionId);
                updateAuctionStmt.executeUpdate();
            }

            String insertBidSQL = "INSERT INTO bids (auction_id, user_id, bid_amount) VALUES (?, ?, ?)";
            try (PreparedStatement insertBidStmt = connection.prepareStatement(insertBidSQL)) {
                insertBidStmt.setInt(1, auctionId);
                insertBidStmt.setInt(2, userId);
                insertBidStmt.setDouble(3, bidAmount);
                insertBidStmt.executeUpdate();
            }

            connection.commit();
            System.out.println("Giao dịch thành công: Đã đặt giá.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void logFailedBid(Connection connection, int auctionId, int userId, double bidAmount, String reason) throws SQLException {
        String insertFailedBidSQL = "INSERT INTO failed_bids (auction_id, user_id, bid_amount, reason) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(insertFailedBidSQL)) {
            stmt.setInt(1, auctionId);
            stmt.setInt(2, userId);
            stmt.setDouble(3, bidAmount);
            stmt.setString(4, reason);
            stmt.executeUpdate();
        }
    }
}