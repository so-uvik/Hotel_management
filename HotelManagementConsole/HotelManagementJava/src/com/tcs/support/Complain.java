package com.tcs.support;

public class Complain {
	String userName;
	long contact;
	int roomNumber;
	String typeOfComplaint;
	int feedback;

	Complain(String userName, long contact, int roomNumber, String type, int feed) {
		this.userName = userName;
		this.contact = contact;
		this.roomNumber = roomNumber;
		this.typeOfComplaint = type;
		this.feedback = feed;
	}

//getters

	public int getRoomNumber() {
		return roomNumber;
	}

	public String getUserName() {
		return userName;
	}

	public long getContact() {
		return contact;
	}

	public String getType() {
		return typeOfComplaint;
	}

	public int getFeedback() {
		return feedback;
	}

//setters

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setType(String type) {
		this.typeOfComplaint = type;
	}

	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}

}