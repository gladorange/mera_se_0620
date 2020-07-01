import java.util.Random;

public class Opposite {
    public static void main(String[] args) {
        int [] arrayNum;
        arrayNum = new int[10];
        Random random = new Random();
        for (int i=0; i<arrayNum.length; i++) {
            arrayNum[i]=random.nextInt();
                System.out.println(arrayNum[i]);
            }
        for (int i=0;i<arrayNum.length;i++) {
            for (i = 0; i < arrayNum.length - 1; i++) {
                if (((arrayNum[i] < 0) && (arrayNum[i + 1] > 0)) || ((arrayNum[i] > 0) && (arrayNum[i + 1] < 0))) {
                    arrayNum[i] += arrayNum[i + 1];
                    arrayNum[i + 1] = arrayNum[i];
                    break;
                }
            }

        }
        System.out.println("Преобразованный массив");
        for (int i=0; i<arrayNum.length; i++) {
            System.out.println(arrayNum[i]);
        }

}}

