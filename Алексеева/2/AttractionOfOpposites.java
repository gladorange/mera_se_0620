import java.util.Random;

public class AttractionOfOpposites {
    static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.printf("%11d  ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // int[] arr = {1, 2, 3, 4, 5, -7, 2};  // for debugging

        Random random = new Random();
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }


        printArray(arr);


        int arrLength = arr.length;
        int i = 0;
        int sum = 0;
        while (i != arrLength - 1) {
            if ((arr[i] > 0 && arr[i + 1] < 0) || (arr[i] < 0 && arr[i + 1] > 0)) {
                sum = arr[i] + arr[i + 1];
                arr[i] = sum;
                arr[i + 1] = sum;

                // System.out.println(i + " and " + (i+1));  // for debugging - numbers under indexes i and i+1 of different characters

                printArray(arr);

                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
    }
}


