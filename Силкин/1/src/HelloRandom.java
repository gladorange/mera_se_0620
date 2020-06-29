import java.util.Random;

public class HelloRandom {

    public static void main(String[] args) {

        Random rand = new Random();

        Integer first = rand.nextInt(20);
        Integer second = rand.nextInt(20);

        System.out.println("Первое число" + " " + first  );
        System.out.println("Второе число" + " " + second  );

        if(first > 10) System.out.println("Первое число больше десяти");

        if(second % 2 == 0){
            System.out.println("Второе число четное");

        }else{
            System.out.println("Второе число нечетное");
        }

    }

}