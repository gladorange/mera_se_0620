import java.util.Random;

public class HelloRandom {

    public static void main(String[] args) {
        Integer randomValueOne = new Random().nextInt(20);
        Integer randomValueTwo = new Random().nextInt(20);

        System.out.format("Первое число %d, второе число %d\n", randomValueOne, randomValueTwo);

        if (randomValueOne > 10)
            System.out.println("Первое число больше 10.");

        System.out.println("Второе число " + (randomValueTwo % 2 == 0 ? "четное." : "нечетное."));
    }
}
