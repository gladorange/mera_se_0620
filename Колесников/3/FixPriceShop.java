import java.util.Random;

class FixPriceShop {

    private static final int HAPPY_HOUR;
    private static final int INCORRECT_ITEM = -1;
    private int price;
    private String[] items;

    static {
        HAPPY_HOUR = new Random().nextInt(24);
    }

    FixPriceShop(String[] items) {
        this.items = items;
        this.price = new Random().nextInt(50) + 50;
    }

    int getHappyHour(){
        return HAPPY_HOUR;
    }

    String[] getItems() {
        return items;
    }

    int getPrice() {
        return price;
    }

    int checkItemPrice(String item, int hour) {
        for(String shopItem : this.items) {
            if(shopItem.equals(item)) {
                return (hour == HAPPY_HOUR) ? (price / 2) : price;
            }
        }
        return INCORRECT_ITEM;
    }
}
