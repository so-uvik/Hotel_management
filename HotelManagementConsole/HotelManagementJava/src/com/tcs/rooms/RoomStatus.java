package com.tcs.rooms;

import java.util.ArrayList;
import java.util.Scanner;

public class RoomStatus{
	
	public static void roomStatusUser(){
		
		System.out.println("The available Room Details are --->");
		
		
		//need to access from db 
//		for(AvailableRooms r:RoomsArray) {
//			System.out.println("The available Room Details are --->");
//			System.out.println("Room No is "+r.getRoomNo());
//			System.out.println("Room Type is "+r.getRoomType()+" BHK ");
//			System.out.println("Price per Day is "+r.getPrice());
//			System.out.println("Location is "+r.getPlace());
//			System.out.println("Available Check In Date is "+r.getDate());
//			System.out.println("Availability Status is"+r.getAvailabilityStatus());
//			System.out.println("---------------");
//		}
		System.out.println("---------------------------------------------------------");
	}	
	public static void roomStatusAdmin(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Room No to change Status :");
		int no=sc.nextInt();
		
		
		//need to access from db 
		
		
//		for(AvailableRooms room :RoomsArray)
//		{
//			if(room.getRoomNo()==no) {
//				room.setAvailabilityStatus("Vaccant");
//				room.setDate("20/12/2024");
//			}
//		}
		System.out.println("Changes Updated !!!");
	}
}

