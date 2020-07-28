import java.util.Collection;

public class ImJustLookingVisitor implements ShopVisitor {

    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        System.out.println("Товары в магазине:");
        for (ShopItem item : shop) {
            System.out.println(item.getTypeName() + " " + item.getName() + ", цена " + item.getPrice());
        }
    }
}
