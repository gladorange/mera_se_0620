package game2.error;

public class GameSavingSelectionException extends Exception {
    public GameSavingSelectionException() {
        super("Ошибка при выборе файла для сохранения игры");
    }
}
