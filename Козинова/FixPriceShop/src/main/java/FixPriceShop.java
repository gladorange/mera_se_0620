import java.util.Random;

public class FixPriceShop {
    String[] items;
    int price;
    static int HAPPY_HOUR;

    String[] getItems() {
        return this.items;
    }
    int getPrice() {
        return this.price;
    }

    static {
        HAPPY_HOUR = new Random().nextInt(24);
        System.out.println("Happy hour: " + HAPPY_HOUR);
    }

    public FixPriceShop(String[] items) {
        this.items = items;
        this.price = new Random().nextInt(50)+50;
    }

    void printItems(){
        for (String item : items){
            System.out.println(item);
        }
    }
    int checkItemPrice(String item, int hour){
        boolean isItemFound = false;
        for (String i: items) {
            if (i.contentEquals(item))
            {
                isItemFound = true;
                break;
            }
        }
        if (!isItemFound)
        {
            return -1;
        }

        int resPrice = (hour == HAPPY_HOUR) ? price/2 : price;
        return resPrice;
    }
}
