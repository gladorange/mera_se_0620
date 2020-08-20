package com.mera.task11.lections;

import java.time.LocalDate;
import java.util.Objects;

public class Lection {

    public static final String MATH = "math";
    public static final String PHILOSOPHY = "philosophy";
    public static final String ENGLISH = "english";
    public static final String HISTORY = "history";
    public static final String SPORT = "physical training";

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lection lection = (Lection) o;
        return Objects.equals(name, lection.name) &&
                Objects.equals(date, lection.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date);
    }

}
