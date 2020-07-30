package course.shopitems;

import org.w3c.dom.ranges.RangeException;

import java.util.Objects;

public abstract class ShopItem {
    private String itemName;
    private Integer price;

    public ShopItem(String itemName, Integer price) {
        this.itemName = itemName;

        if(price <= 0) {
            throw new RangeException((short) -1, "Shop item price less or equals zero");
        }

        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    abstract public String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopItem shopItem = (ShopItem) o;
        return Objects.equals(itemName, shopItem.itemName) &&
                Objects.equals(price, shopItem.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemName, price);
    }
}
