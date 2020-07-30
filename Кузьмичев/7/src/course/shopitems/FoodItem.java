package course.shopitems;

import org.w3c.dom.ranges.RangeException;

import java.util.Objects;

public abstract class FoodItem extends ShopItem {
    private Integer caloricValue;
    private Integer expirationDate;

    public FoodItem(String itemName, Integer price, Integer caloricValue, Integer expirationDate) {
        super(itemName, price);

        if(caloricValue <= 0) {
            throw new RangeException((short) -1, "Food item caloric value less or equals zero");
        }

        this.caloricValue = caloricValue;

        if(expirationDate <= 0) {
            throw new RangeException((short) -1, "Food item expiration date less or equals zero");
        }

        this.expirationDate = expirationDate;
    }

    public Integer getCaloricValue() {
        return caloricValue;
    }

    public Integer getExpirationDate() {
        return expirationDate;
    }

    @Override
    abstract public String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoodItem foodItem = (FoodItem) o;
        return Objects.equals(caloricValue, foodItem.caloricValue) &&
                Objects.equals(expirationDate, foodItem.expirationDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), caloricValue, expirationDate);
    }
}
