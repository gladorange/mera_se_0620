public abstract class FoodItem extends ShopItem {

    private Integer caloricContent;
    private Integer daysToExpire;

    public FoodItem(String name, Integer price, Integer caloricContent, Integer daysToExpire) {
        super(name, price);
        this.caloricContent = caloricContent;
        this.daysToExpire = daysToExpire;
    }

    public Integer getCaloricContent() {
        return caloricContent;
    }

    public void setCaloricContent(Integer caloricContent) {
        this.caloricContent = caloricContent;
    }

    public Integer getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(Integer daysToExpire) {
        this.daysToExpire = daysToExpire;
    }
}
