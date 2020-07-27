import java.util.Random;

public class Goods {
    static String[] GOODS_LIST;

    static {
        GOODS_LIST = new String[]{"jam", "grape", "cheese", "soup", "milk", "bread", "juce", "sugar", "potato", "tomato", "apple", "grapefruit", "soap", "flour", "butter", "paper", "water", "cake", "pen", "washing powder"};
    }
    public static String[] getRandomGoods(int number){
        String[] arrItems = new String[number];
        for (int i = 0; i < number; i++) {
            Random rand = new Random();
            int numArr = rand.nextInt(GOODS_LIST.length);
            arrItems[i] = GOODS_LIST[numArr];
        }
        return arrItems;
    }
}
