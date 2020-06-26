import java.util.Random;
public class HelloRandomTest {
    public static void main(String[] args) {
        Random rand = new Random();
        Integer num1 = rand.nextInt(21);
        Integer num2 = rand.nextInt(21);

        System.out.println("Первое число: " + num1);
        System.out.println("Второе число: " + num2);

        if (num1 > 10) {
            System.out.println("Первое число больше 10.");
        }

        if ((num2 % 2) == 0) {
            System.out.println("Второе число четное.");
        } else {
            System.out.println("Второе число нечетное.");
        }
    }
}
