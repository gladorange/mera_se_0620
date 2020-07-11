package course.tuples;

import java.util.Objects;

public class Triple<T1,T2,T3> {
    private final T1 firstObject;
    private final T2 secondObject;
    private final T3 thirdObject;

    public Triple(T1 firstObject, T2 secondObject, T3 thirdObject) {
        this.firstObject = firstObject;
        this.secondObject = secondObject;
        this.thirdObject = thirdObject;
    }

    public T1 getFirstObject() {
        return firstObject;
    }

    public T2 getSecondObject() {
        return secondObject;
    }

    public T3 getThirdObject() {
        return thirdObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return Objects.equals(firstObject, triple.firstObject) &&
                Objects.equals(secondObject, triple.secondObject) &&
                Objects.equals(thirdObject, triple.thirdObject);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstObject, secondObject, thirdObject);
    }
}
