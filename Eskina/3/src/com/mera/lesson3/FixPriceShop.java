package com.mera.lesson3;

import java.util.Arrays;
import java.util.Random;

public class FixPriceShop {
    public static Random RAND;
    public static final int MIN_PRICE;
    public static final int MAX_PRICE;
    public static int LUCKY_HOUR;
    public static final String[] GOODS;


    static {
        RAND = new Random();
        GOODS = new String[] {"мыло", "лимонад", "книга", "печенье", "перчатки", "пакеты для мусора", "чашка", "какао",
                                "чай", "сок", "паззл", "фонарик", "крем для рук", "воздушный змей", "пластилин",
                                    "наушники", "маршмеллоу", "стиральный порошок", "горшок для цветов"};
        MIN_PRICE = 50;
        MAX_PRICE = 99;
        LUCKY_HOUR = RAND.nextInt(24);
        System.out.printf("Счастливый час в магазине - [%d.00]\n", LUCKY_HOUR);
    }

    private String[] items;
    private int price;

    public FixPriceShop() {
        items = new String[7];
        for (int i = 0; i < items.length; i++) {
            items[i] = GOODS[RAND.nextInt(GOODS.length)];
        }
        price = RAND.nextInt(MAX_PRICE - MIN_PRICE + 1) + MIN_PRICE;
    }

    public int getPrice() {
        return price;
    }

    public String[] getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "FixPriceShop {" +
                "items = " + Arrays.toString(items) +
                ", price = " + price +
                "}";
    }

    //method returns the price of a good.
    //In case if the purchase time coincides with lucky hour,
    //method returns 50 percents discounted price.
    public int checkItemPrice(String item, int hour) {
        int itemPrice = (hour == LUCKY_HOUR) ? (price / 2) : price;
        System.out.printf("Товар: [%s] время покупки: [%d.00] цена: [%d руб]\n", item, hour, itemPrice);
        return itemPrice;
    }
}
