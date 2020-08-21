package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<ShopItem> shopItems = new ArrayList<>();
    private List<Comparator<ShopItem>> itemSorters = new ArrayList<>();

    public Shop() {
        itemSorters.add(ItemSorters::sortByCategory);
        itemSorters.add(ItemSorters::sortByTitle);
        itemSorters.add(ItemSorters::sortByPrice);
        itemSorters.add(ItemSorters::sortByQuantity);
    }

    public List<ShopItem> getShopItems() {
        return shopItems;
    }

    public List<Comparator<ShopItem>> getItemSorters() {
        return itemSorters;
    }

    public void addShopItem(ShopItem shopItem) {
        shopItems.add(shopItem);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopItems=" + shopItems +
                '}';
    }
}
