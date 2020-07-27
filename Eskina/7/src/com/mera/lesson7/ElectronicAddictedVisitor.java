package com.mera.lesson7;

import java.util.*;

import static java.util.Comparator.comparing;


public class ElectronicAddictedVisitor implements ShopVisitor, Buyer{
    public static final Comparator<ElectronicItem> BY_POWER = comparing(ElectronicItem::getPower);

    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        System.out.println(this.getClass().getSimpleName() + " выбирает электронику");

        if (shop == null) {
            System.out.println("Магазин пуст, покупок не будет");
            return;
        }

        if (shop.isEmpty()) {
            System.out.println("Товары закончились");
            return;
        }

        Collection<ElectronicItem> electronicItems = new ArrayList<>();
        shop.forEach(item -> { if ((item.getClass() == TV.class) || (item.getClass() == Refrigerator.class)) {
                electronicItems.add((ElectronicItem) item);
        }
        });
        if (electronicItems.size() != 0) {
            ElectronicItem itemToBuy = findTheMostPowerfulItem(electronicItems);
            if (itemToBuy != null) {
                buy(shop,itemToBuy);
            }
        } else {
            System.out.println("Не нашлось электронных товаров в магазине");
        }
    }
    @Override
    public void buy(Collection<? extends ShopItem> shop, Object item) {
        System.out.println(this.getClass().getSimpleName() + " покупает " + item);
        shop.remove(item);
    }

    public ElectronicItem findTheMostPowerfulItem(Collection<ElectronicItem> electronicItems) {
        List<ElectronicItem> copyOfItems = new ArrayList<>(electronicItems);
        Collections.sort(copyOfItems, BY_POWER);
        return copyOfItems.get(electronicItems.size() - 1);
    }


}
