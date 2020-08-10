package game2.error;

public class GameSavingInterruptedException extends Exception{
    public GameSavingInterruptedException() {
        super("Прерван выбор имени для сохранения игры");
    }
}
