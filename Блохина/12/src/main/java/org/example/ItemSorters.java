package org.example;

public class ItemSorters {
    public static int sortByCategory(ShopItem firstItem, ShopItem secondItem) {
        return firstItem.getCategory().compareToIgnoreCase(secondItem.getCategory());
    }

    public static int sortByTitle(ShopItem firstItem, ShopItem secondItem) {
        return firstItem.getName().compareToIgnoreCase(secondItem.getName());
    }

    public static int sortByPrice(ShopItem firstItem, ShopItem secondItem) {
        return Double.compare(firstItem.getPrice(), secondItem.getPrice());
    }

    public static int sortByQuantity(ShopItem firstItem, ShopItem secondItem) {
        return Integer.compare(firstItem.getCount(), secondItem.getCount());
    }
}
