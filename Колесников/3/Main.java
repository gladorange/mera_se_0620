import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final int SHOPS_QUANTITY = 3;
    private static final String[] SHOP_ITEMS = {
            "Milk", "Meat", "Sweets", "Sausage", "Cheese",
    };

    private static String[] createRandomItems() {
        String[] randomItems = new String[3];
        for (int i = 0; i < randomItems.length; i++) {
            String item = SHOP_ITEMS[new Random().nextInt(5)];
            if (Arrays.asList(randomItems).contains(item)){
                i--;
                continue;
            }
            randomItems[i] = item;
        }
        return randomItems;
    }

    private static FixPriceShop[] shopsFactory() {
        FixPriceShop [] shops = new FixPriceShop[SHOPS_QUANTITY];
        for (int i = 0; i < SHOPS_QUANTITY; i++) {
            String[] shopItems = createRandomItems();
            shops[i] = new FixPriceShop(shopItems);
        }
        return shops;
    }

    private static void getShopsInfo(FixPriceShop [] shops) {
        for (FixPriceShop i : shops) {
            String [] shopItems = i.getItems();
            String checkItem = shopItems[new Random().nextInt(shopItems.length)];
            int checkTime = new Random().nextInt(24);
            System.out.printf("Happy hour is %d.00%nItems on sale %s%nPrice %d%nPrice for %s at %d.00 is %s%n%n",
                    i.getHappyHour(), Arrays.toString(shopItems), i.getPrice(), checkItem, checkTime, i.checkItemPrice(checkItem, checkTime));
        }
    }


    public static void main(String[] args) {
        FixPriceShop [] shops = shopsFactory();
        getShopsInfo(shops);
    }
}