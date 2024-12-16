import java.util.List;
import java.util.ArrayList;

public class ReservationDAO {
    private List<Reservation> reservationList = new ArrayList<Reservation>();
    private int currentId = 1;

    public List<Reservation> getAllReservations() {
        return reservationList;
    }

    public void addReservation(Reservation reservation) {
        reservation.setReservationId(currentId++);
        reservationList.add(reservation);
        System.out.println("Reservation Successful");
    }

    public void updateReservation(int reservationId, String name) {
        for (Reservation reservation : reservationList) {
            if (reservation.getReservationId() == reservationId) {
                reservation.setName(name);
                System.out.println("User details are updated sucessfully");
                return;
            }
        }
        System.out.println("Reservation not found");
    }

    public void deleteReservation(int reservationId) {
        for (Reservation reservation : reservationList) {
            if (reservation.getReservationId() == reservationId) {
                reservationList.remove(reservation);
                System.out.println("User details are deleted");
                return;
            }
        }
        System.out.println("Reservation not found");
    }
}
