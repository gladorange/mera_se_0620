import java.util.Random;

public class MagicNum{

    static boolean isMagicNumber(int number){
        if (number != 0) {
            int res10 = number / 10;
            int res1 = number % 10;

            return (res10 == res1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        Random rand = new Random();
        int[] arrayOfInt = new int[100];

        for (int i = 0; i < 100; i++) {
            arrayOfInt[i] = 100 - rand.nextInt(201);
            //System.out.println(arrayOfInt[i]);
            if(isMagicNumber(arrayOfInt[i]))
            {
                System.out.println("Число " +arrayOfInt[i] + " магическое!");
            }
        }
    }
}
