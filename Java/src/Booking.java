public class Booking {
    private int bookingId;
    private String roomType;
    private String bookingDetails;
    private double price;

    public Booking(int bookingId, String roomType, String bookingDetails, double price) {
        this.bookingId = bookingId;
        this.roomType = roomType;
        this.bookingDetails = bookingDetails;
        this.price = price;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setBookingDetails(String bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getBookingDetails() {
        return bookingDetails;
    }

    public double getPrice() {
        return price;
    }

}
