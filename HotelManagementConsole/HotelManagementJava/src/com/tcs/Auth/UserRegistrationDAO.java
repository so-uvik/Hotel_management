package com.tcs.Auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.DbConnection.DbConnection;
import com.tcs.HotelManagement.User;

public class UserRegistrationDAO {

    // SQL Queries
    private static final String INSERT_USER = "INSERT INTO UserProfile (userID, FullName, Email, MobileNumber, Password) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_EMAIL = "UPDATE UserProfile SET email = ? WHERE userID = ?";
    private static final String DELETE_USER = "DELETE FROM UserProfile WHERE userID = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM UserProfile";

    // Insert Users in Batch
    public static boolean userRegistrationDB(ArrayList<User> users) throws SQLException {
        try (Connection con = DbConnection.DbConnector();
             PreparedStatement pstmt = con.prepareStatement(INSERT_USER)) {

            for (User user : users) {
                pstmt.setInt(1, user.getUserId());
                pstmt.setString(2, user.getFullname());
                pstmt.setString(3, user.getEmail());
                pstmt.setString(4, user.getMobileNumber());
                pstmt.setString(5, user.getPassword());
                pstmt.addBatch();
            }

            int[] rowsAffected = pstmt.executeBatch();
            return rowsAffected.length == users.size(); // Returns true if all users are added successfully
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update User Email by User ID
    public static boolean updateUserEmail(int userId, String newEmail) throws SQLException {
        try (Connection con = DbConnection.DbConnector();
             PreparedStatement pstmt = con.prepareStatement(UPDATE_USER_EMAIL)) {
            
            pstmt.setString(1, newEmail);
            pstmt.setInt(2, userId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete User by User ID
    public static boolean deleteUser(int userId) throws SQLException {
        try (Connection con = DbConnection.DbConnector();
             PreparedStatement pstmt = con.prepareStatement(DELETE_USER)) {
            
            pstmt.setInt(1, userId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Select and Retrieve All Users
    public static ArrayList<User> selectAllUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        try (Connection con = DbConnection.DbConnector();
             PreparedStatement pstmt = con.prepareStatement(SELECT_ALL_USERS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int userId = rs.getInt("userID");
                String fullname = rs.getString("FullName");
                String email = rs.getString("Email");
                String mobileNumber = rs.getString("MobileNumber");
                String password = rs.getString("Password");

                User user = new User(userId, fullname, email, mobileNumber, password);
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
