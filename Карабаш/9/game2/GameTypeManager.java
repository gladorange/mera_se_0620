package game2;

import game2.error.*;

import java.io.*;

public class GameTypeManager {

    private static Boolean isRealGame = null;
    private static String sourceDataFilePath = null;
    private static String targetDataFilePath = null;
    private static Boolean isNeedSaveGame = null;

    public static void selectGameType() throws GameSelectionInterruptedException, GameTypeSelectionException {
        System.out.println("Начать новую игру (1 - по умолчанию) или воспроизвести сохраненную (2), выход: (0) ? ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        isRealGame = null;
        while (isRealGame == null) {
            System.out.print("Введите вариант [1]/ 2 :");
            String input;
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println("Ошибка чтения ввода. Выход.");
                throw new GameTypeSelectionException();
            }
            if (input == null || input.isEmpty() || input.equals("1")) {
                return;
            } else if (input.equals("2")) {
                isRealGame = false;
            } else if (input.equals("0")) {
                System.out.println("Выход по требованию.");
                throw new GameSelectionInterruptedException();
            } else {
                System.out.println("Неправильный вариант.");
            }
        }
        sourceDataFilePath = null;
        System.out.println("Необходимо ввести полное имя файла с данными сохраненной игры. Введите 0 чтобы прервать процесс ввода файла.");
        while (sourceDataFilePath == null) {
            System.out.print("Введите имя файла (0 - выход): ");
            String input;
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println("Ошибка чтения ввода. Выход.");
                throw new GameTypeSelectionException();
            }
            if (input.equals("0")) {
                System.out.println("Выход по требованию.");
                throw new GameSelectionInterruptedException();
            }

            File inputDataFile = new File(input);
            if (!(inputDataFile.exists() && inputDataFile.isFile() && inputDataFile.canRead())) {
                System.out.println("Файл '" + input + "' не найден или не может быть прочитан.");
                continue;
            }
            sourceDataFilePath = input;
        }
    }

    public static Boolean getIsRealGame() {
        return (isRealGame == null) ? true : isRealGame;
    }

    public static String getSourceDataFilePath() {
        return sourceDataFilePath;
    }

    public static String getTargetDataFilePath() {
        return targetDataFilePath;
    }

    public static Boolean getIsNeedSaveGame() {
        return (isNeedSaveGame == null) ? false : isNeedSaveGame;
    }

    public static void selectSavedFile() throws GameSavingSelectionException, GameSavingInterruptedException {
        if (!getIsRealGame()) {
            isNeedSaveGame = false; // No need to save just loaded/re-played game
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        isNeedSaveGame = null;
        while (isNeedSaveGame == null) {
            System.out.print("Сохранить пройденную игру: Y /[N] ? ");
            String input;
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println("Ошибка чтения ввода. Выход.");
                throw new GameSavingSelectionException();
            }
            if (input == null || input.isEmpty() || input.toUpperCase().equals("N")) {
                isNeedSaveGame = false;
                return;
            } else if (input.toUpperCase().equals("Y")) {
                isNeedSaveGame = true;
            } else {
                System.out.println("Неправильный ответ.");
            }
        }
        System.out.println("Необходимо ввести полное имя файла для записи данных игры. Введите 0 чтобы прервать процесс ввода файла.");
        targetDataFilePath = null;
        while (targetDataFilePath == null) {
            System.out.print("Введите имя файла (0 - выход): ");
            String input;
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println("Ошибка чтения ввода. Выход.");
                isNeedSaveGame = false;
                throw new GameSavingSelectionException();
            }
            if (input.equals("0")) {
                System.out.println("Выход по требованию.");
                isNeedSaveGame = false;
                throw new GameSavingInterruptedException();
            }

            File inputDataFile = new File(input);
            if (inputDataFile.isDirectory()) {
                System.out.println("Введенное имя '" + input + "' - директория.");
                continue;
            }
            String pathName = inputDataFile.getParent();
            if (pathName == null || pathName.isEmpty()) {
                pathName = ".";
            }
            File path = new File(pathName);
            if (!path.exists() || !inputDataFile.exists() && !path.canWrite()) {
                System.out.println("Директория '" + pathName + "' отсутствует или не может быть изменена (нет прав на запись).");
                continue;
            }
            if (inputDataFile.exists()) {
                if (!inputDataFile.canWrite()) {
                    System.out.println("Файл '" + input + "' существует, но не может быть изменен.");
                    continue;
                }
                Boolean isOverwrite = null;
                System.out.println("Файл '" + input + "' существует.");
                while (isOverwrite == null) {
                    System.out.print("Перезаписать : Y /[N] ? ");
                    String answer;
                    try {
                        answer = reader.readLine();
                    } catch (IOException e) {
                        System.out.println("Ошибка чтения ввода. Выход.");
                        isNeedSaveGame = false;
                        throw new GameSavingSelectionException();
                    }
                    if (answer == null || answer.isEmpty() || answer.toUpperCase().equals("N")) {
                        isOverwrite = false;
                    } else if (answer.toUpperCase().equals("Y")) {
                        isOverwrite = true;
                    } else {
                        System.out.println("Неправильный ответ.");
                    }
                }
                if (!isOverwrite) {
                    continue;
                }
            }
            targetDataFilePath = input;
        }
    }

}
