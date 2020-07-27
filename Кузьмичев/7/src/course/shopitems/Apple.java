package course.shopitems;

import java.util.Objects;

public class Apple extends FoodItem {
    private AppleColors color;

    public Apple(String itemName, Integer price, Integer caloricValue, Integer expirationDate, AppleColors color) {
        super(itemName, price, caloricValue, expirationDate);
        this.color = color;
    }

    public AppleColors getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getItemName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apple apple = (Apple) o;
        return Objects.equals(color, apple.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), color);
    }
}
