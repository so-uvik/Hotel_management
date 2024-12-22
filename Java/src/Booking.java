public class Booking {
    private String Name;
    private String mobileNumber;
    private String email;
    private int roomType;
    private String checkInDate;
    private String checkOutDate;
    private int bookingId;
    private String customerId;
    private double price;
    private int roomNumber;
    private String location;

    public Booking(String Name, String mobileNumber, String customerId, int roomType, String checkInDate, String checkOutDate, String location, int roomNumber) {
        this.Name = Name;
        this.mobileNumber = mobileNumber;
        //this.email = email;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.customerId = customerId;
        this.location=location;
        this.roomNumber = roomNumber;
    }


    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }
    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCustomerId() {
        return customerId;
    }
    public int getBookingId() {
        return bookingId;
    }

    public int getRoomType() {
        return roomType;
    }
    public String getCheckInDate() {
        return checkInDate;
    }
    public String getCheckOutDate() {
        return checkOutDate;
    }
    public double getPrice() {
        return price;
    }
    public String getName() {
        return Name;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public String getEmail() {
        return email;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public String getLocation() {
        return this.location;
    }
}