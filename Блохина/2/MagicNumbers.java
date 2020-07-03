public class MagicNumbers {

    public static void main(String[] args) {
        System.out.println("\nЗадание 1");
        int[] arrayWithMagicNumbers = new int[100];

        for (int i = 0; i < arrayWithMagicNumbers.length; i++) {
            arrayWithMagicNumbers[i] = getRandomNumber(100, -100);
        }

        for (int i = 0; i < arrayWithMagicNumbers.length; i++) {
            if (isMagicNumber(arrayWithMagicNumbers[i])) {
                System.out.println("Число " + arrayWithMagicNumbers[i] + " - магическое!");
            }
        }
    }

    private static boolean isMagicNumber(int number) {
        int number2 = number % 10;
        int number1 = number / 10;
        if(Math.abs(number) > 10) {
            return (Math.abs(number1) == Math.abs(number2));
        } else {
            return false;
        }
    }

    private static int getRandomNumber(int max, int min) {
        return (int) (Math.random() * ((max - min) + 1) + min);
    }

}
