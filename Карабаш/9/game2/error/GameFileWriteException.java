package game2.error;

import java.io.IOException;

public class GameFileWriteException extends Exception{
    public GameFileWriteException(String fileName, IOException e) {
        super("Ошибка записи файла " + fileName, e);
    }
}
