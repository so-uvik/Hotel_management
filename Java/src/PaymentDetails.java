public class PaymentDetails {
    private String cardHolderName;
    private int cardNumber;
    private int cvv;
    private String expiryDate;

    public PaymentDetails(String cardHolderName, int cardNumber, int cvv, String expiryDate) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
}
