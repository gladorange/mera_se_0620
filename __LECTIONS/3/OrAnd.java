public class OrAnd {


    public static void main(String[] args) {
        boolean var1 = false;


        System.out.println(var1 & checkSomeVar());
        System.out.println(!var1);
    }

    private static boolean checkSomeVar() {
        System.out.println("Возвращаю ложь");
        return false;
    }
}
