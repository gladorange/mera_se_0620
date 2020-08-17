package game2.error;

import java.io.IOException;

public class GameFileReadException extends IOException {
    public GameFileReadException(String fileName, IOException e) {
        super("Ошибка чтения файла " + fileName, e);
    }
}
