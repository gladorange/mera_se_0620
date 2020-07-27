import javax.annotation.processing.SupportedSourceVersion;
import javax.naming.PartialResultException;
import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Random;
public class Magic {

    public static void main(String[] args) {

        Magic magic = new Magic();
        Random random = new Random();
        int[] array = new int[100];

        for (int i = 0; i < 100; i++) {

            array[i] = random.nextInt(100 + 100) - 100;
            System.out.println(array[i]);
        }
        for (int i = 0; i < 100; i++) {

            if (magic.isMagicNumber(array[i]) == true && array[i]!=0)
            {
                System.out.println("Число "  + array[i] + " магическое!");

            }
        }
    }
    boolean isMagicNumber(int number) {
        if (number/10 == number%10){
            return true;
        }
        else {
            return false;
        }

    }
}
