package game2.error;

public class GameTypeSelectionException extends Exception {
    public GameTypeSelectionException() {
        super("Ошибка при выборе типа игры");
    }
}
