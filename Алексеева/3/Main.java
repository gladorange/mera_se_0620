import java.io.FileNotFoundException;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        int numberOfShops = 3;

        FixPriceShop[] fixPriceShops = new FixPriceShop[numberOfShops];

        for(int i = 0; i < numberOfShops; i++) {
            fixPriceShops[i] = new FixPriceShop();
            System.out.println("Магазин FixPrice №" + (i + 1));
            System.out.println("Цена на все товары: " + fixPriceShops[i].getPrice() + " руб.");

            System.out.println("Счастливый час в магазине: " + fixPriceShops[i].getHappyHour() + " ч.");

            //int randomTime = 17;  // for debugging
            int randomTime = new Random().nextInt(23);
            System.out.println("Сейчас " + randomTime + " ч.");

            String[] shopItems = fixPriceShops[i].getItems();
            //String randomShopItem = "unavailable item";  // for debugging
            String randomShopItem = shopItems[new Random().nextInt(shopItems.length)];
            int itemPriceInThisTime = fixPriceShops[i].checkItemPrice(randomShopItem, randomTime);
            if(itemPriceInThisTime == -1) {
                System.out.println("Товара \"" + randomShopItem + "\" нет в наличии");
            }
            else {
                System.out.println("Цена на товар \"" + randomShopItem + "\" в данный час: " + itemPriceInThisTime + " руб.");
            }

            System.out.println();
        }



    }
}
