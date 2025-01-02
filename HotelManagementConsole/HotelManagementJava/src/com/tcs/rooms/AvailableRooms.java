package com.tcs.rooms;

public class AvailableRooms {
		
	int roomNo;
	int roomType;
	String date ;
	String price;
	String place;
	String availabilityStatus;
	public AvailableRooms(int roomNo,int roomType, String date, String price, String place, String availabilityStatus) {
		
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.date = date; //check in date
		this.price = price;
		this.place = place;
		this.availabilityStatus = availabilityStatus;
	}
	
	
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getRoomType() {
		return roomType;
	}
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPrice() {
		return price;
	}
	public void setPriceRange(String price) {
		this.price = price;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	
	
	
	
}




