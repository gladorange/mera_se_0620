public class Apple extends FoodItem {

    private Colors color;
    public static Colors[] allColors = Colors.values();

    public Apple(String name, Integer price, Integer caloricContent, Integer daysToExpire, Colors color) {
        super(name, price, caloricContent, daysToExpire);
        this.color = color;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public String getTypeName() {
        return "яблоко";
    }
}
