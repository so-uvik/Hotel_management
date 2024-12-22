import java.util.List;
import java.util.ArrayList;

public class RoomDAO {
    List<Room> roomList = new ArrayList<>();

    public void addRoom(Room r) {
        roomList.add(r);
    }

    public List<Room> getAllRooms() {
        return roomList;
    }
}
