import java.util.Random;

public class FixPriceShop {
    private String[] items;
    private Integer price;
    private static Double DISCOUNT = 0.5;
    private static Integer HAPPY_HOUR;

    static {
        HAPPY_HOUR = new Random().nextInt(23);
    }

    FixPriceShop(Integer price, String ... items) {
        this.price = price;
        this.items = items;
    }

    public Integer getPrice() {
        return this.price;
    }

    public String[] getItems() {
        return this.items;
    }

    public int checkItemPrice(String item, Integer hour) {
        boolean isItemExist = false;

        for(String i: items)
        {
            if (i.equals(item)) {
                isItemExist = true;
                break;
            }
        }

        if (! isItemExist) {
            return -1;
        }

        if (hour.equals(HAPPY_HOUR)) {
            return (int)(getPrice() * DISCOUNT);
        }
        else {
            return getPrice();
        }
    }
}