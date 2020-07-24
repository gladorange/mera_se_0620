import java.util.Random;

public class FixPriceShop {

    private final static int INVALID_PRICE = -1;
    private final static int MIN_PRICE = 50;
    private final static int MAX_PRICE = 99;
    private final static int HAPPY_HOUR;
    private final static Random RANDOM_GENERATOR = new Random();

    static {
        HAPPY_HOUR = RANDOM_GENERATOR.nextInt(23);
    }

    private int price;
    private String[] items;

    public FixPriceShop(String[] items) {
        this.items = items;
        this.price = RANDOM_GENERATOR.nextInt(MAX_PRICE - MIN_PRICE) + MIN_PRICE;
    }

    public int getPrice() {
        return price;
    }

    public String[] getItems() {
        return items;
    }

    public int checkItemPrice(String item, int hour) {
        //Invalid input or shop is empty
        if(item == null || this.items == null) {
            return INVALID_PRICE;
        }
        //Check if we have item in the shop
        for(String shopItem : this.items) {
            if(shopItem.equals(item)) {
                return (hour == HAPPY_HOUR) ? (price / 2) : price;
            }
        }
        return INVALID_PRICE;
    }
}
