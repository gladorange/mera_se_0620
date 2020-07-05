import java.util.Random;

public class FixPriceShop {

    public String good;
    public int price;
    static int happyHour;

    {
        happyHour = new Random().nextInt(23 + 1);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    int checkItemPrice(int hour) {
        if (hour == happyHour) {
            return (price / 2);
        } else {
            return (price);
        }
    }

    public static void main(String[] args) {

    }
}