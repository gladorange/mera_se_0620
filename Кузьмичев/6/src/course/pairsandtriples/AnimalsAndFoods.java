package course.pairsandtriples;

import course.animal.Animal;
import course.tuples.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalsAndFoods {
    public static void main(String[] args) {
        List<Pair<Animal, String>> pairs = new ArrayList<>();
        pairs.add(new Pair<>(new Animal("RACCOON", "Zubastik"), "frog"));
        pairs.add(new Pair<>(new Animal("DOG", "Rex"), "meal"));
        pairs.add(new Pair<>(new Animal("CAT", "Vaska"), "fish"));
        pairs.add(new Pair<>(new Animal("FISH", "Dolores"), "dried flies"));
        pairs.add(new Pair<>(new Animal("SPIDER", "Chernish"), "cockroach"));
        feedAnimals(pairs);
    }

    private static void feedAnimals(List<Pair<Animal, String>> pairs) {
        Integer doubleFoodForAnimalNum = new Random().nextInt(pairs.size());

        for (Pair<Animal, String> pair : pairs) {
            String animalName = pair.getFirstObject().getName();
            String food = pair.getSecondObject();

            if (doubleFoodForAnimalNum.equals(pairs.indexOf(pair))) {
                System.out.printf("The happy animal %s got double %s serving.\n", animalName, food);
                continue;
            }

            System.out.printf("The animal %s has eaten %s with joy.\n", animalName, food);
        }
    }
}