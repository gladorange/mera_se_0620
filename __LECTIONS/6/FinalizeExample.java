import java.util.concurrent.ThreadLocalRandom;

public class FinalizeExample {


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Объект собрался");
    }


    public static void main(String[] args) {
        new FinalizeExample();
        System.gc();


        System.out.println(ThreadLocalRandom.current().nextInt(100, 101));
    }
}
