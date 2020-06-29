import java.util.Random;

public class HelloRandom{

    public static void main(String[] args) {
        Integer i1;
        Integer i2;
        Random rand = new Random();
        i1 = rand.nextInt(20);
        i2 = rand.nextInt(20);

        System.out.println("Числа: " + i1 + ", "+ i2);
        if ( i1 > 10 )
            System.out.println("Первое число больше десяти");
        if ( i2 % 2 == 0 )
            System.out.println("Второе число четное");
        else
            System.out.println("Второе число нечетное");

    }
}