import java.util.Random;

class magic {
    public static void main(String[] arguments) {
        int [] ArrayOfMagic;
        ArrayOfMagic = new int[100];
        Random random = new Random();
        for (int i=0; i<ArrayOfMagic.length; i=i+1) {
            ArrayOfMagic[i]=-100+random.nextInt(200+1);
            if (isMagicNumber (ArrayOfMagic[i])) {
                System.out.println("число "+ArrayOfMagic[i]+" -магическое");
            }
        }
    }

    public static boolean isMagicNumber (int number){
        return ((number/10)==(number%10));
            }
}