import java.util.Random;

public class ModifyArray {
    public static void main(String[] args) {
        System.out.println("\nЗадание 2");
        int[] arrayForModify = new int[10];

        Random random = new Random();
        for (int i = 0; i < arrayForModify.length; i++) {
            arrayForModify[i] = random.nextInt();
        }

        System.out.println("Исходный массив");
        for (int i = 0; i < arrayForModify.length; i++) {
            System.out.println(arrayForModify[i]);
        }

        int sum = getSum(arrayForModify, false);
        int sumAbs = getSum(arrayForModify, true);

        while(sum != sumAbs) {
            for (int i = 0; i < arrayForModify.length; i++) {
                int newValue = 0;
                if (arrayForModify[i] < 0) {
                    if (i == 0) {
                        newValue = arrayForModify[arrayForModify.length - 1] + arrayForModify[i];
                    } else {
                        newValue = arrayForModify[i] + arrayForModify[i - 1];
                        arrayForModify[i - 1] = newValue;
                    }
                    arrayForModify[i] = newValue;
                    break;
                }
            }
            sum = getSum(arrayForModify, false);
            sumAbs = getSum(arrayForModify, true);
        }

        System.out.println("\nПолученный массив");
        for (int i = 0; i < arrayForModify.length; i++) {
            System.out.println(arrayForModify[i]);
        }
    }

    private static int getSum(int[] arrayForSum, boolean absSum) {
        int sum = 0;
        for (int i = 0; i < arrayForSum.length; i++) {
            if (absSum) {
                sum = sum + Math.abs(arrayForSum[i]);
            } else {
                sum = sum + arrayForSum[i];
            }
        }
        return sum;
    }
}
