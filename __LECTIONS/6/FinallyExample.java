public class FinallyExample {


    public static void main(String[] args) {
        System.out.println(getInt());
    }

    private static int getInt() {
        try {
            return divideByZero();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally блок выполняется всегда");
            throw new RuntimeException("Привет!");
        }
    }

    private static int divideByZero() {
        return 2 / 1;
    }
}
