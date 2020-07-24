public class ElementsOverlapException extends Exception {
    final static String DEFAULT_OVERLAP_EXCEPTION = "Элемент пересекается с другим эелементом";

    public ElementsOverlapException(String errorMessage) {
        super(errorMessage);
    }
}
