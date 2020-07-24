public class SystemVariables {

    public static void main(String[] args) {


        System.out.println(System.getProperty("myProperty"));

        final Integer myInt = Integer.getInteger("myInt");
        System.out.println(myInt);

    }
}
