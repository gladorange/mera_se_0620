package com.orc.andrew.hw12;

public class ItemSorters {

    static int sortByCategory(ShopItem one, ShopItem two) {
        int result = one.getCategory().compareTo(two.getCategory());
        if (result != 0)
            return result;
        return one.compareTo(two);
    }

    static int sortByTitle(ShopItem one, ShopItem two) {
        int result = one.getName().compareTo(two.getName());
        if (result != 0)
            return result;
        return one.compareTo(two);
    }

    static int sortByPrice(ShopItem one, ShopItem two) {
        int result = Double.compare(one.getPrice(), two.getPrice());
        if (result != 0)
            return result;
        return one.compareTo(two);
    }

    static int sortByQuantity(ShopItem one, ShopItem two) {
        int result = Double.compare(one.getAmount(), two.getAmount());
        if (result != 0)
            return result;
        return one.compareTo(two);
    }


}
