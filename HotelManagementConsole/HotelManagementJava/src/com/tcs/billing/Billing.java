package com.tcs.billing;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.tcs.reservation.Reserve;
import com.tcs.rooms.AvailableRooms;


public class Billing {
		
	
	public static void checkOutBillingUser(ArrayList<Reserve> reserveArray,ArrayList <AvailableRooms> RoomsArray,ArrayList<BillingDetails> BillingDetailsArray) throws SQLException{
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter your User ID ");
		int id =sc.nextInt();
		
		for(Reserve r:reserveArray) {
			if(id ==r.getUserId()) {
				int checkOutDay=Integer.parseInt(r.getCheckOutDate()); 
				int checkInDay=Integer.parseInt(r.getCheckInDate());
				int daysTakenFor=checkOutDay-checkInDay;
				for(AvailableRooms room: RoomsArray) {
					if(r.getRoomNo()==room.getRoomNo()) {
						int roomPrice=Integer.parseInt(room.getPrice());
						int finalPrice=roomPrice*daysTakenFor;
						System.out.println("Your Room Price is "+room.getPrice()+" per Day");
						System.out.println("You have taken Room for "+daysTakenFor+" days");
						System.out.println("Your Final price is "+finalPrice);
						System.out.println("Do you want to pay Now ? (Y/N)");
						String choice =sc.next();
						if(choice.equalsIgnoreCase("Y")) {
							//payment method 
							
							String paymentStatus=billPayment(BillingDetailsArray,r.getPaymentStatus(),finalPrice);
							if(paymentStatus.equals("Paid")) {
								
								boolean status=BillingDAO.billingDb(finalPrice,id);
								if(status) {
									System.out.println("!!!! Billing Data Added !!!!");
									
								}
								System.out.println("!!!! Payment Successfull !!!!");
								
								
							}
							else {
								System.out.println("!!!! Payment Unsuccessfull !!!!");
							}
							
						}
						else {
							System.out.println("You have not done the payment !!!!");
						}
						
					}
				}
				
				
			}
		}
		
		
		
		
	}	
	public static void checkoutBillingInvoiceAdmin(){
		
	}
	
	
	
	public static String billPayment(ArrayList<BillingDetails> BillingDetailsArray,String paymentStatus,int finalPrice) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the Payment option (Credit/Debit) ");
		String paymentOption=sc.nextLine() ;
		System.out.println("Enter the Card Number ");
		long cardNumber = sc.nextLong();sc.nextLine();
		System.out.println("Enter the Card Holder Name ");
		String cardHolderName=sc.nextLine();
		System.out.println("Enter the CVV Number ");
		int cvvNumber=sc.nextInt();sc.nextLine();
		System.out.println("Enter the Expiry Date ");
		String ExpiryDate=sc.nextLine();
		
		System.out.print("Do you want to pay "+finalPrice+" ? (Y/N)");
		String choice =sc.nextLine();
		if(choice.equalsIgnoreCase("Y")) {
			paymentStatus="Paid";
			BillingDetails billing=new  BillingDetails(paymentOption,cardNumber,cardHolderName,cvvNumber,ExpiryDate,paymentStatus,finalPrice);
			BillingDetailsArray.add(billing);
		}
	
		return paymentStatus;
	}
}
