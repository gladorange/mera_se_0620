import java.util.Random;

public class ShopManagement {

    public static void main(String[] args) {

        Random rand = new Random();
        String itemToFound;
        int timeToCheck;
        int maxItems = 20;

        FixPriceShop shop1 = new FixPriceShop(Goods.getRandomGoods(rand.nextInt(maxItems)));
        itemToFound = Goods.GOODS_LIST[rand.nextInt(maxItems)];
        System.out.println("В этом магазине есть следующие товары:");
        shop1.printItems();
        System.out.println("В этом магазине единая цена: " + shop1.getPrice());
        timeToCheck = rand.nextInt(24);
        System.out.println("Стоимость товара: " + itemToFound + " в " + timeToCheck + ": " + shop1.checkItemPrice(itemToFound,timeToCheck));

        FixPriceShop shop2 = new FixPriceShop(Goods.getRandomGoods(rand.nextInt(maxItems)));
        itemToFound = Goods.GOODS_LIST[rand.nextInt(maxItems)];
        System.out.println("В этом магазине есть следующие товары:");
        shop2.printItems();
        System.out.println("В этом магазине единая цена: " + shop2.getPrice());
        timeToCheck = rand.nextInt(24);
        System.out.println("Стоимость товара: " + itemToFound + " в " + timeToCheck + ": " + shop2.checkItemPrice(itemToFound,timeToCheck));

        FixPriceShop shop3 = new FixPriceShop(Goods.getRandomGoods(rand.nextInt(maxItems)));
        itemToFound = Goods.GOODS_LIST[rand.nextInt(maxItems)];
        System.out.println("В этом магазине есть следующие товары:");
        shop3.printItems();
        System.out.println("В этом магазине единая цена: " + shop3.getPrice());
        timeToCheck = rand.nextInt(24);
        System.out.println("Стоимость товара: " + itemToFound + " в " + timeToCheck + ": " + shop3.checkItemPrice(itemToFound,timeToCheck));



    }
}
