import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private List<Booking> bookingList = new ArrayList<Booking>();
    private int currentId = 1;

    public List<Booking> getAllBookings() {
        return bookingList;
    }
    public void addBooking(Booking booking) {
        booking.setBookingId(currentId++);
        bookingList.add(booking);
    }

    public void updateBooking(int bookingId, int roomType) {
        for (Booking booking : bookingList) {
            if (booking.getBookingId() == bookingId) {
                booking.setRoomType(roomType);
                System.out.println("Booking details are updated");
                return;
            }
        }
        System.out.println("Booking not found");
    }

    public void deleteBooking(int bookingId) {
        for (Booking booking : bookingList) {
            if (booking.getBookingId() == bookingId) {
                bookingList.remove(booking);
                System.out.println("Booking details are deleted");
                return;
            }
        }
        System.out.println("Booking not found");
    }

    public void viewBookingHistoryByID(String customerId) {
        for (Booking booking : bookingList) {
            if (booking.getCustomerId().equalsIgnoreCase(customerId)) {
                System.out.println(booking.getBookingId() + " " + booking.getCheckInDate() + " " + booking.getCheckOutDate() + " " + booking.getRoomNumber());
            }
        }
    }
}
