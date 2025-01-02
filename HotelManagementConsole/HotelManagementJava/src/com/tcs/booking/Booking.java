package com.tcs.booking;
import com.tcs.HotelManagement.User;
import com.tcs.reservation.Reserve;
import java.util.*;

import com.tcs.reservation.Reserve;

public class Booking {
	
	public static void bookingHistoryUser(ArrayList<Reserve> reserveArray,ArrayList<User> users){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the User ID");
		int userId=sc.nextInt();
		

		for(User u :users) {
			if(u.getUserId()==userId);
			{int count=0;
				for(Reserve r:reserveArray) {
					if( r.getUserId()==userId) {
						System.out.println("Reservation No "+count++);
						System.out.println(" Reservation Details for User ID"+u.getUserId());
						System.out.println("The Reservation ID is "+r.getReservationId());
						System.out.println("The Name is "+r.getName());
						System.out.println("The Check In Date is "+r.getCheckInDate());
						System.out.println("The Check Out Date ID is "+r.getCheckOutDate());
						System.out.println("The Room Status is "+r.getRoomPreference());
						System.out.println("The Contact is "+r.getContact());
						System.out.println("---------------");
						
					}
				}
				break;
			}
			
		}
		
		
		
		
		System.out.println();
	}	
	public static void bookingHistoryAdmin(){}
	public static void bookingHistoryByIDAdmin(){}
	public static void bookingHotelServicesAdmin(){}
	
	
}
