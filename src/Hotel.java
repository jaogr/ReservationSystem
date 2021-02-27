import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private final Map<String, Room> rooms;

    public Hotel(int numberOfRegular, int numberOfPenthouses) {
        this.rooms = buildRooms(numberOfRegular, numberOfPenthouses);
    }

    public boolean makeReservation(String id, Date entryDate, Date leaveDate) {
        if (rooms.containsKey(id)) {
                return rooms.get(id).makeReservation(entryDate, leaveDate);
        }

        return false;
    }

    public boolean cancelReservation(String id) {
        if (rooms.containsKey(id))
            return rooms.get(id).cancelReservation();
        return false;
    }

    public boolean isAvailable(String id, Date date) {
        if (rooms.containsKey(id))
            return rooms.get(id).isAvailable(date);
        return false;
    }

    public String listAvailableRooms(Date date) {
        String output = String.format("\nAvailable rooms on %s\n", date);
        for (Room room : rooms.values()) {
            if (room.isAvailable(date))
                output += room.getId() + "\n";
        }

        return output;
    }

    private Map<String, Room> buildRooms(int numberOfRegular, int numberOfPenthouses) {
        Map<String, Room> rooms = new HashMap<>();
        String id;

        for (int i = 1; i < numberOfRegular + 1; i++){
            id = "R" + i;
            rooms.put(id, new Room(id, false));
        }

        for (int i = 1; i < numberOfPenthouses + 1; i++) {
            id = "P" + i;
            rooms.put(id, new Room(id, true));
        }

        return rooms;
    }
}
