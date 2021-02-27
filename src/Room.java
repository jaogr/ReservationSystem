public class Room {
    private final String id;
    private final double price;
    private final boolean isPenthouse;
    private Date entryDate;
    private Date leaveDate;

    public Room(String id, boolean isPenthouse) {
        this.id = id;
        this.isPenthouse = isPenthouse;
        price = isPenthouse ? 200 : 90;
        entryDate = null;
        leaveDate = null;
    }

    public boolean makeReservation(Date entryDate, Date leaveDate) {
        if (entryDate.compareTo(leaveDate) <= 0 && this.isAvailable(entryDate) && this.isAvailable(leaveDate)) {

            this.entryDate = entryDate;
            this.leaveDate = leaveDate;

            return true;
        }

        return false;
    }

    public boolean cancelReservation() {
        if (entryDate != null && leaveDate != null) {
            this.entryDate = null;
            this.leaveDate = null;

            return true;
        }

        return false;
    }

    public boolean isAvailable(Date date) {
        if (entryDate != null && leaveDate != null) {
            return !date.isBetween(entryDate, leaveDate);
        }

        return false;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPenthouse() {
        return isPenthouse;
    }
}

