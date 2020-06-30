import java.util.Random;
import java.util.Arrays;

public class MagicNumbs {

    public static void main(String[] arguments) {
        Random random = new Random();
        int[] magicArray = new int[100];

        for (int i = 0; i < magicArray.length; i++){
            magicArray[i] = random.nextInt(201) - 100;
            if (CheckMagicNumber(magicArray[i])){
                System.out.printf("Число %d магическое!" + " ", magicArray[i]);

            }
        }
        System.out.printf(Arrays.toString(magicArray));
    }
    public static boolean CheckMagicNumber(int number){
        return ((number%10)==(number/10) && (number!=0));
    }
}