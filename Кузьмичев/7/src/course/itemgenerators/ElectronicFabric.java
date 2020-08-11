package course.itemgenerators;

import course.shopitems.ElectronicItem;
import course.shopitems.TV;
import course.shopitems.Refrigerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ElectronicFabric {
    public static Integer MIN_ITEMS = 3;
    public static Integer MAX_ITEMS = 10;

    public static Integer MIN_PRICE = 2;
    public static Integer MAX_PRICE = 8;

    public static Integer MIN_POWER = 800;
    public static Integer MAX_POWER = 1200;

    public static Integer MIN_TV_VOLUME = 40;
    public static Integer MAX_TV_VOLUME = 65;

    public static Integer MIN_REFRIGERATOR_VOLUME = 10;
    public static Integer MAX_REFRIGERATOR_VOLUME = 35;

    public static void fillShopWithElectronicGoods(Collection<? super ElectronicItem> shop) {
        List<ElectronicItem> electronicItems = new ArrayList<>();

        for(Integer i = 0; i < ThreadLocalRandom.current().nextInt(MIN_ITEMS, MAX_ITEMS); i++) {
            if (ThreadLocalRandom.current().nextBoolean()) {
                String TVName = "iTV";
                Integer TVPrice = ThreadLocalRandom.current().nextInt(MIN_PRICE, MAX_PRICE);
                Integer TVPower = ThreadLocalRandom.current().nextInt(MIN_POWER, MAX_POWER);
                Integer TVVolume = ThreadLocalRandom.current().nextInt(MIN_TV_VOLUME, MAX_TV_VOLUME);

                TV item = new TV(TVName, TVPrice, TVPower, TVVolume);
                electronicItems.add(item);
                shop.add(item);
            } else {
                String RefrigeratorName = "iHolodilnik";
                Integer RefrigeratorPrice = ThreadLocalRandom.current().nextInt(MIN_PRICE, MAX_PRICE);
                Integer RefrigeratorPower = ThreadLocalRandom.current().nextInt(MIN_POWER, MAX_POWER);
                Integer RefrigeratorFreezerVolume = ThreadLocalRandom.current().nextInt(MIN_REFRIGERATOR_VOLUME, MAX_REFRIGERATOR_VOLUME);

                Refrigerator item = new Refrigerator(RefrigeratorName, RefrigeratorPrice, RefrigeratorPower, RefrigeratorFreezerVolume);
                electronicItems.add(item);
                shop.add(item);

            }
        }

        System.out.println("Electronic items has been added to the store: " + electronicItems.toString());
    }
}
