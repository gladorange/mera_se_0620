import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class NumbersMagic {
    /* Магия чисел.
    Создайте массив целых чисел на 100 элементов.
    Заполните их случайными числами от - 100 до 100.
    Создайте функцию boolean isMagicNumber(int number)
    Функция возвращает true, если число "магическое" - состоит из одинаковых цифр (например 22, или -33)
    Используя цикл for, проверьте каждое число в массиве, является ли оно "магическим".
    Если число "магическое" - выведите на экран надпись "Число <число> - магическое!"
    */

    public static void main(String[] args) {
        int[] arrayNum = new int[100];
        Random rnd = new Random();
        for (int i = 0; i < arrayNum.length; i++) {
            arrayNum[i] = -100 + rnd.nextInt(201);
        }
        for (int i = 0; i < arrayNum.length; i++) {
            if (isMagicNumber(arrayNum[i]))
                System.out.println("Число "+arrayNum[i]+" - магическое!");
        }
    }

    public static boolean isMagicNumber(int number){
        return (number != 0) && (number / 10 == number % 10);
    }

}
