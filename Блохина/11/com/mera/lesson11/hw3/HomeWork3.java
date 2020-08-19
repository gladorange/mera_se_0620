package com.mera.lesson11.hw3;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class HomeWork3 {
    public static void main(String[] args) {
        Set<Lection> lecturesForVisited = new HashSet<>();
        lecturesForVisited.add(new Lection("матанализ", LocalDate.of(2020, 8, 16)));
        lecturesForVisited.add(new Lection("философия", LocalDate.of(2020, 8, 17)));
        lecturesForVisited.add(new Lection("английкий язык", LocalDate.of(2020, 8, 17)));
        lecturesForVisited.add(new Lection("история", LocalDate.of(2020, 8, 16)));
        lecturesForVisited.add(new Lection("физкультура", LocalDate.of(2020, 8, 18)));

        List<Student> students = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            String studentName = "Студент" + i;
            students.add(new Student(studentName));
        }

        System.out.println("Список лекций студента");
        students.forEach(student -> {
            student.getStudentLectureList(lecturesForVisited);
            System.out.println(student);
        });

        System.out.println("\nСписок студентов, которые хоть раз посещали матанализ");
        students.stream()
                .filter(student -> student.getVisitedLectureList().stream()
                        .anyMatch(lecture -> lecture.getName().equals("матанализ")))
                .forEach(student -> System.out.println(student.getStudentName()));

        System.out.println("\nСтатистика посещений для каждого студентам в формате: имя - количество посещенных лекций");
        students.forEach(student ->
                System.out.println(student.getStudentName() + " посетил лекций " + student.getVisitedLectureList().size()));

        System.out.println("\nНазвание дисциплин, имеющих наибольшее количество посещений");
        Map<String, Long> countOfVisitedLecture = students.stream()
                .flatMap(student -> student.getVisitedLectureList().stream())
                .collect(Collectors.toList()).stream().collect(Collectors.groupingBy(Lection::getName, Collectors.counting()));
        countOfVisitedLecture.entrySet().stream().filter(e -> e.getValue().equals(Collections.max(countOfVisitedLecture.values())))
                .forEach(e -> System.out.println(e.getKey()));

        System.out.println("\nИмена студентов, которые посетили наибольшее количество лекций в день");
        Map<String, Map<LocalDate, Long>> studentsWithVisitedLecturesOfDay = students.stream()
                .collect(Collectors.toMap(student -> student.getStudentName(), student -> student.getVisitedLectureList()
                        .stream().collect(Collectors.groupingBy(Lection::getDate, Collectors.counting()))));

        Map<String, Map.Entry<LocalDate, Long>> studentsWithMaxVisitedLecturesOfDay = studentsWithVisitedLecturesOfDay.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().entrySet().stream().max(Map.Entry.comparingByValue()).get()));

        Long maxLecturesOfDay = studentsWithMaxVisitedLecturesOfDay.entrySet().stream()
                .max((num1, num2) -> Long.compare(num1.getValue().getValue(), num2.getValue().getValue())).get().getValue().getValue();

        studentsWithMaxVisitedLecturesOfDay.entrySet().stream()
                .filter(e->e.getValue().getValue().equals(maxLecturesOfDay)).forEach(e -> System.out.println(e.getKey()));

        System.out.println("\nСтатистика по курсам в формате:\n" +
                "название курсов - количество разных студентов, которые посетили хотя бы одно занятие");
        students.stream().flatMap(student -> student.getVisitedLectureList().stream())
                .collect(Collectors.groupingBy(Lection::getName, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " - " + v));

    }
}
