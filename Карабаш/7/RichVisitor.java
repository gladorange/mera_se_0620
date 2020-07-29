import java.util.Collection;
import java.util.Iterator;

public class RichVisitor implements ShopVisitor {

    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        System.out.println("Я покупаю каждый второй товар:");
        Iterator<ShopItem> iterator = ((Collection<ShopItem>) shop).iterator();
        while (iterator.hasNext()) {
            iterator.next();//skipped each 1st good
            if (!iterator.hasNext()) {
                break;
            }
            ShopItem item = iterator.next();
            System.out.println(item.getTypeName() + " " + item.getName() + " куплен по цене " + item.getPrice());
            iterator.remove();
        }
    }
}
