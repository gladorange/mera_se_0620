package course.animal;

public class Animal {
    private final String animalType;
    private final String name;

    public Animal(String animalType, String name) {
        this.animalType = animalType;
        this.name = name;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getName() {
        return name;
    }
}
