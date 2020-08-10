import java.util.Collection;
import java.util.Random;

public class AppleGarden {
    private static Random random = new Random();

    public static void fillShopWithApples(Collection<? super Apple> shopToFill) {
        int numGoods = 1 + random.nextInt(4);
        System.out.print("* В магазин добавлены яблоки: ");
        for (int i = 0; i < numGoods; i++) {
            Apple item = new Apple("Яблоко",
                    10 + random.nextInt(91),
                    50,
                    30,
                    Apple.allColors[random.nextInt(Apple.allColors.length)]);
            shopToFill.add(item);
            System.out.print(item.getColor() + " ");
        }
        System.out.println();
    }
}
