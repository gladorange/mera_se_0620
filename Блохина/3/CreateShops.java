import java.util.Random;

public class CreateShops {

    public static void main (String[] args) {
        Random random = new Random();

        int shopCount = 3;
        String[] shopItems = {"фрукт", "сок", "игрушка", "обувь", "химия"};
        int itemSize = shopItems.length;
        int minPrice = 50;
        int maxPrice = 99;
        int maxHour = FixPriceShop.maxHour;
        int hour;

        System.out.println("\nСписок товаров:");
        for (String item : shopItems) {
            System.out.println(item);
        }

        int happyHour = FixPriceShop.happyHour;
        System.out.println("Счастливый час: " + happyHour);

        for (int i = 0; i < shopCount; i++) {
            FixPriceShop shop = new FixPriceShop(shopItems, getPrice(minPrice, maxPrice));
            System.out.println("\nМагазин " + (i + 1));
            String randomItemFromShop = shop.getItem(itemSize);
            hour = random.nextInt(maxHour);
            System.out.println("Случайный товар:" + randomItemFromShop);
            System.out.println("Цена товара:" + shop.getPrice());
            System.out.println("Стоимость товара в " + hour + " часов: " + shop.checkItemPrice(randomItemFromShop, hour));
        }

    }

    public static int getPrice(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1) + min);
    }


}
