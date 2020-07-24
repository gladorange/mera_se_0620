public class FixPriceShop {

    private String items[];
    private int price;

    public FixPriceShop(String[] items, int price) {
        this.items = items;
        this.price = price;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public int getPrice(){
        return price;
    }

    public int checkItemPrice(String item, int hour){
        int k=0;
        for(int i=0;i<items.length;i++){
            if(item.equals(items[i])){
                k++;
            }
        }
        if(k==0){
            return -1;
        }
        else{
            if(hour== Task3.happyHour){
                return (int)Math.ceil(getPrice()/2.0);
            }
            else{
                return getPrice();
            }
        }
    }
}