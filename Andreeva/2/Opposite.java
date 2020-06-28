import java.util.Random;

public class Opposite {
    public static void main(String[] args) {
        int [] ArrayNum;
        ArrayNum = new int[10];
        Random random = new Random();
        for (int i=0; i<ArrayNum.length; i++) {
            ArrayNum[i]=random.nextInt();
                System.out.println(ArrayNum[i]);
            }
        for (int i=0;i<ArrayNum.length;i++) {
            for (i = 0; i < ArrayNum.length - 1; i++) {
                if (((ArrayNum[i] < 0) && (ArrayNum[i + 1] > 0)) ^ ((ArrayNum[i] > 0) && (ArrayNum[i + 1] < 0))) {
                    ArrayNum[i] += ArrayNum[i + 1];
                    ArrayNum[i + 1] = ArrayNum[i];
                    break;
                }
            }

        }
        System.out.println("Преобразованный массив");
        for (int i=0; i<ArrayNum.length; i++) {
            System.out.println(ArrayNum[i]);
        }

}}

