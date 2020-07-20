package com.mera.lesson6;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Date {
    private final int day;
    private  final EnumMonths month;
    private final int year;

    Date(int day, EnumMonths month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public EnumMonths getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day &&
                year == date.year &&
                month == date.month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    public static Date generateRandomDate() {
        EnumMonths month = EnumMonths.generateRandomMonth();
        int day = ThreadLocalRandom.current().nextInt(month.getDays()) + 1;
        int year = 2020;
        return new Date(day, month, year);
    }
}
