package com.tcs.booking;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.tcs.HotelManagement.User;
import com.tcs.reservation.Reservation;
import com.tcs.reservation.Reserve;
import com.tcs.rooms.AvailableRooms;

public class BookingServicesAdmin {
			
	public static void bookingAdmin(ArrayList<Reserve> reserveArray,ArrayList<User>users,ArrayList <AvailableRooms> RoomsArray) throws SQLException{
		
		Scanner sc=new Scanner(System.in);
		int choice =sc.nextInt();
		
		do {
			System.out.println("---Menu for Admin booking services---");
			System.out.println("Select 1 for New Booking ");
			System.out.println("Select 2 for Update Booking ");
			System.out.println("Select 3 for Delete Booking ");
			System.out.println("Select 0 to exit  ");
			
			
			switch(choice) {
			case 1:Reservation.newReservation(reserveArray, users, RoomsArray);
			case 2:Reservation.updateReservation(reserveArray);
			case 3:Reservation.deleteReservation(reserveArray);
			case 0:System.out.println("Returning to previous menu");break;
				default: System.out.println("Enter Valid Choice");
			}
		}while(choice!=0);
		
	}
}