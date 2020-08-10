import course.objects.Animal;
import course.objects.Passenger;

import course.serializers.SimpleSerializer;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        Collection<Object> passengers = new ArrayList<>();

        passengers.add(new Passenger(1, "Valery", "Zhmishenko", 54, 2281488, true));
        passengers.add(new Passenger(2, "Denis", "Petrov", 27, 1488228, true));
        passengers.add(new Animal("Raccoon", "Oreo"));
        passengers.add(new Passenger(3, "Vasya", "Pupkin", 35, 555, true));
        passengers.add(new Animal("Cat", "Skvonchi"));
        passengers.add(new Passenger(4, "Rick", "Sanchez", 54, 424242, true));
        passengers.add(new Passenger(5, "Morty", "Smith", 16, 8800555, true));

        try (FileWriter xmlPassengers = new FileWriter("passengers.xml")) {
            String result = SimpleSerializer.xmlSerialize(passengers);

            xmlPassengers.write(result);
            xmlPassengers.flush();
            xmlPassengers.close();

            System.out.println("Objects have been serialized.");

            System.out.println("Created XML.");
            System.out.println(result);
        }

        HashSet<Class> classes = new HashSet<>();
        classes.add(Passenger.class);
        classes.add(Animal.class);

        StringBuilder xmlClassesData = new StringBuilder();

        Scanner fileScanner = new Scanner(Paths.get("passengers.xml"));

        while (fileScanner.hasNext()) {
            xmlClassesData.append(fileScanner.next());
        }

        fileScanner.close();

        Collection<?> objects = SimpleSerializer.xmlDeserialize(xmlClassesData.toString(), classes);

        if (objects.isEmpty()) {
            return;
        }

        System.out.println("Restored objects.");

        for (Object o : objects) {
            System.out.println(o.toString());
        }

        System.out.print("Objects have been deserialized.");
    }
}