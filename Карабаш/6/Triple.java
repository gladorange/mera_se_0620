import java.util.Objects;

public class Triple<T, S, U> {
    private T first;
    private S second;
    private U third;

    public Triple(T first, S second, U third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public U getThird() {
        return third;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Triple)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Triple<?, ?, ?> tripleObj = (Triple<?, ?, ?>) obj;
        return (Objects.equals(first, tripleObj.first) && Objects.equals(second, tripleObj.second) && Objects.equals(third, tripleObj.third));
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }
}
