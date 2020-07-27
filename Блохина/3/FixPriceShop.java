import java.util.Random;

public class FixPriceShop {
    public String[] items;
    public int price;
    public static int happyHour;
    public static int maxHour = 23;

    public FixPriceShop(String[] items, int price) {
        this.items = items;
        this.price = price;
    }

    static {
        happyHour = new Random().nextInt(maxHour);
    }

    public int getPrice() {
        return price;
    }

    public String[] getItems() {
        return items;
    }

    public String getItem(int max) {
        return items[new  Random().nextInt(max)];
    }

    public int checkItemPrice(String item, int hour) {
        if(item.isEmpty()) {
            return -1;
        }
        for (String selectItem : items) {
            if (item.equals(selectItem)) {
                return hour == happyHour ? price / 2 : price;
            }
        }
        return -1;
    }
}
