package com.mera.task11.lections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {

    private final String name;
    private Set<Lection> attendedLections = new HashSet<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Set<Lection> lectionSet) {
        this.name = name;
        this.attendedLections = lectionSet;
    }

    public String getName() {
        return name;
    }

    public Set<Lection> getAttendedLections() {
        return attendedLections;
    }

    public void addAttendedLections(Lection lection) {
        attendedLections.add(lection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(attendedLections, student.attendedLections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attendedLections);
    }
}
