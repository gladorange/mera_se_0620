public class Blocks {

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            int variable = i * i;

            if (variable % 2 == 0) {
                System.out.println("Проверяю на четность:");
                System.out.println(variable + " четное!");
            }


            System.out.println(variable);
        }

        long variable = 100500;
        System.out.println(variable);
    }
}
