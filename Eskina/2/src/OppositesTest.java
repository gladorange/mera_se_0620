import javax.naming.PartialResultException;
import java.util.Arrays;
import java.util.Random;

/*
The program creates an array with 10 random integer elements.
If neighboring elements have opposite signs, they are replaced with sum of them
and the check starts again from the beginning of the array.
**/

public class OppositesTest {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt();
            System.out.printf("%d - [%d]\n", i, array[i]);
        }
        boolean isOppositeFound;
        do {
            isOppositeFound = findOpposites(array);
        } while (isOppositeFound);

        System.out.println(Arrays.toString(array));
    }

    public static boolean findOpposites(int[] array) {
        for (int i = 0; i < (array.length - 1); i++) {
            if ((array[i] != 0) && (array[i + 1] != 0)) {
                if ((array[i] > 0) ^ (array[i + 1] > 0)) {
                    int sum = array[i] + array[i + 1];
                    array[i] = sum;
                    array[i + 1] = sum;
                    return true;
                }
            }
        }
        return false;
    }
}
