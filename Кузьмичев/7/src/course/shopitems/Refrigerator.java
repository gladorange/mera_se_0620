package course.shopitems;

import org.w3c.dom.ranges.RangeException;

import java.util.Objects;

public class Refrigerator extends ElectronicItem {
    private Integer freezerVolume;

    public Refrigerator(String itemName, Integer price, Integer power, Integer freezerVolume) {
        super(itemName, price, power);

        if(freezerVolume < 0) {
            throw new RangeException((short) -1, "Refrigerator freezer volume less or equals zero");
        }

        this.freezerVolume = freezerVolume;
    }

    public Integer getFreexerVolume() {
        return freezerVolume;
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
        Refrigerator that = (Refrigerator) o;
        return Objects.equals(freezerVolume, that.freezerVolume);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), freezerVolume);
    }
}
