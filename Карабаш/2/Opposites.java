import java.util.Random;

public class Opposites {
            /*Влечение противоположностей
            -Создайте массив на 10 элементов
            -Заполните его случайными числами из всего диапазона int'a
            -Выведите все элементы массива на экран

            Теперь преобразуйте массив:
            Проверьте все  "соседние" элементы массива (начинайте с 0 индекса и до самого конца).
            Если элементы разных знаков - то заменить оба элемента их суммой и начните проверку заново для всех элементов.
            Если одно из чисел 0 - то ничего не делайте.
            Выведите получившийся массив на экран.*/

    public static void main(String[] args) {
        int[] arrayNum = new int[10];
        Random rnd = new Random();
        for (int i = 0; i < arrayNum.length; i++) {
            arrayNum[i] = rnd.nextInt();
            System.out.print(arrayNum[i] + " ");
        }
        System.out.println();
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < arrayNum.length - 1; i++) {
                if ((arrayNum[i] < 0) && (arrayNum[i + 1] > 0) ||
                    (arrayNum[i] > 0) && (arrayNum[i + 1] < 0)) {
                    changed = true;
                    int sum = arrayNum[i] + arrayNum[i + 1];
                    arrayNum[i] = sum;
                    arrayNum[i + 1] = sum;
                    break;
                }
            }
        } while (changed);
        for (int i = 0; i < arrayNum.length; i++) {
            System.out.print(arrayNum[i] + " ");
        }
        System.out.println();
    }
}
