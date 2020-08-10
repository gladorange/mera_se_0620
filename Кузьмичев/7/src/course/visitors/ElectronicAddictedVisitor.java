package course.visitors;

import course.shopitems.ElectronicItem;
import course.shopitems.ShopItem;

import java.util.Collection;

public class ElectronicAddictedVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        if(shop.isEmpty()) {
            System.out.println("Shop is empty");
            return;
        }

        ShopItem mostPowerful = shop.iterator().next();

        for(ShopItem shopItem: shop) {
            if(shopItem instanceof ElectronicItem) {
                System.out.println("Item: " + shopItem.getItemName() + " - Price: " + shopItem.getPrice());

                if(((ElectronicItem) shopItem).getPower() > mostPowerful.getPrice()){
                    mostPowerful = shopItem;
                }
            }
        }

        System.out.println("Item: " + mostPowerful.getItemName() + " was bought for the price " + mostPowerful.getPrice() );
        shop.remove(mostPowerful);
    }
}
