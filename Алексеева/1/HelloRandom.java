import java.util.Random;

public class HelloRandom {


    public static void main(String[] args) {

        Integer firstNumber = new Random().nextInt(21);
        Integer secondNumber = new Random().nextInt(21);

        System.out.println("Первое число: " + firstNumber);
        System.out.println("Второе число: " + secondNumber);

        if (firstNumber > 10) {
            System.out.println("Первое число больше 10");
        }

        System.out.println("Второе число " + (secondNumber % 2 == 0 ? "чётное" : "нечётное"));

    }

}
