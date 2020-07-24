import java.util.Objects;

public class Date {
    private int day;
    private Month month;
    private int year;

    public Date(int day, Month month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public Month getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return day + "." + month.getName() + "." + year;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Date)) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        Date date = (Date) obj;
        return day == date.day &&
                year == date.year &&
                month.equals(date.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }
}
