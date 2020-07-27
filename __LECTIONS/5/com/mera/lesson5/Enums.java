package com.mera.lesson5;

import java.util.Random;

public class Enums {

    enum Season {
        SUMMER(20),
        AUTUMN(0),
        WINTER(-10),
        SPRING(5);

        final int averageTemperature;


        Season(int averageTemperature) {
            this.averageTemperature = averageTemperature;
        }

        public int getAverageTemperature() {
            return averageTemperature;
        }
    }


    public static void main(String[] args) {


        Season s = getRandomSeason();


        System.out.println("Средняя температора " + s.name());
        System.out.println(getAverageTemp(s));

    }

    private static Season getRandomSeason() {
        final Season[] values = Season.values();
        return values[new Random().nextInt(values.length)];
    }

    static int getAverageTemp(Season season) {
      /*  switch (season) {
            case SUMMER:
                return 20;
            case AUTUMN:
                return  0;
            case WINTER:
                return -10;
            case SPRING:
                return 5;
            default:
                throw new IllegalArgumentException("Какой-то неправильный сезон");
        }*/

        return season.getAverageTemperature();
    }
}
