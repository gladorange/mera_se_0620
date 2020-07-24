import java.util.Random;

public class HomeWork22 {

    /**
    * Влечение противоположностей
    *        -Создайте массив на 10 элементов
    *        -Заполните его случайными числами из всего диапазона int'a
    *       -Выведите все элементы массива на экран
    *        Теперь преобразуйте массив:
    *        Проверьте все  "соседние" элементы массива (начинайте с 0 индекса и до самого конца).
    *        Если элементы разных знаков - то заменить оба элемента их суммой и начните проверку заново для всех элементов.
    *        Если одно из чисел 0 - то ничего не делайте.
    *        Выведите получившийся массив на экран.
    */

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt();
            System.out.print(array[i] + " ");
        }
        System.out.println();
        //Массив из 10 элементов создан

        boolean check = false;
           while(!check){
            for (int i = 0; i < array.length - 1; i++) {
                if ((array[i] < 0) && (array[i + 1] > 0) ||
                        (array[i] > 0) && (array[i + 1] < 0)) {
                    int summa = array[i] + array[i + 1];
                    array[i] = summa;
                    array[i + 1] = summa;
                    break;
                }

                if (i == array.length-2){
                    check = true;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}