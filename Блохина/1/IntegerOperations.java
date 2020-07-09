import java.util.Random;

public class IntegerOperations {
    public static void main (String[] args) {
        int firstInt;
        int secondInt;

        Random random = new Random();
        firstInt = random.nextInt(100);
        secondInt = random.nextInt(100);

        System.out.println(firstInt);
        System.out.println(secondInt);

        if (firstInt > 10) {
            System.out.println("Первое число больше десяти");
        }

        if (secondInt % 2 == 0) {
            System.out.println("Второе число четное");
        } else {
            System.out.println("Второе число нечетное");
        }
    }
}
