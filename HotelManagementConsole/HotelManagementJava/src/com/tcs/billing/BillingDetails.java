package com.tcs.billing;

public class BillingDetails {
		
	
	String paymentOption ;	
	long cardNumber;	
	String cardHolderName;	
	int cvvNumber;	
	String expiryDate;
	String paymentStatus;
	int finalPrice;
	public BillingDetails(String paymentOption, long cardNumber, String cardHolderName, int cvvNumber,
			String expiryDate, String paymentStatus, int finalPrice) {
		
		this.paymentOption = paymentOption;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.cvvNumber = cvvNumber;
		this.expiryDate = expiryDate;
		this.paymentStatus = paymentStatus;
		this.finalPrice = finalPrice;
	}
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public int getCvvNumber() {
		return cvvNumber;
	}
	public void setCvvNumber(int cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public int getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
}

