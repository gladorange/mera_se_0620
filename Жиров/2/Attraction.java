import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Random;

public class Attraction {


    public static void main(String[] args) {


        Random random = new Random();
        long array[] = new long[10];
        for (int i = 0; i < 10; i++) {
            long leftLimit = -2147483648L;
            long rightLimit = 2147483647L;
            array[i] = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        }
        System.out.println(" Start array");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
        int j = 0;
        while (j < array.length - 1) {
            if (array[j] * array[j + 1] < 0) {                 // проверка на знаки
                if (array[j] != 0 && array[j + 1] != 0) {     // проверка на 0(не должен быть равен 0)
                    long k = array[j];
                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = k + array[j + 1];
                    j = 0;
                } else {
                    j++;
                }
            } else {
                j++;
            }
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Resulting array");

        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }

    }
}