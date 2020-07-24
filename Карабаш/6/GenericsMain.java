import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericsMain {


    public static void main(String[] args) {

        System.out.println("Задание А:");

        List<Pair<Animal, String>> animalsWithFood = new ArrayList<>();
        animalsWithFood.add(new Pair<>(new Animal("Вася", "кот"), "молоко"));
        animalsWithFood.add(new Pair<>(new Animal("Бобик", "пёс"), "кость"));
        animalsWithFood.add(new Pair<>(new Animal("Кеша", "попугай"), "печенье"));
        animalsWithFood.add(new Pair<>(new Animal("Нюрка", "корова"), "трава"));

        AnimalManager animalManager = new AnimalManager();
        animalManager.feedAnimals(animalsWithFood);

        System.out.println("Задание Б:");

        List<Person> people = new ArrayList<>();
        people.add(new Person("Иван", "Иванов"));
        people.add(new Person("Сергей", "Сергеев"));
        people.add(new Person("Николай", "Николаев"));
        people.add(new Person("Михайл", "Михайлов"));
        people.add(new Person("Петр", "Петров"));

        List<String> locations = new ArrayList<>();
        locations.add("дом");
        locations.add("работа");
        locations.add("дача");


        System.out.println("генерация списка посещений...");
        VisitsManager visitsManager = new VisitsManager();
        visitsManager.generateVisits(people,locations);

        System.out.println("//всего посещений = "+visitsManager.getVisitList().size());
        System.out.println("//разных записей = "+visitsManager.getVisitSet().size());
        if (visitsManager.isListAndSetSameLength()){
            System.out.println("Ни один человек не посещал одно и то же место два раза в один день");
            visitsManager.printVisitSet();
        } else {
            System.out.println("//Здесь ничего не выведено :-)");
        }

    }
}
