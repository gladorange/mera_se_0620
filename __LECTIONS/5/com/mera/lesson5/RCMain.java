package com.mera.lesson5;

public class RCMain {


    public static void main(String[] args) {
        TV tv = new TV();
        Radio r = new Radio();


       /* RadioControllable rcItem = tv;
        RadioControllable rcItem2 = r;*/


        RadioControllable[] items = {tv, r};


        for (RadioControllable item : items) {
            item.turnOn();
        }

        for (RadioControllable item : items) {

            if (item instanceof TV) {
                ((TV) item).setCurrentChannel("1st channel");
            }

            item.turnOff();
        }


        for (RadioControllable item : items) {
            System.out.println(item.getClass().getSimpleName() + " " + item.isTurnedOn());
        }






    }
}
