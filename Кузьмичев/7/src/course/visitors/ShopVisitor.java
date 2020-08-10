package course.visitors;

import course.shopitems.ShopItem;

import java.util.Collection;

public interface ShopVisitor {
    public void visitShop(Collection<? extends ShopItem> shop);
}
