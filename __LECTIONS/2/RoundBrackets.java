public class RoundBrackets {

    public static void main(String[] args) {
        int result = (2 + 2) * 2;
        System.out.println(result);


        long number = Integer.MAX_VALUE;
        number+=2;
        System.out.println(number);
        final int castedLong = (int) number;
        printInt(castedLong);


        int a = 2, b = 3, c = 4, d = 5;

    }



    static void printInt(int anotherNumber) {
        System.out.println("Переданное число это " + anotherNumber);
    }
}
