package com.orc.andrew.hw12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop {

    private List<ShopItem> shopItemList = new ArrayList<>();

    private List<Comparator<ShopItem>> itemSorters = new ArrayList<>();

    public Shop() {
        addItemSorter(ItemSorters::sortByCategory);
        addItemSorter(ItemSorters::sortByTitle);
        addItemSorter(ItemSorters::sortByPrice);
        addItemSorter(ItemSorters::sortByQuantity);
    }

    public List<ShopItem> getShopItemList() {
        return shopItemList;
    }

    public void addShopItem(ShopItem shopItem) {
        shopItemList.add(shopItem);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Shop{shopItemList=[");
        boolean notFirst = false;
        for (ShopItem item : shopItemList) {
            if (notFirst) {
                out.append(',');
            }
            notFirst = true;
            out.append("\n ");
            out.append(item);
        }
        out.append("\n]");
        return out.toString();
    }


    public List<Comparator<ShopItem>> getItemSorters() {
        return itemSorters;
    }

    public void addItemSorter(Comparator<ShopItem> itemSorter) {
        this.itemSorters.add(itemSorter);
    }

}
