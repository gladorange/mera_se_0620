package game2;

import game2.error.*;

import java.io.*;

public class GameDataIO {

    public static void saveData(String fileName, GameScriptData gameScriptData) throws GameFileWriteException {
        System.out.println("Сохранение данных...");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(gameScriptData);
            out.close();
        } catch (IOException e) {
            throw new GameFileWriteException(fileName,e);
        }
        System.out.println("Данные сохранены в файл '"+fileName+"'.");
    }

    public static GameScriptData loadData(String fileName) throws GameFileReadException, GameClassNotFoundException {
        GameScriptData gameScriptData;
        System.out.println("Загрузка данных...");
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            gameScriptData = (GameScriptData)in.readObject();
            in.close();
        } catch (IOException e) {
            throw new GameFileReadException(fileName,e);
        } catch (ClassNotFoundException e) {
            throw new GameClassNotFoundException(fileName,e);
        }
        System.out.println("Данные успешно загружены.");

        return gameScriptData;
    }
}
