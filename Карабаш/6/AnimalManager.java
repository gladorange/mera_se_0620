import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalManager {

    public void feedAnimals(List<Pair<Animal, String>> favoriteFood) {
        final Random random = new Random();

        if (favoriteFood.size() == 0) {
            System.out.println("Список животных пуст");
            return;
        }
        for (Pair<Animal, String> animalFood : favoriteFood) {
            System.out.println("Животное " + animalFood.getFirst().getName() +
                    " с радостью съедает " + animalFood.getSecond());
        }
        int luckyAnimal = random.nextInt(favoriteFood.size());
        System.out.println("Счастливое животное " + favoriteFood.get(luckyAnimal).getFirst().getName() +
                " получает двойную порцию " + favoriteFood.get(luckyAnimal).getSecond() + "!");
    }
}
