package com.tcs.Auth;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.tcs.HotelManagement.User;

public class UserProfile {

    // Register User
    public static void registerUser() throws SQLException {
        Scanner sc = new Scanner(System.in);

        // Generate a unique user ID
        Random r = new Random();
        int id = 1000 + r.nextInt(9000);

        // Fullname
        String fullname = "";
        while (true) {
            System.out.println("Enter the Fullname of the user: ");
            fullname = sc.nextLine();
            if (fullname.length() > 0 && fullname.length() <= 30) break;
            System.out.println("Enter fullname within 30 characters!");
        }

        // Email
        String email = "";
        while (true) {
            System.out.println("Enter the Email ID of the user: ");
            email = sc.nextLine();
            if (email.length() > 0 && email.length() <= 100) break;
            System.out.println("Enter email within 100 characters!");
        }

        // Mobile Number
        String mobilenumber;
        while (true) {
            System.out.println("Enter the Mobile Number of the user: ");
            mobilenumber = sc.nextLine();
            if (mobilenumber.length() == 10) break;
            System.out.println("Enter a valid 10-digit mobile number!");
        }

        // Password
        String password;
        while (true) {
            System.out.println("Enter the Password of the user: ");
            password = sc.nextLine();
            if (password.length() >= 5 && password.length() <= 30) break;
            System.out.println("Enter password within 5-30 characters!");
        }

        // Create User object
        User user = new User(id, fullname, email, mobilenumber, password);
        ArrayList<User> users = new ArrayList<>();
        users.add(user);

        // Insert into database
        boolean status = UserRegistrationDAO.userRegistrationDB(users);

        if (status) {
            System.out.println("Your USER ID is " + user.getUserId());
            System.out.println("!!! User Registered and Data added Successfully !!!");
        } else {
            System.out.println("!!! User Data not added !!!");
        }
    }

    // Update User Email
    public static void updateUser() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the User ID of the user: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter your new Email: ");
        String email = sc.nextLine();

        boolean status = UserRegistrationDAO.updateUserEmail(id, email);
        if (status) {
            System.out.println("User Details have been Updated Successfully!");
        } else {
            System.out.println("Failed to update user details. User ID not found.");
        }
    }

    // Delete User
    public static void deleteUser() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the User ID for which the user is to be deleted: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean status = UserRegistrationDAO.deleteUser(id);
        if (status) {
            System.out.println("User Deleted Successfully!");
        } else {
            System.out.println("Failed to delete user. User ID not found.");
        }
    }

    // Select and Display Users
    public static void selectUser() throws SQLException {
        ArrayList<User> users = UserRegistrationDAO.selectAllUsers();

        System.out.println("Displaying the User Details:");
        for (User user : users) {
            System.out.println("User ID: " + user.getUserId());
            System.out.println("Fullname: " + user.getFullname());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Mobile Number: " + user.getMobileNumber());
            System.out.println("------------------------------------");
        }
    }
}
