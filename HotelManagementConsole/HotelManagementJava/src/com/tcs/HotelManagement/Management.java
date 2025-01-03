package com.tcs.HotelManagement;

import com.tcs.Auth.Auth;
import com.tcs.Auth.UserProfile;
import com.tcs.billing.BillingDetails;
import com.tcs.booking.Booking;
import com.tcs.reservation.Reserve;
import com.tcs.rooms.AvailableRooms;
import com.tcs.support.Complain;

import java.sql.SQLException;
import java.util.*;
public class Management {
	

	public static void main(String[] args) throws SQLException {
		//Admin ID and Password Fixed manually 
		int adminID=1;
		String adminPassword="admin";
		
	Scanner sc=new Scanner(System.in);
		
		
		System.out.println(" !!! Welcome to Hotel Management System !!! ");
		
		
		//seperate gateway for user and admin authentication
		int role;
		do {
			System.out.println("---- Press 1 For Admin ----");
			System.out.println("---- Press 2 For User ----");
			System.out.println("---- Press 0 to Exit ----");
			role=sc.nextInt();
			
			//for admin
			if(role==1) {
				Auth.UserManagementAdmin();				
			}
			//for user
			else if(role==2) {
				int choiceUser;
				
				//user has choice to manage details or login 
				do {
					System.out.println("----- Menu -----");
					System.out.println("----- Press 1 for User Management-----");
					System.out.println("----- Press 2 for Log In-----");
					System.out.println("----- Press 0 to Return-----");
					System.out.println("Enter the Choice !!!!");
					
					choiceUser=sc.nextInt();
					
					switch(choiceUser){
					case 1: Auth.UserManagementUser();break;		
					case 2: Auth.loginMenu();break;
					case 0: System.out.println("!!! Returned to previous Menu !!!");break;			
					default:System.out.println("!!! Invalid input provided !!!");	
					}
				}while(choiceUser!=0);
				
			}
			else if(role==0) {System.out.println("!!! Exiting Program !!!");}
			else {System.out.println("!!! Invalid input provided !!!");	}
			
		}while(role!=0);
		

sc.close();
	}
	
}
