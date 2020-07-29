package course.visitors;

import course.shopitems.ShopItem;

import java.util.Collection;

public class ImJustLookingVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        for (ShopItem shopItem: shop) {
            System.out.println("Item: " + shopItem.getItemName() + " - Price: " + shopItem.getPrice());
        }
    }
}
