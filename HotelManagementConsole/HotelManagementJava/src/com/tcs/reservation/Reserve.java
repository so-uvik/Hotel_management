package com.tcs.reservation;

import java.util.Random;

public class Reserve {
    private int userId;
    private int reservationId;
    private String checkInDate;
    private String checkOutDate;
    private String roomPreference;
    private String name;
    private long contact;
    private int roomNo;
    private String paymentStatus;

    // Constructor
    public Reserve(String name, String checkInDate, String checkOutDate, String roomPreference, long contact, int userId, int roomNo, String paymentStatus) {
        Random random = new Random();
        this.reservationId = 1000 + random.nextInt(9000); // Generate random reservation ID
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomPreference = roomPreference;
        this.name = name;
        this.contact = contact;
        this.userId = userId;
        this.roomNo = roomNo;
        this.paymentStatus = paymentStatus;
    }

    // Constructor for reading data from the database
    public Reserve(int reservationId, String name, String checkInDate, String checkOutDate, String roomPreference, long contact, int userId, int roomNo, String paymentStatus) {
        this.reservationId = reservationId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomPreference = roomPreference;
        this.name = name;
        this.contact = contact;
        this.userId = userId;
        this.roomNo = roomNo;
        this.paymentStatus = paymentStatus;
    }

    // Getters
    public int getReservationId() {
        return reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public String getRoomPreference() {
        return roomPreference;
    }

    public String getName() {
        return name;
    }

    public long getContact() {
        return contact;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    // Setters
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setRoomPreference(String roomPreference) {
        this.roomPreference = roomPreference;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Reservation Details: [Reservation ID: " + reservationId + ", User ID: " + userId + ", Name: " + name +
                ", Check-In: " + checkInDate + ", Check-Out: " + checkOutDate + ", Room Preference: " + roomPreference +
                ", Contact: " + contact + ", Room No: " + roomNo + ", Payment Status: " + paymentStatus + "]";
    }
}
