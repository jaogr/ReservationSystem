public class Date implements Comparable<Date> {
    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean isBetween(Date date1, Date date2) {
        return this.compareTo(date1) >= 0 && this.compareTo(date2) <= 0;
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", day, month, year);
    }

    @Override
    public int compareTo(Date otherDate) {

        if (this.year != otherDate.getYear()) {
            return this.year > otherDate.getYear() ? 1 : -1;

        } else if (this.month != otherDate.getMonth()) {
            return this.month > otherDate.getMonth() ? 1 : -1;

        } else if (this.day != otherDate.getDay()) {
            return this.day > otherDate.getDay() ? 1 : -1;
        }

        return 0;
    }
}
