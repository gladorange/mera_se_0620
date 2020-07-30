package course.itemgenerators;

import course.shopitems.Apple;
import course.shopitems.AppleColors;
import course.shopitems.Bread;
import course.shopitems.FoodItem;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

public class FoodFactory {
    public static Integer MIN_ITEMS = 3;
    public static Integer MAX_ITEMS = 10;

    public static Integer MIN_PRICE = 24;
    public static Integer MAX_PRICE = 42;

    public static Integer MIN_CALORIC_VALUE = 80;
    public static Integer MAX_CALORIC_VALUE = 140;

    public static Integer MIN_WEIGHT = 400;
    public static Integer MAX_WEIGHT = 750;

    public static Integer DEFAULT_EXPIRATION_DATE = 3;

    public static void fillShopWithFood(Collection<? super FoodItem> shop) {
        AppleGarden.fillShopWithApples(shop);

        Integer totalWeight = 0;

        for(Integer i = 0; i < ThreadLocalRandom.current().nextInt(MIN_ITEMS, MAX_ITEMS); i++) {
            String breadName = "Bread";
            Integer breadPrice = ThreadLocalRandom.current().nextInt(MIN_PRICE, MAX_PRICE);
            Integer breadCaloricValue = ThreadLocalRandom.current().nextInt(MIN_CALORIC_VALUE, MAX_CALORIC_VALUE);
            Integer breadExpirationDate = DEFAULT_EXPIRATION_DATE;
            Integer breadWeight = ThreadLocalRandom.current().nextInt(MIN_WEIGHT, MAX_WEIGHT);
            totalWeight += breadWeight;

            Bread item = new Bread(breadName,breadPrice,breadCaloricValue, breadExpirationDate, breadWeight);
            shop.add(item);
        }

        System.out.println("Apples of the following total weight has been added to the store: " + totalWeight);
    }
}
