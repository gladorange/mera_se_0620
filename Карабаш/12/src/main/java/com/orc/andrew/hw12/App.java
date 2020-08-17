package com.orc.andrew.hw12;

import java.util.Comparator;
import java.util.Random;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Создание магазина...");

        ShopItem baton = new ShopItem("Еда", "Батон", 22.0, 30, ShopItem.getRandomItemID());
        ShopItem kolbasa = new ShopItem("Еда", "Колбаса", 100.0, 20, ShopItem.getRandomItemID());
        ShopItem shokolad = new ShopItem("Еда", "Шоколад", 50.0, 25, ShopItem.getRandomItemID());
        ShopItem moloko = new ShopItem("Еда", "Молоко", 30.0, 40, ShopItem.getRandomItemID());

        ShopItem TVs = new ShopItem("Электроника", "Телевизор Рекорд", 2300.0, 3, ShopItem.getRandomItemID());
        ShopItem mobiles = new ShopItem("Электроника", "Смартфон Самсунг", 7000.0, 17, ShopItem.getRandomItemID());
        ShopItem holodilniks = new ShopItem("Электроника", "Холодильник Свияга", 12000.0, 2, ShopItem.getRandomItemID());

        ShopItem book1 = new ShopItem("Книги", "Таинственный остров", 300.0, 5, ShopItem.getRandomItemID());
        ShopItem book2 = new ShopItem("Книги", "Остров сокровищ", 250.0, 7, ShopItem.getRandomItemID());

        ShopItem noski = new ShopItem("Одежда", "Носки", 35.0, 10, ShopItem.getRandomItemID());

        Shop shop = new Shop();

        shop.addShopItem(baton);
        shop.addShopItem(kolbasa);
        shop.addShopItem(shokolad);
        shop.addShopItem(moloko);
        shop.addShopItem(TVs);

        shop.addShopItem(mobiles);
        shop.addShopItem(holodilniks);
        shop.addShopItem(book1);
        shop.addShopItem(book2);
        shop.addShopItem(noski);

        System.out.println("Товары в порядке добавления в магазин:");
        System.out.println(shop);
        System.out.println("---");

        System.out.println("(Компараторы: 0 - по категории, 1 - по наимен., 2 - по цене, 3 - по кол-ву)");
        Random random = new Random();
        int randomComparatorId = random.nextInt(shop.getItemSorters().size());
        Comparator<ShopItem> someComparator = shop.getItemSorters().get(randomComparatorId);
        //someComparator.toString()
        System.out.println("Сортировка случайным компаратором (" + randomComparatorId + "), и вывод:");
        System.out.println("---");
        ShopItem.printFormatted(null);
        shop.getShopItemList().stream()
                .sorted(someComparator)
                .forEach(ShopItem::printFormatted); // System.out::println
        System.out.println(".");
    }
}
