package com.mera.lesson7;

import java.util.Collection;

public class ImJustLookingVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        System.out.println("Посетитель пришел посмотреть");

        if (shop == null) {
            System.out.println("Магазин пуст, покупок не будет");
            return;
        }

        if (shop.isEmpty()) {
            System.out.println("Товары закончились");
            return;
        }

        shop.forEach(item -> System.out.println(item.getClass().getSimpleName() + " " + item.getName() + " - " + item.getPrice() + " руб"));
    }
}
