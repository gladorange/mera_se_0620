package com.mera.task11.lections;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.ThreadLocalRandom;

public class LocalDateGenerator {

    private static int year = LocalDate.now().getYear();
    private static Month month = LocalDate.now().getMonth();

    public static LocalDate getLocalDate() {
        return LocalDate.of(year, month, ThreadLocalRandom.current().nextInt(1, LocalDate.now().lengthOfMonth()));
    }
}
