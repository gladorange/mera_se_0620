import java.util.Random;

public class Task1 {
    public static void main(String[] args) {

        Random rand = new Random();

        Integer num1 = rand.nextInt(20);
        Integer num2 = rand.nextInt(20);

        System.out.println(num1);
        System.out.println(num2);

        if (num1 > 10)
            System.out.println("The first number greater 10");

        if ((num2 % 2) == 0)
            System.out.println("The second number is even");
        else
            System.out.println("The second number is odd");
    }
}