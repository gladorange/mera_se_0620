import java.util.Collection;
import java.util.Random;

public class ElectronicFabric {
    private static Random random = new Random();
    private static String[] fridgeNames = {"Минск", "Бирюса", "Свияга", "Атлант"};
    private static String[] tvNames = {"Чайка", "Рекорд", "Рубин"};

    public static void fillShopWithElectronicGoods(Collection<? super ElectronicItem> shopToFill) {
        int numGoods = 1 + random.nextInt(5);
        System.out.print("* В магазин добавлена электроника: ");
        for (int i = 0; i < numGoods; i++) {
            ElectronicItem item;
            if (random.nextBoolean()) {
                item = new TV(tvNames[random.nextInt(tvNames.length)],
                        1000 + random.nextInt(4000),
                        100 + random.nextInt(400),
                        1 + random.nextInt(10));
            } else {
                item = new Refrigerator(fridgeNames[random.nextInt(fridgeNames.length)],
                        5000 + random.nextInt(15000),
                        300 + random.nextInt(1200),
                        5 + random.nextInt(45));
            }
            shopToFill.add(item);
            System.out.print("{" + item.getTypeName() + " " + item.getName() +"} ");
        }
        System.out.println();
    }


}
