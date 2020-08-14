package hw11;

import java.time.LocalDate;
import java.util.Objects;

public class Lection {
    private final String name;
    private final LocalDate date;

    public Lection(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Лекция '" + name + "', проведена: " + date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lection)) return false;
        Lection lection = (Lection) o;
        return Objects.equals(name, lection.name) &&
                Objects.equals(date, lection.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date);
    }
}
