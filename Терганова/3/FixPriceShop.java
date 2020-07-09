package se.ericsson.jcat.ebs.common.ft.snapshot.testcases;

import java.util.Random;

/**
 * счастливые часы
 * Создайте класс FixPriceShop - магазин, который продает товары по одной цене.
 * В классе создайте поле items - массив товаров (товар - это просто название, тип String)
 * В каждом экземпляре магазина - случайная цена на товары от 50 до 99
 * Но во всех магазинах действует акции "счастливый час" - время, когда действует скидка 50%
 * Счастливые часы едины для всех магазинов. Час - случайное значение от 0 до 23.
 * во всех магазинах это число одно и то же.
 * в классе определите метод getPrice(), который возвращает цену в конкретном магазине
 * В классе определите метод getItems() - который возвращает список товаров
 * В классе определите метод int checkItemPrice(String item, int hour):
 * - первый аргумент - это название товара, который покупатель собирается купить,
 * - второй аргумент - время покупки.
 * Метод должен возвращать цену.
 * Если время покупки совпадает со счастливым часом - то должна быть учтена скидка 50%.
 */

public class FixPriceShop {

    private String[] items;
    private int price;

    private static Random random = new Random();
    private static int happyHour = random.nextInt(23);

    public FixPriceShop(String[] items, int price) {
        this.items = items;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String[] getItems() {
        return items;
    }

    public int checkItemPrice(String item, int hour) {
        if (item == null) {
            return -1;
        }
        for (String tovar : items) {
            if (item.equals(tovar)) {
                return hour == happyHour ? price / 2 : price;
            }
        }
        return -1;
    }

    /**
     * Создайте 3 магазина
     * Каждый магазин заполните случайными товарами
     * Из каждого магазина выберите случайный товар и проверьте его цену в случайное время.
     * Советы: для хранения счастливого часа используйте статическую переменную и статический блок
     * инициализации
     * Для заполнения магазина товарами используйте конструктор и установки цены в магазине
     *
     * @param args
     */
    public static void HappyHours(String[] args) {

        String[] magnitTovars = new String[random.nextInt(200) + 1];
        for (int i = 0; i < magnitTovars.length; i++) {
            magnitTovars[i] = "tovar_#" + (i + 1);
        }
        FixPriceShop magnitShop = new FixPriceShop(magnitTovars, random.nextInt(50) + 50);
        System.out.println("Magnit: price: " + magnitShop.getPrice() + "\n tovars: " + magnitShop.getItems().length);

        String[] perekrestokTovars = new String[random.nextInt(100) + 1];
        for (int i = 0; i < perekrestokTovars.length; i++) {
            perekrestokTovars[i] = "tovar_#" + (i + 1);
        }
        FixPriceShop perekrestokShop = new FixPriceShop(perekrestokTovars, random.nextInt(50) + 50);
        System.out.println("Perekrestok: price: " + perekrestokShop.getPrice() + "\n tovars: "
                + perekrestokShop.getItems().length);

        String[] okTovars = new String[random.nextInt(150) + 1];
        for (int i = 0; i < okTovars.length; i++) {
            okTovars[i] = "tovar_#" + (i + 1);
        }
        FixPriceShop okShop = new FixPriceShop(okTovars, random.nextInt(50) + 50);
        System.out.println("OKey: price: " + okShop.getPrice() + "\n tovars: " + okShop.getItems().length);

        String randomMagnitTovar = "tovar_#" + random.nextInt(magnitShop.getItems().length + 1);
        int randomTime = random.nextInt(24);
        System.out.println("Tovar '" + randomMagnitTovar + "' in Magnit in the time " + randomTime + " costs: "
                + magnitShop.checkItemPrice(randomMagnitTovar, randomTime));

        String randomperekrestokTovar = "tovar_#" + random.nextInt(perekrestokShop.getItems().length + 1);
        randomTime = random.nextInt(24); // in another time
        System.out.println("Tovar '" + randomperekrestokTovar + "' in Perekrestok in the time " + randomTime
                + " costs: " + perekrestokShop.checkItemPrice(randomperekrestokTovar, randomTime));

        String randomOkeyTovar = "good_#" + random.nextInt(okShop.getItems().length + 1);
        randomTime = random.nextInt(24); // in another time
        System.out.println("Tovar '" + randomOkeyTovar + "' in Okey shop in the time " + randomTime + " costs: "
                + okShop.checkItemPrice(randomOkeyTovar, randomTime));

    }

}
