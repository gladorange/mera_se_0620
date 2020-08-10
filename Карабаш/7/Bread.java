public class Bread extends FoodItem {
    private Integer weight;

    public Bread(String name, Integer price, Integer caloricContent, Integer daysToExpire, Integer weight) {
        super(name, price, caloricContent, daysToExpire);
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getTypeName() {
        return "хлеб";
    }
}
