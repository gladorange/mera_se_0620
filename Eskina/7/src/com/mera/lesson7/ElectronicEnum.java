package com.mera.lesson7;

import java.util.concurrent.ThreadLocalRandom;

public enum ElectronicEnum {
    TV,
    FRIDGE;

    public static ElectronicEnum [] VALUES = values();
    public static int SIZE = VALUES.length;

    public static ElectronicEnum generateRandomElectronicType() {
        return VALUES[ThreadLocalRandom.current().nextInt(SIZE)];
    }

}
