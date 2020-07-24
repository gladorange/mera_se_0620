public class Person {
    private String name;
    private String family;

    public Person(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    @Override
    public String toString() {
        return name + " " + family;
    }
}
