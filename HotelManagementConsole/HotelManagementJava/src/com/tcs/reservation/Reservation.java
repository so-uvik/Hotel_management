package com.tcs.reservation;

import com.tcs.Auth.UserLoginDAO;
import com.tcs.HotelManagement.User;
import com.tcs.rooms.AvailableRooms;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reservation {
    // Method for new reservation
    public static void newReservation(ArrayList<Reserve> reserveArray, ArrayList<User> users, ArrayList<AvailableRooms> roomsArray) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the User ID:");
        int userId = sc.nextInt();
        sc.nextLine();
  
//        boolean userExists = users.stream().anyMatch(user -> user.getUserId() == userId);
//        if (!userExists) {
//            System.out.println("No User found! Please register first.");
//            return;
//        }
       String password="";
       ArrayList<User> u= UserLoginDAO.selectAllUsers();
       
        for(User i:u) {
        	if(i.getUserId()==userId) {
        		password=i.getPassword();
        		break;
        	}
        }
        if (!UserLoginDAO.isUserExistAndValid(userId,password)) {
            System.out.println("No user found with the given User ID. Please register first.");
            return; // Exit if user does not exist
        }

        System.out.println("All available room status:");
        roomsArray.forEach(System.out::println);

        System.out.println("Enter Room Type (1 BHK, 2 BHK, or 3 BHK):");
        int roomType = sc.nextInt();
        sc.nextLine();

        AvailableRooms room = roomsArray.stream()
                .filter(r -> r.getRoomType() == roomType && r.getAvailabilityStatus().equalsIgnoreCase("Vacant"))
                .findFirst()
                .orElse(null);

        if (room == null) {
            System.out.println("Sorry, " + roomType + " BHK room is not available now!");
            return;
        }

        System.out.println("Room selected at: " + room.getPlace());
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Enter Check-In Date (YYYY-MM-DD):");
        String checkInDate = sc.nextLine();
        System.out.println("Enter Check-Out Date (YYYY-MM-DD):");
        String checkOutDate = sc.nextLine();
        System.out.println("Enter Room Status (Single/Double):");
        String roomStatus = sc.nextLine();
        System.out.println("Enter Contact Number:");
        long contact = sc.nextLong();
        sc.nextLine();

        Reserve reservation = new Reserve(name, checkInDate, checkOutDate, roomStatus, contact, userId, room.getRoomNo(), "Unpaid");
        boolean isAdded = ReservationDAO.addReservation(reservation);

        if (isAdded) {
            room.setAvailabilityStatus("Occupied");
            System.out.println("!!! New Reservation Added Successfully !!!");
            System.out.println("Reservation ID: " + reservation.getReservationId());
        } else {
            System.out.println("!!! Failed to Add Reservation !!!");
        }
    }

    // Method to update reservation
    public static void updateReservation(ArrayList<Reserve> reserveArray) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Reservation ID:");
        int reservationId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the User ID:");
        int userId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the new name:");
        String name = sc.nextLine();

        boolean isUpdated = ReservationDAO.updateReservation(reservationId, userId, name);

        if (isUpdated) {
            System.out.println("Reservation details updated successfully.");
        } else {
            System.out.println("Failed to update reservation details.");
        }
    }

    // Method to delete reservation
    public static void deleteReservation(ArrayList<Reserve> reserveArray) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Reservation ID:");
        int reservationId = sc.nextInt();
        System.out.println("Enter the User ID:");
        int userId = sc.nextInt();

        boolean isDeleted = ReservationDAO.deleteReservation(reservationId, userId);

        if (isDeleted) {
            System.out.println("Reservation deleted successfully.");
        } else {
            System.out.println("Failed to delete reservation.");
        }
    }

    // Display reservations
    public static void displayReservations(ArrayList<Reserve> reserveArray) {
        System.out.println("Displaying all reservations:");
        reserveArray.forEach(System.out::println);
    }

    // Menu for reservation operations
    public static void reservationUser(ArrayList<Reserve> reserveArray, ArrayList<User> users, ArrayList<AvailableRooms> roomsArray) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("----Menu for Reservation----");
            System.out.println("1. New Reservation");
            System.out.println("2. Update Reservation");
            System.out.println("3. Delete Reservation");
            System.out.println("4. Display Reservations");
            System.out.println("5. Return");

            System.out.println("Select an option:");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    newReservation(reserveArray, users, roomsArray);
                    break;
                case 2:
                    updateReservation(reserveArray);
                    break;
                case 3:
                    deleteReservation(reserveArray);
                    break;
                case 4:
                    displayReservations(reserveArray);
                    break;
                case 5:
                    System.out.println("Returning to previous menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }
}
