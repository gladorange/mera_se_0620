public class BreakAndContinue {

    public static void main(String[] args) {


        int[] array = {1, 2, 3, 4, 5,6,7,8,9};

/*
        for (int i : array) {
            if (i == 3) {
                break;
            }

            System.out.println(i);
        }*/

        outer:
        for (int j : array) {
            for (int i : array) {
                if (j == 3) {
                    continue outer;
                }

                System.out.println(j + "" + i);
            }
        }



    }
}
