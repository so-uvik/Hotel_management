package com.tcs.support;
import java .util.*;
public class Complaint{

	public static void complaintUser(){
		Scanner sc =new Scanner(System.in);
		
		
		System.out.println("Enter User Name");
		String userName=sc.nextLine();
		System.out.println("Enter Contact Number");
		long contact=sc.nextLong();
		System.out.println("Enter Room Number");
		int roomNumber=sc.nextInt();
		System.out.println("Select the Type of Complaints");
		System.out.println("Select 1 For Poor housekeeping"); 
		System.out.println("Select 2 For Noisy guests");
		System.out.println("Select 3 For Uncomfortable beds");
		System.out.println("Select 4 For Slow service");
		System.out.println("Select 5 For Lack of amenities");
		System.out.println("Select 6 For Unfriendly staff");
		System.out.println("-----------------------------");
		int choice=sc.nextInt();sc.nextLine();
		
		String type="";
		switch(choice) {
		case 1: type="Poor housekeeping"; 
		case 2: type="Noisy guests";
		case 3: type="Uncomfortable beds";
		case 4: type="Slow service";
		case 5: type="Lack of amenities";
		case 6: type="Unfriendly staff";
		}
		System.out.println("Your Complaint Type is recorded");
		System.out.println("Enter your feedback ranging from 1 to 5 ");
		int feedback=sc.nextInt();
		ArrayList<Complain> ComplainArray=new ArrayList<>();
		Complain obj =new Complain(userName,contact,roomNumber,type,feedback);
		ComplainArray.add(obj);
		System.out.println("Succesfully registered Complaint  !!!");
	}
	
	
	
	
	
	
	public static void viewComplaintAdmin(ArrayList <Complain> complainArray){
		Scanner sc =new Scanner(System.in);
		
		int count=1;
		for(Complain c:complainArray) {
			
			System.out.println("Complaint No "+count);
			System.out.println("User Name is "+c.getUserName());
			System.out.println("Contact No is "+c.getContact());	
			System.out.println("Room Number is "+c.getRoomNumber());	
			System.out.println("Complaint Type is for "+c.getType());
			System.out.println("Feedback Given is "+c.getFeedback());
			count++;
		}
		
		System.out.println("------------------");
	}
	
}