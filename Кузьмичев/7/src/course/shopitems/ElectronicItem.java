package course.shopitems;

import org.w3c.dom.ranges.RangeException;

import java.util.Objects;

public abstract class ElectronicItem extends ShopItem{
    private Integer power;

    public ElectronicItem(String itemName, Integer price, Integer power) {
        super(itemName, price);

        if(power <= 0) {
            throw new RangeException((short) -1, "Electronic item power less or equals zero");
        }

        this.power = power;
    }

    public Integer getPower() {
        return power;
    }

    @Override
    abstract public String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectronicItem that = (ElectronicItem) o;
        return Objects.equals(power, that.power);
    }

    @Override
    public int hashCode() {

        return Objects.hash(power);
    }
}
