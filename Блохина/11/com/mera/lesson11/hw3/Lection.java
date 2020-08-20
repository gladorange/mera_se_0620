package com.mera.lesson11.hw3;

import java.time.LocalDate;

public class Lection {
    private String name;
    private LocalDate date;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Lection{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
