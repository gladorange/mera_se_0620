import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int numberOfShops = 3;
        String[] goodsFromShops = {"T-Shirt", "Kimono", "Parka", "Raincoat", "Windcheater", "Belt", "Cap", "Tie", "Hat", "Scarf", "Jeans", "Trousers"};
        FixPriceShop[] shops = new FixPriceShop[numberOfShops];

        for (int i = 0; i < shops.length; i++) {
            int numberOfGoods = new Random().nextInt(goodsFromShops.length - 1) + 1;
            String[] goodsForShop = new String[numberOfGoods];

            for (int j = 0; j < goodsForShop.length; j++) {
                int numberOfItem = new Random().nextInt(goodsFromShops.length);
                goodsForShop[j] = goodsFromShops[numberOfItem];
            }
            int price = new Random().nextInt(99);
            shops[i] = new FixPriceShop(price, goodsForShop);
        }

        for(int i = 0; i < shops.length; i++){
            String[] shopGoods =  shops[i].getItems();

            int randomShopGoodsNumber = new Random().nextInt(shopGoods.length);
            int randomHour = new Random().nextInt(23);

            int price = shops[i].checkItemPrice(shopGoods[randomShopGoodsNumber], randomHour);

            if (price != -1){
                System.out.println("Shop: " + (i + 1) + ", Item: " + shopGoods[randomShopGoodsNumber] + ", Price: " + price);
            }

        }
    }

}