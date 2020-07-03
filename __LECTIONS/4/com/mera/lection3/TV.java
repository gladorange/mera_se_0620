package com.mera.lection3;

public class TV {
    public boolean turnOn;

    public TV() {
        System.out.println("TV");
    }

    public TV(boolean turnOn) {
        this.turnOn = turnOn;
    }

    public boolean isTurnOn() {
        return turnOn;
    }
}
