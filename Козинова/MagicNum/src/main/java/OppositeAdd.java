import java.util.Random;

public class OppositeAdd {


    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[10];
        System.out.println("Исходный массив: ");
        for (int i = 0; i < 10; i++) {
            array[i] = rand.nextInt();
            System.out.print(array[i] + ",");
        }

        int j = 0;
        while (j < (array.length - 1)){
            long mult = (long)array[j] * (long)array[j+1];
            if(mult<0) {
                int sumArr = array[j] + array[j+1];
                array[j] = sumArr;
                array[j+1] = sumArr;
                j = 0;
            }
            else {
                j++;
            }
        }
        System.out.println("\nМассив после преобразования: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
