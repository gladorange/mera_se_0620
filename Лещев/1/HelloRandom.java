import java.util.Random;

public class HelloRandom {

    public static void main(String[] arguments) {
        Random random = new Random();
        Integer firstInt = random.nextInt(20);
        Integer secondInt = random.nextInt(20);
        System.out.println(firstInt + " " + secondInt);
        if(firstInt > 10) {
            System.out.println("Первое число больше десяти");
        }
        System.out.print("Второе число ");
        if(secondInt % 2 == 0) {
            System.out.println("четное");
        }
        else {
            System.out.println("нечетное");
        }
    }
}
