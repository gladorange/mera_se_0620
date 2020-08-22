package com.mera.task11.lections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class StudentFactory {

    public static List<Student> createStudentGroup() {
        String[] lectionNames = { Lection.MATH, Lection.ENGLISH, Lection.HISTORY, Lection.PHILOSOPHY, Lection.SPORT};
        Lection[] lections = new Lection[20];
        for (int i = 0; i < lections.length; i++) {
            String name = lectionNames[ThreadLocalRandom.current().nextInt(lectionNames.length)];
            lections[i] = new Lection(name, LocalDateGenerator.getLocalDate());
        }

        List<Student> students = new ArrayList<>();

        Student student = new Student("Ann");
        for (int i = 0; i < 5; i++) {
            student.addAttendedLections(lections[i]);
        }
        students.add(student);

        student = new Student("John");
        for (int i = 5; i < 10; i++) {
            student.addAttendedLections(lections[i]);
        }
        students.add(student);

        student = new Student("Mike");
        for (int i = 10; i < 15; i++) {
            student.addAttendedLections(lections[i]);
        }
        students.add(student);

        student = new Student("Jessica");
        for (int i = 15; i < 20; i++) {
            student.addAttendedLections(lections[i]);
        }
        students.add(student);

        student = new Student("Bill");
        for (int i = 10; i < 20; i++) {
            student.addAttendedLections(lections[i]);
        }
        students.add(student);

        student = new Student("Jonathan");
        for (int i = 0; i < 10; i++) {
            student.addAttendedLections(lections[i]);
        }
        students.add(student);

        student = new Student("Sara");
        for (int i = 5; i < 15; i++) {
            student.addAttendedLections(lections[i]);
        }
        students.add(student);

        student = new Student("Lora");
        for (int i = 7; i < 13; i++) {
            student.addAttendedLections(lections[i]);
        }
        students.add(student);

        student = new Student("Luke");
        for (int i = 2; i < 19; i++) {
            student.addAttendedLections(lections[i]);
        }
        students.add(student);

        student = new Student("Linda");
        for (int i = 5; i < 17; i++) {
            student.addAttendedLections(lections[i]);
        }
        students.add(student);

        return students;
    }
}
