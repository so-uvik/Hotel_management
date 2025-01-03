package com.tcs.HotelManagement;

public class User{
	private int userId;
	private String fullname;
	private String email;
	private String mobileNumber;
	private String password;
	
	
	public User(int userId,String fullname,String email,String mobileNumber,String password){
		this.userId=userId;
		this.fullname=fullname;
		this.email=email;
		this.mobileNumber=mobileNumber;
		this.password=password;
		
	}
	
	
	//setters 
	
	public void setUserId(int userId) { this.userId=userId;}
	public void setFullname(String fullname) {this.fullname=fullname;}
	public void setEmail(String email) {this.email=email;}
	public void setMobileNumber(String mobileNumber) {this.mobileNumber=mobileNumber;}
	
	
	//getters
	
	public int getUserId() {return userId;}
	public String getFullname() {return fullname;}
	public String getEmail() {return email;}
	public String getMobileNumber() {return mobileNumber;}
	public String getPassword() {return password;} // security concern for user data 
	
}