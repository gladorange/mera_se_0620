import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
       System.out.println("Subtask: Magic of numbers");
       subTask1();
       System.out.println("Subtask: The opposites attraction");
       subTask2();
    }

    private static void subTask1() {
        int[] arrayNums = new int[100];

        //Initial array filling by random numbers
        for (int i = 0; i < arrayNums.length; i++) {

            arrayNums[i] = new Random().nextInt(100);

            if (!(new Random().nextBoolean())) {
                arrayNums[i] *= -1;
            }
        }

        //Searching for "magic" numbers and printing
        for (int i : arrayNums) {
            if (isMagicNumber(i)) {
                System.out.println("Number " + i + " is magic!");
            }
        }
    }

    //"Magic" numbers defenition
    private static boolean isMagicNumber(int number) {
        return (number % 11) == 0;
    }

    private static void subTask2() {
        int[] arrayNums = new int[10];

        //Initial array filling by random numbers and printing
        System.out.println("Initial array: ");
        for (int i = 0; i < arrayNums.length; i++) {

            arrayNums[i] = new Random().nextInt(Integer.MAX_VALUE);

            if (!(new Random().nextBoolean())) {
                arrayNums[i] *= -1;
            }

            System.out.println(arrayNums[i]);
        }

        // Array tranformation according to task
        for (int i = 0; i < arrayNums.length - 1; i++) {
            if (((arrayNums[i] < 0) && (arrayNums[i + 1] > 0) ||
                    (arrayNums[i] > 0) && (arrayNums[i + 1] < 0))) {
                // Warning: the next line may cause an integer overflow
                arrayNums[i] = arrayNums[i + 1] += arrayNums[i];

                i = -1;
            }
        }

        System.out.println("Transformed array: ");

        for (int i : arrayNums) {
            System.out.println(i);
        }
    }
}