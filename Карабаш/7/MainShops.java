import java.util.ArrayList;
import java.util.Collection;

public class MainShops {

    public static void main(String[] args) {

        Collection<ShopItem> hypermarket = new ArrayList<>();
        Collection<ElectronicItem> electronicsShop = new ArrayList<>();
        Collection<FoodItem> foodShop = new ArrayList<>();
        Collection<Apple> appleShop = new ArrayList<>();

        System.out.println("Заполняем Гипермаркет:");
        ElectronicFabric.fillShopWithElectronicGoods(hypermarket);

        System.out.println("Заполняем Магазин электронной продукции:");
        ElectronicFabric.fillShopWithElectronicGoods(electronicsShop);

        //System.out.println("Try fill Apple shop:");
        //ElectronicFabric.fillShopWithElectronicGoods(appleShop);
        //System.out.println("Try fill Food shop:");
        //ElectronicFabric.fillShopWithElectronicGoods(foodShop);

        System.out.println("Заполняем Продуктовый магазин:");
        AppleGarden.fillShopWithApples(foodShop);

        System.out.println("Заполняем Ларек с яблоками у дома:");
        AppleGarden.fillShopWithApples(appleShop);

        System.out.println("Заполняем Гипермаркет:");
        AppleGarden.fillShopWithApples(hypermarket);

        //System.out.println("Try fill electronics Shop:");
        //AppleGarden.fillShopWithApples(electronicsShop);

        System.out.println("Заполняем Продуктовый магазин:");
        FoodFactory.fillShopWithFood(foodShop);

        System.out.println("Заполняем Гипермаркет:");
        FoodFactory.fillShopWithFood(hypermarket);

        //System.out.println("Try fill electronics Shop:");
        //FoodFactory.fillShopWithFood(electronicsShop);

        //System.out.println("Try fill Apple shop:");
        //FoodFactory.fillShopWithFood(appleShop);

        System.out.println("\n** Посетитель \"Просто гляжу\"");
        ImJustLookingVisitor lookingVisitor = new ImJustLookingVisitor();
        System.out.print("Гипермаркет: ");
        lookingVisitor.visitShop(hypermarket);
        System.out.print("Магазин электроники: ");
        lookingVisitor.visitShop(electronicsShop);
        System.out.print("Продуктовый магазин: ");
        lookingVisitor.visitShop(foodShop);
        System.out.print("Ларек с яблоками: ");
        lookingVisitor.visitShop(appleShop);

        System.out.println("\n** Посетитель \"Электронщик\"");
        ElectronicAddictedVisitor electronicMan = new ElectronicAddictedVisitor();
        System.out.print("Гипермаркет: ");
        electronicMan.visitShop(hypermarket);
        System.out.print("Магазин электроники: ");
        electronicMan.visitShop(electronicsShop);
        System.out.print("Продуктовый магазин: ");
        electronicMan.visitShop(foodShop);
        System.out.print("Ларек с яблоками: ");
        electronicMan.visitShop(appleShop);

        System.out.println("\n** Посетитель \"Богатенький\"");
        RichVisitor richRichy = new RichVisitor();
        System.out.print("Гипермаркет: ");
        richRichy.visitShop(hypermarket);
        System.out.print("Магазин электроники: ");
        richRichy.visitShop(electronicsShop);
        System.out.print("Продуктовый магазин: ");
        richRichy.visitShop(foodShop);
        System.out.print("Ларек с яблоками: ");
        richRichy.visitShop(appleShop);

        System.out.println("\n** И снова \"Просто гляжу\"");
        System.out.print("Гипермаркет: ");
        lookingVisitor.visitShop(hypermarket);
        System.out.print("Магазин электроники: ");
        lookingVisitor.visitShop(electronicsShop);
        System.out.print("Гипермаркет: ");
        lookingVisitor.visitShop(foodShop);
        System.out.print("Ларек с яблоками: ");
        lookingVisitor.visitShop(appleShop);

    }

}
