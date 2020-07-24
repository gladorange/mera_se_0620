import java.util.Arrays;
import java.util.Random;

public class Antipodes {

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(10);
        System.out.println("Intial array: " + Arrays.toString(randomArray));

        for (int i = 1; i < randomArray.length; i++) {
            if(randomArray[i] != 0 && randomArray[i-1] != 0) {
                if( (randomArray[i] > 0 && randomArray[i-1] < 0)
                    || (randomArray[i] < 0 && randomArray[i - 1] > 0) )
                {
                    int sum = randomArray[i] + randomArray[i - 1];
                    randomArray[i] = sum;
                    randomArray[i - 1] = sum;
                    //start from the beginning
                    i = 0;
                }
            }
        }
        System.out.println("Result array: " + Arrays.toString(randomArray));
    }

    private static final Random random = new Random();
}
