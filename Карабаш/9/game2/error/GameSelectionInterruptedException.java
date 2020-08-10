package game2.error;

public class GameSelectionInterruptedException extends Exception {
    public GameSelectionInterruptedException() {
        super("Прерван выбор типа игры");
    }
}
