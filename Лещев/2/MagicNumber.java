import java.util.Random;

public class MagicNumber {

    public static boolean isMagicNumber(int number) {
        number = Math.abs(number);
        if(number < 10) {
            return false;
        }
        int lastDigit = number % 10;
        while (number > 9) {
            number /= 10;
            if((number % 10) != lastDigit) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] randomArray = new int[100];
        /* Initialize random array */
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(200) - 100;
        }
        /* Check array for magic numbers */
        for(int number : randomArray) {
            if(isMagicNumber(number)) {
                System.out.println("Число " + number + " - магическое!");
            }
        }
    }
}
