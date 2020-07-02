import java.util.Arrays;
import java.util.Random;

public class Main {

    private final static String[] SHOP_ITEMS = {
            "T-shirt", "Jeans", "Sweatpants", "Hoodie", "Jacket", "Coat",
            "Running shoes", "Casual shoes", "Backpack", "Tennis Racquet",
            "Bike helmet", "Bike gloves", "Sunglasses", "Ball", "Dumbbells",
            "Milk", "Bread", "Tomatoes", "Green Apples", "Salad", "Chicken",
            "Beef", "Black Tea", "Coffee"
    };

    private static Random random = new Random();

    private static String[] generateRandomShopItems() {
        int itemCount = random.nextInt(SHOP_ITEMS.length);
        //generate at least three items
        if(itemCount < 3) {
            itemCount = 3;
        }
        String[] randomItems = new String[itemCount];
        for (int i = 0; i < randomItems.length; i++) {
            randomItems[i] = SHOP_ITEMS[random.nextInt(SHOP_ITEMS.length - 1)];
        }
        return randomItems;
    }

    private static void exploreShop(FixPriceShop shop) {
        String[] shopItems = shop.getItems();
        if(shopItems == null || shopItems.length == 0) {
            System.out.println("This shop has nothing to sell!");
            return;
        }
        System.out.println("This shop sells following items: ");
        System.out.println(Arrays.toString(shop.getItems()));
        System.out.println("Normal price is " + shop.getPrice() + ".");
        //Get random item name (from this shop)
        String item = shopItems[random.nextInt(shopItems.length - 1)];
        //Generate random time
        int hour = random.nextInt(23);
        System.out.println(String.format("Item \"%s\" costs %d at %d.", item, shop.checkItemPrice(item, hour), hour));
    }

    public static void main(String[] args) {
        //Create 3 fix price shops with randoms items
        for (int i = 0; i < 3; i++) {
            System.out.println("Fix price shop #" + (i + 1));
            exploreShop(new FixPriceShop(generateRandomShopItems()));
            System.out.println();
        }
    }
}
