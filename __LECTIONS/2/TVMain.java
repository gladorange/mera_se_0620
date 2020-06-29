public class TVMain {


    public static void main(String[] args) {
        TV firstTV = new TV();
        System.out.println(firstTV.isTurnedOn());

        firstTV.setTurnedOn(true);
        System.out.println(firstTV.isTurnedOn());

        TV secondTV = new TV();
        System.out.println(secondTV.isTurnedOn());


        System.out.println(firstTV.getModel());
        TV.setModel("JVC");
        System.out.println(firstTV.getModel());
        System.out.println(secondTV.getModel());



    }
}
