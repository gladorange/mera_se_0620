import java.util.Random;

public class HappyHours {

    public static String[] items = {"мыло", "веревка", "диплом", "сыр", "вода"};
    public int i = new Random().nextInt(items.length );

    public static void main(String[] args) {
        String[] shop = {"магазина 1", "магазина 2", "магазина 3"};
        int i = new Random().nextInt(shop.length );
        int hour = new Random().nextInt(23 + 1);
        FixPriceShop fixPriceShop = new FixPriceShop();
        fixPriceShop.setPrice(-(-100 + new Random().nextInt(-50 + 99)));
        fixPriceShop.setGood(items[i]);
        System.out.println("счастливый час " + FixPriceShop.happyHour);

        System.out.println("товар " + fixPriceShop.getGood()+ " из "+shop[i]+" стоит " + fixPriceShop.checkItemPrice(hour) + " в "+hour);
    }


}
