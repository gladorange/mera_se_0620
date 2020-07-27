import java.util.Random;

public class Operations {

    public static void main(String[] args) {
        Random random = new Random ();
        int numb1 = random.nextInt(20);
        int numb2 = random.nextInt(20);
        System.out.println(numb1);
        System.out.println(numb2);

        if (numb1 > 10){
            System.out.println("Первое число > 10");
        }
        if ((numb2%2) ==0){
            System.out.println("Второе число четное");
        }
        else {
            System.out.println("Второе число нечетное");
        }
    }
}
