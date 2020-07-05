import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FixPriceShop {
    private String[] items;
    private int price;
    private static int happyHour;
    private final static double HAPPY_HOUR_DISCOUNT = 0.5;

    static {
        //happyHour = 17;  // for debugging
        happyHour = new Random().nextInt(24);  // happy hour is a random value from 0 to 23, in all stores this number is the same
    }

    FixPriceShop() throws FileNotFoundException {
        this.items = fillTheStoreWithRandomItems();
        this.price = new Random().nextInt(50) + 50;
    }

    public int getPrice() {
        return price;
    }

    public String[] getItems() {
        return items;
    }

    public int getHappyHour() {
        return happyHour;
    }

    public int checkItemPrice(String item, int hour) {
        for(String thisItem : items) {
            if (thisItem.equals(item)) {
                return hour == happyHour ? (int)(price * HAPPY_HOUR_DISCOUNT) : price;
            }

        }
        return -1;
    }

    private String[] getAllItemsInWarehouse() throws FileNotFoundException {
        String filePath = "files/items.txt";
        Scanner scanner = new Scanner(new File(filePath));
        List<String> shopItems = new ArrayList<>();
        while (scanner.hasNextLine()) {
            shopItems.add(scanner.nextLine());
        }

        String[] itemsInAllShops = shopItems.toArray(new String[0]);

        return itemsInAllShops;
    }

    private int getNumberOfItemsInTheShop() throws FileNotFoundException {
        String[] itemsInAllShops = getAllItemsInWarehouse();


        int minQuantityOfItemsInTheShop = 5;  // the minimum possible number of products in the shop


        int numberOfItemsInTheShop = new Random().nextInt(itemsInAllShops.length);
        return Math.max(numberOfItemsInTheShop, minQuantityOfItemsInTheShop);  // (numberOfItemsInTheShop >= minQuantityOfItemsInTheShop) ? numberOfItemsInTheShop : minQuantityOfItemsInTheShop;

    }

    private String[] fillTheStoreWithRandomItems() throws FileNotFoundException {
        int numberOfItemsInTheShop = getNumberOfItemsInTheShop();
        String[] itemsInTheShop = new String[numberOfItemsInTheShop];  // items in this shop

        String[] itemsInAllShops = getAllItemsInWarehouse(); // all items in Warehouse

        for (int i = 0; i < itemsInTheShop.length; i++) {
            int itemNumber = new Random().nextInt(itemsInAllShops.length);
            itemsInTheShop[i] = itemsInAllShops[itemNumber];
        }

        return itemsInTheShop;
    }
}
