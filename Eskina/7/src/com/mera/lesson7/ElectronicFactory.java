package com.mera.lesson7;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

public class ElectronicFactory {

    public static void fillShopWithElectronicGoods(Collection <? super ElectronicItem>  shop) {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        int numberGoods = rand.nextInt(1,6);
        System.out.println("В магазин добавлена электроника: " + numberGoods + " товаров");
        for (int i =0; i < numberGoods; i++) {
            ElectronicItem itemToAdd = createRandomElectronicItem();
            if (itemToAdd != null){
                System.out.println(itemToAdd);
                shop.add(itemToAdd);
            }
        }
    }

    public static ElectronicItem createRandomElectronicItem() {
        ElectronicEnum itemType = ElectronicEnum.generateRandomElectronicType();
        switch (itemType) {
            case TV -> {return TV.createRandomTV();}
            case FRIDGE ->{return Refrigerator.createRandomRefrigerator();}
        }
        return null;
    }
}
