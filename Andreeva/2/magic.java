import java.util.Random;

class magic {
    public static void main(String[] arguments) {
        int [] arrayOfMagic;
        arrayOfMagic = new int[100];
        Random random = new Random();
        for (int i=0; i<arrayOfMagic.length; i=i+1) {
            arrayOfMagic[i]=-100+random.nextInt(200+1);
            if (isMagicNumber (arrayOfMagic[i])) {
                System.out.println("число "+arrayOfMagic[i]+" -магическое");
            }
        }
    }

    public static boolean isMagicNumber (int number){
        return ((number/10)==(number%10));
            }
}