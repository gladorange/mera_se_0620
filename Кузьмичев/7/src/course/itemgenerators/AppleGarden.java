package course.itemgenerators;

import course.shopitems.AppleColors;
import course.shopitems.Apple;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class AppleGarden {
    public static Integer MIN_ITEMS = 3;
    public static Integer MAX_ITEMS = 10;

    public static Integer MIN_PRICE = 2;
    public static Integer MAX_PRICE = 8;

    public static Integer MIN_CALORIC_VALUE = 20;
    public static Integer MAX_CALORIC_VALUE = 30;

    public static Integer DEFAULT_EXPIRATION_DATE = 10;

    public static void fillShopWithApples(Collection<? super Apple> shop) {
        HashSet<AppleColors> colors = new HashSet<>();

        for(Integer i = 0; i < ThreadLocalRandom.current().nextInt(MIN_ITEMS, MAX_ITEMS); i++) {
            String appleName = "Apple";
            Integer applePrice = ThreadLocalRandom.current().nextInt(MIN_PRICE, MAX_PRICE);
            Integer appleCaloricValue = ThreadLocalRandom.current().nextInt(MIN_CALORIC_VALUE, MAX_CALORIC_VALUE);
            Integer appleExpirationDate = DEFAULT_EXPIRATION_DATE;
            AppleColors appleColor = AppleColors.values()[ThreadLocalRandom.current().nextInt(AppleColors.values().length)];
            colors.add(appleColor);

            Apple item = new Apple(appleName, applePrice, appleCaloricValue, appleExpirationDate, appleColor);
            shop.add(item);
        }

        System.out.println("Apples of the following colors has been added to the store: " + colors.toString());
    }
}