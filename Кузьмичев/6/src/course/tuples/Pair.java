package course.tuples;

import java.util.Objects;

public class Pair<T1, T2> {
    private final T1 firstObject;
    private final T2 secondObject;

    public Pair(T1 firstObject, T2 secondObject) {
        this.firstObject = firstObject;
        this.secondObject = secondObject;
    }

    public T1 getFirstObject() {
        return firstObject;
    }

    public T2 getSecondObject() {
        return secondObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(firstObject, pair.firstObject) &&
                Objects.equals(secondObject, pair.secondObject);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstObject, secondObject);
    }
}
