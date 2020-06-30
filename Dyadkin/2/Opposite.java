import java.util.Random;
import java.util.Arrays;

public class Opposite {
    public static void main(String[] args) {
        int[] numbersArray;
        numbersArray = new int[10];
        Random random = new Random();
        System.out.println("Рандомный массив:");
        for (int i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = random.nextInt();
            System.out.println(numbersArray[i]);
        }
        for (int i = 0; i < numbersArray.length; i++) {
            for (i = 0; i < numbersArray.length - 1; i++) {
                if (((numbersArray[i] < 0) && (numbersArray[i + 1] > 0)) || ((numbersArray[i] > 0) && (numbersArray[i + 1] < 0))) {
                    numbersArray[i] += numbersArray[i + 1];
                    numbersArray[i + 1] = numbersArray[i];
                    break;
                }
            }

        }
        System.out.println("Измененный массив: ");
        for (int i = 0; i < numbersArray.length; i++) {
            System.out.println(numbersArray[i]);
        }
    }
}