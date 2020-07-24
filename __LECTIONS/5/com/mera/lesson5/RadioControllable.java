package com.mera.lesson5;

public interface RadioControllable {
    boolean IS_TURNED_ON_BY_DEFAULT = false;

    void turnOn();
    void turnOff();

    boolean isTurnedOn();

}



class Radio implements RadioControllable {

    boolean isTurnedOn = false;

    @Override
    public void turnOn() {
        isTurnedOn = true;
        System.out.println("Радио включилось");
    }

    @Override
    public void turnOff() {
        if (!isTurnedOn) {
            return;
        }


        System.out.println("Радио нельзя выключить!");

    }

    @Override
    public boolean isTurnedOn() {
        return isTurnedOn;
    }
}


class TV implements RadioControllable {
    boolean isTurnedOn = RadioControllable.IS_TURNED_ON_BY_DEFAULT;

    String currentChannel;

    @Override
    public void turnOn() {
        if (isTurnedOn) {
            System.out.println("Уже включен");
            return;
        }

        System.out.println("Включается телевизор");
        isTurnedOn = true;


    }

    @Override
    public void turnOff() {
        if (!isTurnedOn) {
            System.out.println("Уже выключен");
            return;
        }

        System.out.println("Выключается телевизор");
        isTurnedOn = false;
    }

    @Override
    public boolean isTurnedOn() {
        return isTurnedOn;
    }


    public String getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(String currentChannel) {
        this.currentChannel = currentChannel;
    }
}



