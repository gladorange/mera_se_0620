import java.util.Random;

public class HappyHours {
    public static void main(String[] args) {
        Random rand = new Random();

        String[] dnsGoods = new String[rand.nextInt(20) + 1];
        for (int i = 0; i < dnsGoods.length; i++) {
            dnsGoods[i]= "good_#"+(i+1);
        }
        FixPriceShop dnsShop = new FixPriceShop(rand.nextInt(50) + 50, dnsGoods);
        System.out.println("DNS Shop created: price: " + dnsShop.getPrice() +", num goods: "+ dnsShop.getItems().length);

        String[] obiGoods = new String[rand.nextInt(10) + 1];
        for (int i = 0; i < obiGoods.length; i++) {
            obiGoods[i]= "good_#"+(i+1);
        }
        FixPriceShop obiShop = new FixPriceShop(rand.nextInt(50) + 50, obiGoods);
        System.out.println("OBI Shop created: price: " + obiShop.getPrice() +", num goods: "+ obiShop.getItems().length);

        String[] okeyGoods = new String[rand.nextInt(15) + 1];
        for (int i = 0; i < okeyGoods.length; i++) {
            okeyGoods[i]= "good_#"+(i+1);
        }
        FixPriceShop okeyShop = new FixPriceShop(rand.nextInt(50) + 50, okeyGoods);
        System.out.println("OKey Shop created: price: " + okeyShop.getPrice() +", num goods: "+ okeyShop.getItems().length);

        String randomDnsGood = "good_#" + rand.nextInt(dnsShop.getItems().length +1); //+1 to simulate wrong request
        int randomTime = rand.nextInt(24);
        System.out.println("Random good '"+randomDnsGood+"' in DNS shop in the time "+randomTime+" costs: "+dnsShop.checkItemPrice(randomDnsGood,randomTime));

        String randomObiGood = "good_#" + rand.nextInt(obiShop.getItems().length +1);
        randomTime = rand.nextInt(24);
        System.out.println("Random good '"+randomObiGood+"' in OBI shop in the time "+randomTime+" costs: "+obiShop.checkItemPrice(randomObiGood,randomTime));

        String randomOkeyGood = "good_#" + rand.nextInt(okeyShop.getItems().length +1);
        randomTime = rand.nextInt(24);
        System.out.println("Random good '"+randomOkeyGood+"' in Okey shop in the time "+randomTime+" costs: "+okeyShop.checkItemPrice(randomOkeyGood,randomTime));

    }
}
