import course.itemgenerators.AppleGarden;
import course.itemgenerators.ElectronicFabric;
import course.itemgenerators.FoodFactory;
import course.shopitems.Apple;
import course.shopitems.ElectronicItem;
import course.shopitems.FoodItem;
import course.shopitems.ShopItem;
import course.visitors.ElectronicAddictedVisitor;
import course.visitors.ImJustLookingVisitor;
import course.visitors.RichVisitor;

import java.util.ArrayList;
import java.util.Collection;

public class ShopGenerics {
    public static void main(String[] args) {
        Collection<ShopItem> ashan = new ArrayList<>();
        Collection<ElectronicItem> citilink = new ArrayList<>();;
        Collection<FoodItem> foodCity = new ArrayList<>();;
        Collection<Apple> appleStore = new ArrayList<>();;

        AppleGarden.fillShopWithApples(appleStore);
        ElectronicFabric.fillShopWithElectronicGoods(citilink);
        FoodFactory.fillShopWithFood(foodCity);

        AppleGarden.fillShopWithApples(ashan);
        ElectronicFabric.fillShopWithElectronicGoods(ashan);
        FoodFactory.fillShopWithFood(ashan);

        ImJustLookingVisitor firstPerson = new ImJustLookingVisitor();
        ElectronicAddictedVisitor secondPerson = new ElectronicAddictedVisitor();
        RichVisitor thirdPerson = new RichVisitor();

        firstPerson.visitShop(ashan);
        secondPerson.visitShop(ashan);
        thirdPerson.visitShop(ashan);

        firstPerson.visitShop(citilink);
        secondPerson.visitShop(citilink);
        thirdPerson.visitShop(citilink);

        firstPerson.visitShop(foodCity);
        secondPerson.visitShop(foodCity);
        thirdPerson.visitShop(foodCity);

        firstPerson.visitShop(appleStore);
        secondPerson.visitShop(appleStore);
        thirdPerson.visitShop(appleStore);
    }
}
