package com.mera.lection3;

public class SmartTV extends TV {

    public SmartTV() {
        super(true);
        System.out.println("SmartTV");
    }

    public void turnOnFromPhone(boolean turnOn) {
        super.turnOn = turnOn;
    }

    public void turnOnFromPhone2(boolean turnOnState) {
        turnOn = turnOnState;
    }

    public static void main(String[] args) {
        SmartTV tv = new SmartTV();

        System.out.println(tv.isTurnOn());
    }

}
