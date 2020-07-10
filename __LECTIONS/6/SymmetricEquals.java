import java.util.Objects;

public class SymmetricEquals {

    static class Person {
        String name;


        public Person(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            return Objects.equals(name, ((Person)o).name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }


    static class PersonWithLN extends Person {

        public PersonWithLN(String name, String lastName) {
            super(name);
            this.lastName = lastName;
        }

        String lastName;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            PersonWithLN that = (PersonWithLN) o;
            return Objects.equals(lastName, that.lastName) && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), lastName);
        }
    }


    public static void main(String[] args) {
        Person vasya = new Person("Vasya");
        PersonWithLN vasyaPupkin = new PersonWithLN("Vasya", "Pupkin");


        System.out.println(vasya.equals(vasyaPupkin));
        System.out.println(vasyaPupkin.equals(vasya));
    }


}
