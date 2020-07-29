package course.shopitems;

import org.w3c.dom.ranges.RangeException;

import java.util.Objects;

public class TV extends ElectronicItem {
    private Integer volume;

    public TV(String itemName, Integer price, Integer power, Integer volume) {
        super(itemName, price, power);

        if(volume <= 0) {
            throw new RangeException((short) -1, "TV volume less or equals zero");
        }

        this.volume = volume;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
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
        TV tv = (TV) o;
        return Objects.equals(volume, tv.volume);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), volume);
    }
}
