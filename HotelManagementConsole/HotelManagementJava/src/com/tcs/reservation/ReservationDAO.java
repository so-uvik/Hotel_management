package com.tcs.reservation;

import com.tcs.DbConnection.DbConnection;
import com.tcs.rooms.AvailableRooms;

import java.sql.*;
import java.util.ArrayList;

public class ReservationDAO {

    private static final String INSERT_RESERVATION_QUERY = "INSERT INTO Reservations (name, check_in_date, check_out_date, room_status, contact_no, user_id, room_no, payment_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_RESERVATION_QUERY = "UPDATE reservations SET name = ? WHERE reservation_id = ? AND user_id = ?";
    private static final String DELETE_RESERVATION_QUERY = "DELETE FROM reservations WHERE reservation_id = ? AND user_id = ?";
    private static final String SELECT_RESERVATIONS_QUERY = "SELECT * FROM reservations";

    // Method to add a new reservation
    public static boolean addReservation(Reserve reserve) throws SQLException {
        try (Connection con = DbConnection.DbConnector();
             PreparedStatement pstmt = con.prepareStatement(INSERT_RESERVATION_QUERY)) {
            pstmt.setString(1, reserve.getName());
            pstmt.setString(2, reserve.getCheckInDate());
            pstmt.setString(3, reserve.getCheckOutDate());
            pstmt.setString(4, reserve.getRoomPreference());
            pstmt.setLong(5, reserve.getContact());
            pstmt.setInt(6, reserve.getUserId());
            pstmt.setInt(7, reserve.getRoomNo());
            pstmt.setString(8, reserve.getPaymentStatus());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Method to update an existing reservation
    public static boolean updateReservation(int reservationId, int userId, String name) throws SQLException {
        try (Connection con = DbConnection.DbConnector();
             PreparedStatement pstmt = con.prepareStatement(UPDATE_RESERVATION_QUERY)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, reservationId);
            pstmt.setInt(3, userId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Method to delete a reservation
    public static boolean deleteReservation(int reservationId, int userId) throws SQLException {
        try (Connection con = DbConnection.DbConnector();
             PreparedStatement pstmt = con.prepareStatement(DELETE_RESERVATION_QUERY)) {
            pstmt.setInt(1, reservationId);
            pstmt.setInt(2, userId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Method to fetch all reservations
    public static ArrayList<Reserve> fetchAllReservations() throws SQLException {
        ArrayList<Reserve> reservations = new ArrayList<>();

        try (Connection con = DbConnection.DbConnector();
             PreparedStatement pstmt = con.prepareStatement(SELECT_RESERVATIONS_QUERY);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Reserve reserve = new Reserve(
                        rs.getString("name"),
                        rs.getString("check_in_date"),
                        rs.getString("check_out_date"),
                        rs.getString("room_status"),
                        rs.getLong("contact_no"),
                        rs.getInt("user_id"),
                        rs.getInt("room_no"),
                        rs.getString("payment_status")
                );
                reserve.setReservationId(rs.getInt("reservation_id"));
                reservations.add(reserve);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return reservations;
    }
}
