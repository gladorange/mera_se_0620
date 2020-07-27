package com.mera.lesson7;

import java.util.Collection;

public class RichVisitor implements ShopVisitor, Buyer {

    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        System.out.println(this.getClass().getSimpleName() + " выбирает товары");

        if (shop == null) {
            System.out.println("Магазин пуст, покупок не будет");
            return;
        }
        if (shop.isEmpty()) {
            System.out.println("Товары закончились");
            return;
        }

        if (shop.size() == 1) {
            System.out.println("Остался один товар, а я покупаю четные");
            return;
        }

        Object[] items = shop.toArray();
        for (int i = 0; i < items.length; i++) {
            if ((i % 2) == 1) {
                buy(shop, items[i]);
            }
        }
    }

    @Override
    public void buy(Collection<?extends ShopItem> shop, Object item) {
        System.out.println(this.getClass().getSimpleName() + " покупает " + item);
        shop.remove(item);
    }
}
