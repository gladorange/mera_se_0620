package hw11;

import javafx.util.Pair;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main11 {

    public static void main(String[] args) {
        System.out.println("Main 11:");
        System.out.println("Часть 1: коллекция персон");
        List<Person> people = new ArrayList<>();
        people.add(new Person("Вася", 17));
        people.add(new Person("Андрей", 42));
        people.add(new Person("Коля", 33));
        people.add(new Person("Юрий", 50));
        people.add(new Person("Митрофан", 89));

        System.out.println("Создана коллекция (не сортированная):");
        people.stream()
                .forEach(System.out::println);
        System.out.println("---");
        System.out.println("Сортировка по имени:");
        Collections.sort(people, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        people.stream()
                .forEach(System.out::println);
        System.out.println("---");
        System.out.println("Сортировка по возрасту:");
        Collections.sort(people, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        people.stream()
                .forEach(System.out::println);
        System.out.println("---");

        System.out.println("Часть 2: Расширяемый калькулятор");

        Calculator calc = new Calculator();
        calc.addOperation("sum", (a, b) -> a + b);
        calc.addOperation("diff", (a, b) -> a - b);
        calc.addOperation("multiply", (a, b) -> a * b);
        calc.addOperation("divide", (a, b) -> a / b);
        calc.addOperation("power", (a, b) -> Math.pow(a, b));
        calc.addOperation("sqrN", (a, b) -> Math.pow(a, 1 / b));

        System.out.print("Сумма 2 и 3: ");
        try {
            calc.calculate("sum", 2d, 3d);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.print("Разность 10 и 25: ");
        try {
            calc.calculate("diff", 10d, 25d);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.print("Произведение 3.14 и 20.0: ");
        try {
            calc.calculate("multiply", 3.14d, 20d);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.print("Частное 2.8 и 0.7: ");
        try {
            calc.calculate("divide", 2.8d, 0.7d);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.print("Возведение в степень 2 в 16: ");
        try {
            calc.calculate("power", 2d, 16d);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.print("Корень степени 4 от 256: ");
        try {
            calc.calculate("sqrN", 256d, 4d);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.print("Частное 88 и 0: ");
        try {
            calc.calculate("divide", 88d, 0d);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.print("Корень степени 0 от 10: ");
        try {
            calc.calculate("sqrN", 10d, 0d);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println("---");

        System.out.println("Часть 3. Потоковые лекции..");

        System.out.println("посещение лекций студентами...");
        Lection lection1 = new Lection("матанализ", LocalDate.of(2020, 7, 6));
        Lection lection2 = new Lection("философия", LocalDate.of(2020, 7, 7));
        Lection lection3 = new Lection("английский язык", LocalDate.of(2020, 7, 9));
        Lection lection4 = new Lection("история", LocalDate.of(2020, 7, 11));
        Lection lection5 = new Lection("физкультура", LocalDate.of(2020, 7, 11));
        Lection lection6 = new Lection(lection1.getName()/*"матанализ"*/, LocalDate.of(2020, 7, 11));

        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Вася");
        students.add(student1);
        student1.addVisitedLection(lection2);
        student1.addVisitedLection(lection4);
        student1.addVisitedLection(lection5);

        Student student2 = new Student("Петя");
        students.add(student2);
        student2.addVisitedLection(lection1);
        student2.addVisitedLection(lection2);
        student2.addVisitedLection(lection3);
        student2.addVisitedLection(lection4);

        Student student3 = new Student("Коля");
        students.add(student3);
        student3.addVisitedLection(lection2);
        student3.addVisitedLection(lection4);
        student3.addVisitedLection(lection6);

        Student student4 = new Student("Сеня");
        students.add(student4);
        student4.addVisitedLection(lection4);

        Student student5 = new Student("Андрей");
        students.add(student5);
        student5.addVisitedLection(lection1);
        student5.addVisitedLection(lection2);
        student5.addVisitedLection(lection3);
        student5.addVisitedLection(lection4);
        student5.addVisitedLection(lection5);
        student5.addVisitedLection(lection6);

        Student student6 = new Student("Витя");
        students.add(student6);
        student6.addVisitedLection(lection1);
        student6.addVisitedLection(lection3);
        student6.addVisitedLection(lection4);
        student6.addVisitedLection(lection5);

        Student student7 = new Student("Женя");
        students.add(student7);
        student7.addVisitedLection(lection4);
        student7.addVisitedLection(lection5);
        student7.addVisitedLection(lection6);

        Student student8 = new Student("Оля");
        students.add(student8);
        student8.addVisitedLection(lection1);
        student8.addVisitedLection(lection2);
        student8.addVisitedLection(lection3);
        student8.addVisitedLection(lection4);
        student8.addVisitedLection(lection6);

        Student student9 = new Student("Света");
        students.add(student9);
        student9.addVisitedLection(lection2);
        student9.addVisitedLection(lection3);
        student9.addVisitedLection(lection4);

        Student student10 = new Student("Таня");
        students.add(student10);
        student10.addVisitedLection(lection1);
        student10.addVisitedLection(lection2);
        student10.addVisitedLection(lection3);
        student10.addVisitedLection(lection4);
        student10.addVisitedLection(lection5);
        student10.addVisitedLection(lection6);

        System.out.print("1. Список студентов посетивших " + lection1.getName() + ":");
        students.stream()
                .filter(s -> s.getVisitedLections()
                        .stream()
                        .anyMatch(l -> l.getName().equals(lection1.getName()))
                )
                .forEach(s -> System.out.print(" " + s.getName()));
        System.out.println();

        System.out.println("2. Статистика посещений для каждого студента:");
        students.forEach(s -> System.out.println(" - " + s.getName() + ", посещено: " +
                (long) s.getVisitedLections().size()));

        System.out.print("3. Название дисциплин, имеющих наибольшее количество посещений: ");
        Map<String, Long> visitedLectionCount = students.stream()
                .flatMap(s -> s.getVisitedLections().stream())
                .map(Lection::getName)
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        final Long maxVisits = Collections.max(visitedLectionCount.values());
        visitedLectionCount.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(maxVisits))
                .forEach(e -> System.out.print(" " + e.getKey()));
        System.out.println();

        System.out.print("4. Имена студентов посетивщих наибольшее количество лекций в день:");
        Map<Long, List<String>> numDatesPerStudents = new HashMap<>();
        long maxNumDates = -1L;
        for (Student student : students) {
            long studentMaxNumDays =
                    student.getVisitedLections().stream()
                            .collect(Collectors.groupingBy(Lection::getDate, Collectors.counting()))
                            .values()
                            .stream()
                            .max(Long::compareTo)
                            .orElse(0L);
            if (maxNumDates < studentMaxNumDays) {
                maxNumDates = studentMaxNumDays;
            }
            List<String> names = numDatesPerStudents.get(studentMaxNumDays);
            if (names == null) {
                names = new ArrayList<>();
            }
            names.add(student.getName());
            numDatesPerStudents.put(studentMaxNumDays, names);
        }
        numDatesPerStudents.get(maxNumDates).forEach(s -> System.out.print(" " + s));
        System.out.println();

        System.out.println("5. Статистика по курсам:");
        System.out.println(" Курс: - Количество студентов посетивших хоть раз:");

        students.stream()
                .flatMap(s -> s.getVisitedLections().stream())
                .collect(Collectors.groupingBy(Lection::getName, Collectors.counting()))
                .forEach((k, v) -> System.out.format(" %-15s - %3d\n", k, v));

        System.out.println("---");
    }
}
