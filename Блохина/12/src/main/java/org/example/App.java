package org.example;

import java.util.Comparator;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String PRODUCTS_CATEGORY = "Продукты";
        String HABERDASHERY_CATEGORY = "Галантерея";
        String HOUSEHOLD_CHEMICALS_CATEGORY = "Бытовая химия";

        ShopItem item1 = new ShopItem(PRODUCTS_CATEGORY, 10, "Хлеб", 150, ShopItem.getRandomStringId());
        ShopItem item2 = new ShopItem(HABERDASHERY_CATEGORY, 100, "Полотенце", 50, ShopItem.getRandomStringId());
        ShopItem item3 = new ShopItem(HOUSEHOLD_CHEMICALS_CATEGORY, 80, "Моющее средство", 15, ShopItem.getRandomStringId());
        ShopItem item4 = new ShopItem(PRODUCTS_CATEGORY, 1000, "Колбаса", 5, ShopItem.getRandomStringId());
        ShopItem item5 = new ShopItem(HABERDASHERY_CATEGORY, 135, "Одеколон", 3, ShopItem.getRandomStringId());
        ShopItem item6 = new ShopItem(HOUSEHOLD_CHEMICALS_CATEGORY, 230, "Стиральный порошок", 33, ShopItem.getRandomStringId());
        ShopItem item7 = new ShopItem(PRODUCTS_CATEGORY, 60, "Молоко", 45, ShopItem.getRandomStringId());
        ShopItem item8 = new ShopItem(HABERDASHERY_CATEGORY, 3, "Пуговицы", 500, ShopItem.getRandomStringId());
        ShopItem item9 = new ShopItem(HOUSEHOLD_CHEMICALS_CATEGORY, 55, "Мыло", 22, ShopItem.getRandomStringId());
        ShopItem item10 = new ShopItem(PRODUCTS_CATEGORY, 1500, "Икра", 1, ShopItem.getRandomStringId());

        Shop myShop = new Shop();

        myShop.addShopItem(item1);
        myShop.addShopItem(item2);
        myShop.addShopItem(item3);
        myShop.addShopItem(item4);
        myShop.addShopItem(item5);
        myShop.addShopItem(item6);
        myShop.addShopItem(item7);
        myShop.addShopItem(item8);
        myShop.addShopItem(item9);
        myShop.addShopItem(item10);

        System.out.println(myShop);

        int randomComparatorId = new Random().nextInt(myShop.getItemSorters().size());
        Comparator<ShopItem> someComparator = myShop.getItemSorters().get(randomComparatorId);
        System.out.println("\nСортировка случайным компаратором: " + getSortingType(randomComparatorId));
        final String formatString = "%-10s  %-10s  %-12s  %-10s  %-10s\n";
        System.out.format(formatString, "ID", "Категория", "Наименование", "Цена", "Остаток");

        myShop.getShopItems().stream().sorted(someComparator).forEach(ShopItem::printFormatted);

    }

    private static String getSortingType(int sortId) {
        String sortingType;
        switch (sortId) {
            case 0:
                sortingType = "сортировка по категории";
                break;
            case 1:
                sortingType = "сортировка по наименованию";
                break;
            case 2:
                sortingType = "сортировка по цене";
                break;
            case 3:
                sortingType = "сортировка по количеству";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sortId);
        }
        return sortingType;
    }
}
