import java.util.Random;

public class MagicOfNumbers {

    static boolean isMagicNumber(int number) {
        return (number != 0 && number % 11 == 0);
    }

    public static void main(String[] args) {

        //int[] arr = {2, 33, 44, -22, 17, 91, 0, 6, 7, 88, -88, 21};  // for debugging


        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(201) - 100;  // get the numbers from -100 to 100
        }

        // print array:
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();


        for (int i : arr) {
            if (isMagicNumber(i)) {
                System.out.print("Число " + i + " магическое!");
                System.out.println();
            }
        }
    }

}
