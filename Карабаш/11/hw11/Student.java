package hw11;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private final String name;
    private final Set<Lection> visitedLections = new HashSet<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Lection> getVisitedLections() {
        return visitedLections;
    }

    public void addVisitedLection(Lection lection) {
        visitedLections.add(lection);
    }
}
