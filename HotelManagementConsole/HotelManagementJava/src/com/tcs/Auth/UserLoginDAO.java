package com.tcs.Auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.tcs.HotelManagement.User;
import com.tcs.DbConnection.DbConnection;

public class UserLoginDAO {

    // SQL Queries
    private static final String SELECT_USER_BY_ID = "SELECT * FROM UserProfile WHERE userID = ? AND Password = ?";
    private static final String SELECT_ADMIN_BY_ID = "SELECT * FROM Admin WHERE adminID = ? AND adminPassword = ?";

    // Check User Login
    public static boolean userLogin(int userId, String password) throws SQLException {
        try (Connection con = DbConnection.DbConnector();
             PreparedStatement pstmt = con.prepareStatement(SELECT_USER_BY_ID)) {

            pstmt.setInt(1, userId);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            return rs.next(); // Returns true if user exists and password matches
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Check Admin Login
    public static boolean adminLogin(int adminId, String adminPassword) throws SQLException {
        try (Connection con = DbConnection.DbConnector();
             PreparedStatement pstmt = con.prepareStatement(SELECT_ADMIN_BY_ID)) {

            pstmt.setInt(1, adminId);
            pstmt.setString(2, adminPassword);
            ResultSet rs = pstmt.executeQuery();

            return rs.next(); // Returns true if admin exists and password matches
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Select and Retrieve All Users (For user management purposes)
    public static ArrayList<User> selectAllUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM UserProfile";
        try (Connection con = DbConnection.DbConnector();
             PreparedStatement pstmt = con.prepareStatement(query);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // User Login Logic Example: 
    public static boolean isUserExistAndValid(int userId, String password) throws SQLException {
        // Query the database to check if the user exists
        boolean userExists = userLogin(userId, password);

        if (userExists) {
            System.out.println("User authenticated successfully!");
            return true;
        } else {
            System.out.println("Invalid User ID or Password. Please try again or register.");
            return false;
        }
    }

    // Example Method to handle user login verification
    public static void handleUserLogin() throws SQLException {
        // Let's assume you receive user credentials for login
        int userId = 123;  // Replace this with actual input from user
        String password = "password123";  // Replace this with actual input from user
        
        if (isUserExistAndValid(userId, password)) {
            System.out.println("User login successful!");
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }
    }
}
