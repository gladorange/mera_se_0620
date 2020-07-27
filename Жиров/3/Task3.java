import java.util.Random;

public class Task3 {

    static int happyHour = (int) (Math.random() * (23));
    public static void main(String[] args) {
        Random random=new Random();
        String items[]={"milk","curd","cheese","sour cream"};
        String items1[]={"apple","orange","blackberry","cherry"};
        String items2[]={"table","chair","bed","armchair"};

        int hour=random.nextInt(23);
        int hour1=random.nextInt(23);
        int hour2=random.nextInt(23);

        int price=random.nextInt(99-50+1)+50;
        int price1=random.nextInt(99-50+1)+50;
        int price2=random.nextInt(99-50+1)+50;

        FixPriceShop fixPriceShop=new FixPriceShop(items,price);
        FixPriceShop fixPriceShop1=new FixPriceShop(items1,price1);
        FixPriceShop fixPriceShop2=new FixPriceShop(items2,price2);

        System.out.println("happyHour: "+ happyHour);
        System.out.println("----------------------------------");
        System.out.println(" ");
        System.out.println("randomHour: "+ hour);
        System.out.println("price: "+ price);
        for(String item:fixPriceShop.getItems()){
            System.out.print(item+ "  ");
        }
        System.out.println("");
        String randomItems = (items[new Random().nextInt(items.length)]);
        System.out.println(fixPriceShop.checkItemPrice(randomItems,hour));

        System.out.println("----------------------------------");
        System.out.println("randomHour: "+ hour1);
        System.out.println("price: "+ price1);
        for(String item:fixPriceShop1.getItems()){
            System.out.print(item+ "  ");
        }
        System.out.println("");
        String randomItems1 = (items1[new Random().nextInt(items1.length)]);
        System.out.println(fixPriceShop1.checkItemPrice(randomItems1,hour1));

        System.out.println("----------------------------------");
        System.out.println("randomHour: "+ hour2);
        System.out.println("price: "+ price2);
        for(String item:fixPriceShop2.getItems()){
            System.out.print(item+ "  ");
        }
        System.out.println("");
        String randomItems2 = (items2[new Random().nextInt(items2.length)]);
        System.out.println(fixPriceShop2.checkItemPrice(randomItems2,hour2));



    }
}