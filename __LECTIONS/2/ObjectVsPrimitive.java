public class ObjectVsPrimitive {


    public static void main(String[] args) {


        measurePrimitives();
        measureObjectType();


        //Integer obj = 4;
        Integer obj = new Integer(4);
    }

    private static void measurePrimitives() {
        final long start = System.currentTimeMillis();

        int[] array = new int[10_000_000];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        System.out.println(System.currentTimeMillis() - start);
    }

    private static void measureObjectType() {
        final long start = System.currentTimeMillis();

        Integer[] array = new Integer[10_000_000];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        System.out.println(System.currentTimeMillis() - start);
    }
}
