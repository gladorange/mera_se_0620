import javax.swing.*;
import java.util.Random;


class HelloRandom {
    public static void main(String[] arguments) {
        Random random = new Random();
        int varible1 = random.nextInt(20+1);
        int varible2 = random.nextInt(20+1);
        System.out.println(varible1);
        System.out.println(varible2);
        if (varible1 > 10) {
            System.out.println("первое число больше 10");
        }
        if ((varible2%2)  == 0) {
            System.out.println("второе число четное");
        }
        else {
            System.out.println("второе число нечетное");
        }

    }


}