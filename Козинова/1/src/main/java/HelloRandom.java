import java.util.Random;

public class HelloRandom {
    public static void main(String[] args) {

    Random rand = new Random();
    Integer var1 = rand.nextInt(20);
    Integer var2 = rand.nextInt(20);
    System.out.println("Первое число: " + var1);
    System.out.println("Второе число: " + var2);

    if(var1 > 10)  {
        System.out.println("Первое число больше десяти");
    }
    if((var2 % 2) == 0){
        System.out.println("Второе число четное");
    }
    else {
        System.out.println("Второе число нечетное");
    }

    }
}
