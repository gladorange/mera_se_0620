package game2.error;

import java.io.IOException;

public class GameClassNotFoundException extends ClassNotFoundException {
    public GameClassNotFoundException(String fileName, ClassNotFoundException e) {
        super("Ошибка загрузки объекта данных игры.", e);
    }
}
