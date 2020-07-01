import java.util.Random;

public class MagicNumbers {

    public static void main(String[] args) {

        int[] nums = new int[100];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++){
            nums[i] = random.nextInt(201) - 100;
        }

        for (int i : nums){
            if (isMagicNumber(i)){
                System.out.printf("Число %d магическое.%n", i);
            }
        }
    }

    private static boolean isMagicNumber(int number) {
        return (number % 11 == 0 && number != 0);
    }
}
