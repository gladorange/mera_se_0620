import java.util.Random;

public class FixPriceShop {
    String[] items;
    int price;
    int happyHour = new Random().nextInt(23);


    public FixPriceShop(Integer price, String ... items){
        this.items = items;
        this.price = price;
    }
    public String[] getItems(){

        return this.items;
    }
    public Integer getPrice(){

        return this.price;
    }

    public int checkItemPrice(String item, Integer hour){
        boolean isGoodExist = false;

        for(String i: items)
        {
            if (i.equals(item)) {
                isGoodExist = true;
                break;
            }
        }
        if (hour.equals(happyHour)){
            return (int)(getPrice() * 0.5);
        }
        else {
            return getPrice();
        }

    }

}