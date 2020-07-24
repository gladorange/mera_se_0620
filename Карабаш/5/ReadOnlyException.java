public class ReadOnlyException extends Exception {
    final static String DEFAULT_READONLY_MESSAGE = "Установка параметра запрещена - элемент в выключенном сосотоянии";

    public ReadOnlyException(String errorMessage) {
        super(errorMessage);
    }
}
