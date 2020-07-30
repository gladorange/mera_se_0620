package com.mera.lesson8;

public class Film {
    public static final String EMPTY_STRING = "";

    String name;
    int year;
    boolean isWatched;

    public Film() {
        name = EMPTY_STRING;
    }

    public Film(String name, int year, boolean isWatched) {
        this.name = name;
        this.year = year;
        this.isWatched = isWatched;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setWatched(boolean watched) {
        isWatched = watched;
    }
}
