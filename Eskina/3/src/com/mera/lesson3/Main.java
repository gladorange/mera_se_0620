package com.mera.lesson3;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = FixPriceShop.RAND;
        //Create 3 shops and randomly choose one good. Check its price (purchuase time is random).
        FixPriceShop[] shops = new FixPriceShop[3];
        FixPriceShop shop;
        for (int i = 0; i < shops.length; i++) {
            shops[i] = new FixPriceShop();
            shop = shops[i];
            if (shop != null) {
                String[] goods = shop.getItems();
                //print the goods of each shop
                System.out.println(shop.toString());
                int time = rand.nextInt(24);
                shop.checkItemPrice(goods[rand.nextInt(goods.length)], time);
            }
        }
    }
}
