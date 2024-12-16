public class Room {
  private String roomType;
    private int dateOfAvailability;
    private int price;
    private String place;

    public Room(String roomType, int dateOfAvailability, int price, String place) {
        this.roomType = roomType;
        this.dateOfAvailability = dateOfAvailability;
        this.price = price;
        this.place = place;
    }
}
