import java.util.Random;

public class Task3 {
    public static void main(String[] args) {

        final int shopsNumber = 3;

        String[] allItems = {"Potato","Meal","Bread","Fish","Soda","Soap","Rope","Clock","Lamp","Scotch_tape","Screwdriver","Wrench"};
        FixPriceShop[] shops = new FixPriceShop[shopsNumber];

        //shops creation
        for(int i = 0; i < shops.length; i++) {
            int numberItems = new Random().nextInt(allItems.length - 1) + 1;
            String[] itemsForShop = new String[numberItems];

            for (int j = 0; j < itemsForShop.length; j++) {
                int itemNumber = new Random().nextInt(allItems.length);
                itemsForShop[j] = allItems[itemNumber];
            }

            int price = new Random().nextInt(50) + 50;

            shops[i] = new FixPriceShop(price, itemsForShop);
        }

        //checking items for every shop
        for(int i = 0; i < shops.length; i++) {
            String[] shopItems = shops[i].getItems();

            int randShopItemNumber = new Random().nextInt(shopItems.length);
            int randHour = new Random().nextInt(23);

            int price = shops[i].checkItemPrice(shopItems[randShopItemNumber], randHour);

            if (price != -1) {
                System.out.println("Shop: " + (i + 1) + " - Item: " + shopItems[randShopItemNumber] + " - Price: " + price);
            }
        }
    }
}