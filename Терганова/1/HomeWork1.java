import java.util.Random;

public class HomeWork1  {

public static void main(String[] args) {
    Integer chislo1;
    Integer chislo2;
    Random random = new Random();
    chislo1 = random.nextInt(20);
    chislo2 = random.nextInt(20);

    System.out.println("First number = " + chislo1);
    System.out.println("Second number = " + chislo2);

        if (chislo1 > 10) {
            System.out.println("Chislo1 > 10. It is = " + chislo1);
        } else {
            System.out.println("Chislo1 = " + chislo1 + "It is less then 10");
    }

        if (chislo2%2==0) {
            System.out.println("Chislo2 = " + chislo2 + " It is odd");
        } else {
            System.out.println("Chislo2 = " + chislo2 + " It is not odd");
    }
  }
}

