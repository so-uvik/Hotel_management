package com.tcs.support;

import java.util.ArrayList;
import java.util.Scanner;

public class Contact{
	public static long supportNumber=1234567891;
	public static String email="hotel@gmail.com";
	public static String address="Ecospace 1B,Newtown,Kolkata";
	public static void contactSupport(){
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Contact Us in any case of issue !!!");
		System.out.println("Mobile No is : "+supportNumber);
		System.out.println("Email id : "+email);
		System.out.println("Address : "+address);
		System.out.println("Do you want to raise any Complaint ?? If yes Select 1");
		int choice=sc.nextInt();
		
		if(choice ==1) {
			Complaint.complaintUser();
		}
		else {
			System.out.println("Enter valid Option !!!");
		}
	}

	
}