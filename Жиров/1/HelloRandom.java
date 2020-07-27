import java.awt.desktop.AboutEvent;
import java.util.Random;

public class HelloRandom {
    public static void main(String[] args) {

       Random random = new Random();

       Integer x = random.nextInt(20);
       Integer y = random.nextInt(20);

            System.out.println("перове число = " + x);
            System.out.println("второе число = " + y);

            if (x > 10) {
                System.out.println("Первое число больше 10");
            }
            if (y % 2 == 0) {
                System.out.println("Второе число четное");
            }
            else
            {
                System.out.println("Второе число нечетное");
            }
    }
}
