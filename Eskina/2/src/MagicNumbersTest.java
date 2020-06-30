import java.util.Arrays;
import java.util.Random;

/*The program creates an array with random integers from -100 to 100
and checks if the number is magic: when the number of tens and units is the same.
In case if it's true, it prints the message on the screen.
**/

public class MagicNumbersTest {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[100];
        //fill array with random numbers in range -100 - 100(including bounds)
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(201) - 100;
            if (isMagicNumber(array[i])) {
                System.out.printf("Число [%d] - магическое!\n", array[i]);
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static boolean isMagicNumber(int number) {
        return ((number % 10) == (number / 10));
    }
}
