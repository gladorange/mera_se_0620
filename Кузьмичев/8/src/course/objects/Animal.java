package course.objects;

import course.xmlannotations.XmlName;
import course.xmlannotations.XmlIgnore;

import java.util.Objects;

public class Animal {
    @XmlIgnore
    public static String DEFAULT_ANIMAL_TYPE = "NoType";
    @XmlIgnore
    public static String DEFAULT_NAME = "NoName";

    @XmlName("AnimalType")
    private String animalType;
    @XmlName("Name")
    private String name;

    public Animal() {
        this.animalType = DEFAULT_ANIMAL_TYPE;
        this.name = DEFAULT_NAME;
    }

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

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal {\n" +
                "\t\"animalType\" : \"" + animalType + "\",\n" +
                "\t\"name : \"" + name + "\"\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(animalType, animal.animalType) &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(animalType, name);
    }
}