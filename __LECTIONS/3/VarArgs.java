public class VarArgs {

    public static void main(String[] args) {
/*

        printSquares(1, 2, 3, 4, 6, 7);
        printSquares(1 );
        printSquares();
        printSquares(new int[] {1,2,3,4});
*/


        printGreeting("Привет", "Андрей", "Вася");
        printGreeting("Hello", "John", "William");
    }


    public  static void printSquares(int ... numbers) {

        if (numbers.length == 0) {
            System.out.println("массив пустой");
        }


        for (int i : numbers) {
            System.out.println(i  * i );
        }


    }
    public  static void printGreeting(String helloMsg, String ... names) {
        for (String name : names) {
            System.out.println(helloMsg + ", " + name);
        }


    }
}
