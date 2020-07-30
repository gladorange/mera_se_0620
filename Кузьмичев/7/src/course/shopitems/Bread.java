package course.shopitems;

import org.w3c.dom.ranges.RangeException;

import java.util.Objects;

public class Bread extends FoodItem {
    private Integer weight;

    public Bread(String itemName, Integer price, Integer caloricValue, Integer expirationDate, Integer weight) {
        super(itemName, price, caloricValue, expirationDate);

        if(weight <= 0) {
            throw new RangeException((short) -1, "Bread: Weight less or equals zero.");
        }

        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        if(weight <= 0) {
            throw new RangeException((short) -1, "Bread: Weight less or equals zero.");
        }

        this.weight = weight;
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
        Bread bread = (Bread) o;
        return Objects.equals(weight, bread.weight);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), weight);
    }
}
