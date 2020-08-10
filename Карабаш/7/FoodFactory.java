import java.util.Collection;
import java.util.Random;

public class FoodFactory {
    private static Random random = new Random();

    public static void fillShopWithFood(Collection<? super FoodItem> shopToFill) {
        int numGoods = 1 + random.nextInt(6);
        StringBuilder appleColors = new StringBuilder();
        int breadNumber = 0;
        int breadGross = 0;
        for (int i = 0; i < numGoods; i++) {
            FoodItem someFood;
            if (random.nextBoolean()) {
                Colors color = Apple.allColors[random.nextInt(Apple.allColors.length)];
                someFood = new Apple("Яблоко",
                        10 + random.nextInt(91),
                        50,
                        30,
                        color);
                appleColors.append(color);
                appleColors.append(' ');
            } else {
                int thisWeight = 500;
                someFood = new Bread("Батон",
                        20 + random.nextInt(20),
                        200,
                        3,
                        thisWeight);
                breadGross += thisWeight;
                breadNumber++;
            }
            shopToFill.add(someFood);
        }
        System.out.println("* В магазин добавлены яблоки (цветов: " + appleColors +
                "), и хлеб (" + breadNumber + " булок) общим весом: " + breadGross + " грамм");
    }

}
