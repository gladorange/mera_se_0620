package course.pairsandtriples;

import course.date.Date;
import course.date.Month;
import course.person.Person;
import course.tuples.Triple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VisitLists {
    private static final Integer NUM_OF_VISITS = 300;

    public static void main(String[] args) {
        Person[] people = new Person[]{
                new Person("Vasily", "Ivanov"),
                new Person("Peter", "Fomin"),
                new Person("Anastasia", "Petrenko"),
                new Person("Konstantin", "Mitrofanov"),
                new Person("Dmitri", "Zybenko")
        };

        String[] places = new String[]{
                "Home",
                "Work",
                "Library"
        };

        List<Triple<Person, Date, String>> visitList = new ArrayList<>();
        HashSet<Triple<Person, Date, String>> visitHashSet = new HashSet<>();

        for (Integer i = 0; i < VisitLists.NUM_OF_VISITS; i++) {
            Person randomPerson = people[ThreadLocalRandom.current().nextInt(people.length)];

            Month randomMonth = Month.values()[ThreadLocalRandom.current().nextInt(Month.values().length)];
            Integer randomDay = new Random().nextInt(randomMonth.getMaxDay());
            Integer randomYear = ThreadLocalRandom.current().nextInt(new Date().getYear(), new Date().getYear() + 1);
            Date randomDate = new Date(randomDay, randomMonth, randomYear);

            String randomPlace = places[ThreadLocalRandom.current().nextInt(places.length)];

            visitList.add(new Triple<>(randomPerson, randomDate, randomPlace));
            visitHashSet.add(new Triple<>(randomPerson, randomDate, randomPlace));
        }

        if (visitList.size() == visitHashSet.size()) {
            System.out.println("Nobody visits one place twice");
        }
    }
}