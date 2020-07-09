import java.util.Random;

/**
 * Магия чисел.
 *Создайте массив целых чисел на 100 элементов.
 *Заполните их случайными числами от - 100 до 100.
 *Создайте функцию boolean isMagicNumber(int number)
 *Функция возвращает true, если число "магическое" - состоит из одинаковых цифр (например 22, или -33)
 *Используя цикл for, проверьте каждое число в массиве, является ли оно "магическим".
 *Если число "магическое" - выведите на экран надпись "Число <число> - магическое!"
 *
 */
public class HomeWork21{

    public static void main(String[] args){
        System.out.println("Создаем массив целых чисел на 100 элементов");
        Random random = new Random();
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = random.nextInt(201) - 100;
        }
        //проверяем каждое число в массиве, является ли оно "магическим".
        for (int i = 0; i < 100; i++) {
            if (isMagicNumber(array[i]))
                System.out.println("Число "+array[i]+" - магическое!");
        }
    }

    private static boolean isMagicNumber(int number){
        return  (number != 0)  && (number / 10 == number % 10);
    }
}