public class Methods {


    public static void main(String[] args) {


        int var1 = 4;
        int var2 = 40;

        System.out.println(sum(4,40));


        sumAndPrint(2,3);

        divideAndPrint(2,2);
        divideAndPrint(2,0);
    }


    public static  int sum(int one, int another) {
        final int result = one + another;
        return result;
    }


    public static void sumAndPrint(int one, int another)  {
        System.out.println(one + another);
    }

    public static void divideAndPrint(int one, int another)  {
        if (another == 0) {
            System.out.println("на ноль делить нельзя");
            return;
        }

        System.out.println(one + another);
    }
}


