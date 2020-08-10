package course.visitors;

import course.shopitems.ShopItem;

import java.util.ArrayList;
import java.util.Collection;

public class RichVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        Collection<ShopItem> iteamsForBuy = new ArrayList<>();
        for(ShopItem shopItem: shop) {
            if(((ArrayList<? extends ShopItem>) shop).indexOf(shopItem) % 2 == 0) {
                System.out.println("Item: " + shopItem.getItemName() + " was bought for the price " + shopItem.getPrice());
                iteamsForBuy.add(shopItem);
            }
        }

        shop.removeAll(iteamsForBuy);
    }
}
