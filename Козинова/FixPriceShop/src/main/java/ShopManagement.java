import java.util.Random;

public class ShopManagement {
    static void checkPriceRandomItem(FixPriceShop shop){
        Random rand = new Random();
        String itemToFound;
        int timeToCheck;
        int maxItems = Goods.GOODS_LIST.length;

        itemToFound =Goods.GOODS_LIST[rand.nextInt(maxItems)];
        System.out.println("В этом магазине есть следующие товары:");
        shop.printItems();
        System.out.println("В этом магазине единая цена: "+shop.getPrice());
        timeToCheck =rand.nextInt(24);
        System.out.println("Стоимость товара: "+itemToFound +" в "+timeToCheck +": "+shop.checkItemPrice(itemToFound,timeToCheck));
}
    public static void main(String[] args) {
        Random randVal = new Random();
        FixPriceShop shop1 = new FixPriceShop(Goods.getRandomGoods(randVal.nextInt(Goods.GOODS_LIST.length)));
        checkPriceRandomItem(shop1);
        FixPriceShop shop2 = new FixPriceShop(Goods.getRandomGoods(randVal.nextInt(Goods.GOODS_LIST.length)));
        checkPriceRandomItem(shop2);
        FixPriceShop shop3 = new FixPriceShop(Goods.getRandomGoods(randVal.nextInt(Goods.GOODS_LIST.length)));
        checkPriceRandomItem(shop3);


    }
}
