import java.util.Collection;
import java.util.Iterator;

public class ElectronicAddictedVisitor implements ShopVisitor {

    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        System.out.println("Электронные товары в магазине:");
        Integer maxPowerConsumption = null;
        for (ShopItem item : shop) {
            if (item instanceof ElectronicItem) {
                System.out.println(item.getTypeName() + " " + item.getName());
                if (maxPowerConsumption == null || maxPowerConsumption < ((ElectronicItem) item).getPowerConsumption()) {
                    maxPowerConsumption = ((ElectronicItem) item).getPowerConsumption();
                }
            }
        }
        if (maxPowerConsumption == null) {
            return;
        }

        for (Iterator<ShopItem> iterator = ((Collection<ShopItem>) shop).iterator(); iterator.hasNext(); ) {
            ShopItem item = iterator.next();
            if (item instanceof ElectronicItem) {
                if (maxPowerConsumption.equals(((ElectronicItem) item).getPowerConsumption())) {
                    System.out.println(item.getTypeName() + " " + item.getName() + " куплен по цене " + item.getPrice());
                    iterator.remove();
                    break;
                }
            }
        }
    }
}
