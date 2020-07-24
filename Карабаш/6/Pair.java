import java.util.Objects;

public class Pair<T, S> {
    private T first;
    private S second;

    public Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Pair<?, ?> pairObj = (Pair<?, ?>) obj;
        return (Objects.equals(first, pairObj.first) && Objects.equals(second, pairObj.second));
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
