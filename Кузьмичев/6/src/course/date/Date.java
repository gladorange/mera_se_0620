package course.date;

import java.util.Objects;

public class Date {
    private final Integer day;
    private final Month month;
    private final Integer year;

    private final static Integer DEFAULT_MIN_DAY = 1;
    private final static Integer DEFAULT_DAY = 1;
    private final static Month DEFAULT_MONTH = Month.JANUARY;
    private final static Integer DEFAULT_YEAR = 1970;

    public Date() {
        this(DEFAULT_DAY, DEFAULT_MONTH, DEFAULT_YEAR);
    }

    public Date(Integer day, Month month, Integer year) {
        this.year = year;
        this.month = month;

        if (day < Date.DEFAULT_MIN_DAY) {
            this.day = Date.DEFAULT_MIN_DAY;
            return;
        }

        if (day > this.month.getMaxDay()) {
            this.day = this.month.getMaxDay();
            return;
        }

        this.day = day;
    }

    public Integer getDay() {
        return day;
    }

    public Month getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return Objects.equals(day, date.day) &&
                month == date.month &&
                Objects.equals(year, date.year);
    }

    @Override
    public int hashCode() {

        return Objects.hash(day, month, year);
    }
}