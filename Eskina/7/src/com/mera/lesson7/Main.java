package com.mera.lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Collection<ElectronicItem> electronicStore = new ArrayList<>();
        Collection<FoodItem> groceryStore = new ArrayList<>();
        Collection<ShopItem> hyperMarket = new ArrayList<>();
        Collection<Apple> fruitStand = new ArrayList<>();

        System.out.println("Добавляем электронные товары в магазин электроники");
        ElectronicFactory.fillShopWithElectronicGoods(electronicStore);

        System.out.println("Добавляем электронные товары в гипермаркет");
        ElectronicFactory.fillShopWithElectronicGoods(hyperMarket);

        System.out.println("Добавляем яблоки в продуктовый магазин");
        AppleGarden.fillShopWithApples(groceryStore);

        System.out.println("Добавляем яблоки в киоск с яблоками");
        AppleGarden.fillShopWithApples(fruitStand);

        System.out.println("Добавляем яблоки в гипермаркет");
        AppleGarden.fillShopWithApples(hyperMarket);

        System.out.println("Добавляем продукты в гипермаркет");
        FoodFactory.fillShopWithFood(hyperMarket);

        System.out.println("Добавляем продукты в продуктовый магазин");
        FoodFactory.fillShopWithFood(groceryStore);


        List<ShopVisitor> visitors = Arrays.asList(new ImJustLookingVisitor(), new ElectronicAddictedVisitor(), new RichVisitor());

        visitors.forEach(visitor -> {
            System.out.println("Заходим в продуктовый магазин");
            goShopping(visitor, groceryStore);
            System.out.println("Заходим в магазин электроники");
            goShopping(visitor, electronicStore);
            System.out.println("Заходим в гипермаркет");
            goShopping(visitor, hyperMarket);
            System.out.println("Заходим во фруктовый киоск");
            goShopping(visitor,fruitStand);
        });

        System.out.println("\nРевизия после шоппинга");

        System.out.println("\nПродуктовый магазин:");
        groceryStore.forEach(System.out::println);

        System.out.println("\nГипермаркет:");
        hyperMarket.forEach(System.out::println);

        System.out.println("\nМагазин электроники:");
        electronicStore.forEach(System.out::println);

        System.out.println("\nФруктовый киоск:");
        fruitStand.forEach(System.out::println);
    }

    public static void goShopping (ShopVisitor visitor, Collection<? extends ShopItem> shop) {
        if (visitor != null) {
            visitor.visitShop(shop);
        }
    }
}
