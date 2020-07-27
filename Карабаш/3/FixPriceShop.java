import java.util.Random;

public class FixPriceShop {

    String[] items;
    int price;
    static int happyHour;

    static {
        Random rand = new Random();
        happyHour = rand.nextInt(24);
    }

    public FixPriceShop(int price, String[] items) {
        this.items = items;
        this.price = price;
    }

    public String[] getItems() {
        return items;
    }

    public int getPrice() {
        return price;
    }

    public int checkItemPrice(String item, int hour) {
        if (item == null) {
            return -1;
        }
        for (String good : items) {
            if (item.equals(good)) {
                return hour == happyHour ? price / 2 : price;
            }
        }
        return -1;
    }
}
