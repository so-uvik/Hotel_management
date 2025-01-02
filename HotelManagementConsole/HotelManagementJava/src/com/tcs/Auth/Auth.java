package com.tcs.Auth;

import com.tcs.booking.Booking;
import com.tcs.reservation.Reservation;
import com.tcs.reservation.Reserve;
import com.tcs.rooms.AvailableRooms;
import com.tcs.rooms.RoomStatus;
import com.tcs.support.Complaint;
import com.tcs.support.Complain;
import com.tcs.support.Contact;
import com.tcs.HotelManagement.User;
import com.tcs.billing.Billing;
import com.tcs.billing.BillingDetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Auth {

    // Admin credentials
    private static final int adminID = 1;  // Example admin ID
    private static final String adminPassword = "admin123";  // Example admin password

    public static void UserManagementAdmin() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----- Menu -----");
            System.out.println("----- Press 1 to Register User Details-----");
            System.out.println("----- Press 2 to Update User Details-----");
            System.out.println("----- Press 3 to Delete user Details -----");
            System.out.println("----- Press 4 to Select User Details -----");
            System.out.println("----- Press 5 to exit -----");

            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline
            switch (choice) {
                case 1:
                    UserProfile.registerUser();
                    break;
                case 2:
                    UserProfile.updateUser();
                    break;
                case 3:
                    UserProfile.deleteUser();
                    break;
                case 4:
                    UserProfile.selectUser();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu !!!");
                    break;
                default:
                    System.out.println("!!! Invalid input provided !!!");
            }
        } while (choice != 5);
    }

    // User profile for user
    public static void UserManagementUser() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int a;
        do {
            System.out.println("!!!! Menu for User Management !!!!");
            System.out.println("----- Press 1 to Register Details -----");
            System.out.println("----- Press 2 to Update Details -----");
            System.out.println("----- Press 3 for Delete Details -----");
            System.out.println("----- Press 4 to Return -----");

            a = sc.nextInt();

            switch (a) {
                case 1:
                    UserProfile.registerUser();
                    break;
                case 2:
                    UserProfile.updateUser();
                    break;
                case 3:
                    UserProfile.deleteUser();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu !!!");
                    break;
                default:
                    System.out.println("!!! Invalid input provided !!!");
            }
        } while (a != 4);
    }

    // Login Menu for User or Admin
    public static void loginMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your User ID");
        int ID = sc.nextInt();
        sc.nextLine();  // Consume newline
        System.out.println("Enter your Password");
        String password = sc.nextLine();

      
        // User login check

        if (UserLoginDAO.userLogin(ID, password)) {
            System.out.println("User Accessed");
            loginUserMenu();
        } else {
            if (UserLoginDAO.adminLogin(adminID, adminPassword)) {
                System.out.println("Admin Accessed");
                loginAdminMenu();
                // Admin login check
           
            
            } else {
                System.out.println("Invalid user credentials. Please try again.");
            }
        }
    }

    // User menu after login
    public static void loginUserMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----- Menu -----");
            System.out.println("----- Press 1 for Reservation-----");
            System.out.println("----- Press 2 for Booking History-----");
            System.out.println("----- Press 3 for Room Status-----");
            System.out.println("----- Press 4 for Check-out Billing -----");
            System.out.println("----- Press 5 for Complaint -----");
            System.out.println("----- Press 6 for Contact  -----");
            System.out.println("----- Press 7 for return  -----");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Reservation.reservationUser();
                    break;
                case 2:
                    Booking.bookingHistoryUser();
                    break;
                case 3:
                    RoomStatus.roomStatusUser();
                    break;
                case 4:
                    Billing.checkOutBillingUser( );
                    break;
                case 5:
                    Complaint.complaintUser();
                    break;
                case 6:
                    Contact.contactSupport();
                    break;
                case 7:
                    System.out.println("Returning to Main Menu !!!");
                    break;
                default:
                    System.out.println("!!! Invalid input provided !!!");
            }
        } while (choice != 7);
    }

    // Admin menu after login
    public static void loginAdminMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----- Menu -----");
            System.out.println("----- Press 1 for Booking Hotel Services -----");
            System.out.println("----- Press 2 for Booking History-----");
            System.out.println("----- Press 3 for Booking History By ID -----");
            System.out.println("----- Press 4 for Room Status-----");
            System.out.println("----- Press 5 for Check out Billing Invoice -----");
            System.out.println("----- Press 6 for View Complaint  -----");
            System.out.println("----- Press 7 for return  -----");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Booking.bookingHotelServicesAdmin();
                    break;
                case 2:
                    Booking.bookingHistoryAdmin();
                    break;
                case 3:
                    Booking.bookingHistoryByIDAdmin();
                    break;
                case 4:
                    RoomStatus.roomStatusAdmin();
                    break;
                case 5:
                    Billing.checkoutBillingInvoiceAdmin();
                    break;
                case 6:
                    Complaint.viewComplaintAdmin();
                    break;
                case 7:
                    System.out.println("Returning to Main Menu !!!");
                    break;
                default:
                    System.out.println("!!! Invalid input provided !!!");
            }
        } while (choice != 7);
    }
}

