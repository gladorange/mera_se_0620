public class Expressions {


    public static void main(String[] args) {
        int a = 42;

        int b;
        b = 42;

        final int previousValue = ++a;
        System.out.println(previousValue);
        System.out.println(b*=2);


        boolean booleanValue = true;
        //booleanValue |= false;
        booleanValue = booleanValue | false;
        System.out.println(booleanValue);
       // booleanValue &= false;
        booleanValue = booleanValue & false;
        System.out.println(booleanValue);

        System.out.println(a);
        System.out.println(b);




    }
}
