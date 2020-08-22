package com.mera.task11;

import com.mera.task11.calculator.Calculator;
import com.mera.task11.lections.Lection;
import com.mera.task11.lections.Student;
import com.mera.task11.lections.StudentFactory;
import com.mera.task11.persons.Person;
import com.mera.task11.persons.PersonCollection;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void personSorting() {
        List<Person> people = PersonCollection.createPersonList();

        System.out.println("Sorting people by name: ");
        PersonCollection.sortByName(people);
        PersonCollection.printPersonList(people);

        System.out.println("Sorting people by age: ");
        PersonCollection.sortByAge(people);
        PersonCollection.printPersonList(people);
    }

    public static void calculator() {
        System.out.println("Expandable calculator: ");
        Calculator calc = new Calculator();
        calc.addOperation("sum", (a, b) -> a + b);
        calc.addOperation("sub", (a, b) -> a - b);
        calc.addOperation("mul", (a, b) -> a * b);
        calc.addOperation("div", (a, b) -> a / b);
        calc.addOperation("pow", Math::pow);
        calc.addOperation("root", (a, b) -> Math.pow(a, 1 / b));

        calc.calculate("sum",2.0,3.0);
        calc.calculate("div", 2.0, 3.0);
        calc.calculate("mul", 2.0, 3.0);
        calc.calculate("div", 2.0, 3.0);
        calc.calculate("pow", 2.0, 3.0);
        calc.calculate("root", 2.0, 3.0);
        //corner cases
        try {
            calc.calculate("mod", 2.0, 3.0);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        calc.calculate("div", 2.0, 0.0);

        System.out.println();
    }

    private static void lectionAnalysis() {
        System.out.println("Lection analysis:");
        List<Student> students = StudentFactory.createStudentGroup();

        System.out.println("List of students who visited math at least once:");
        students.stream()
                 .filter((student) -> student.getAttendedLections()
                                             .stream()
                                             .anyMatch((lection) -> lection.getName().equals(Lection.MATH)))
                 .forEach(student -> System.out.println(student.getName()));

        System.out.println();
        System.out.println("Attention list (Name - Num of attends):");
        students.forEach((student) -> System.out.println(student.getName()
                                                         + " - " + student.getAttendedLections().size()));

        System.out.println();
        System.out.println("The most attended subject list:");
        Map<String, Long> subjects = students.stream()
                                        .flatMap(student -> student.getAttendedLections()
                                                                   .stream()).collect(Collectors.toList())
                                        .stream()
                                        .collect(Collectors.groupingBy(Lection::getName, Collectors.counting()));
        //System.out.println(subjects.values());
        subjects.entrySet().stream().sorted((e1, e2) -> (int) (e2.getValue() - e1.getValue()))
                                    .limit(3)
                                    .forEach((entry) -> System.out.println(entry.getKey() + " - " + entry.getValue()));

        System.out.println();
        System.out.println("List of students with the most attendance");

        students.stream()
                .sorted((s1, s2) -> s2.getAttendedLections().size() - s1.getAttendedLections().size())
                .limit(3)
                .forEach((student) -> System.out.println(student.getName() + " - "
                                                                           + student.getAttendedLections().size()));
        System.out.println();
        System.out.println("Course statistics (Subject - Num of unique attendees):");

        Map<String, Set<String>> itemsAndNames = new HashMap<>();
        students.forEach((student) ->
                         student.getAttendedLections().forEach((lection) ->
                         itemsAndNames.put(lection.getName(), new HashSet<>())));
        students.forEach((student) ->
                         student.getAttendedLections().forEach((lection) ->
                         itemsAndNames.get(lection.getName()).add(student.getName())));
        itemsAndNames.keySet()
                      .forEach((i) -> System.out.println(i + " - " + itemsAndNames.get(i).size()));

    }

    public static void main(String[] args) {
        personSorting();
        calculator();
        lectionAnalysis();
    }
}
