package game2;

import game2.error.*;

public class Game2Main {

    public static void main(String[] args) {
        final long TIMEOUT = 60_000; // 60 sec.
        final int MAX_LOOP = 1_000;
        try {
            GameTypeManager.selectGameType();
        } catch (GameSelectionInterruptedException | GameTypeSelectionException e) {
            return;
        }
        long startTime = System.currentTimeMillis();
        System.out.println("Становись!");
        Scene2 scene2 = new Scene2();
        if (scene2.getLastError() != 0) {
            System.out.println("Ошибка инициализации. Выход.");
            return;
        }
        scene2.printSceneCharacters();
        System.out.println("В атаку!");
        int counter = 0;
        do {
            System.out.println("----");
            scene2.doCycle();
            counter++;
        } while (scene2.numberOfAliveCharacters() > 1 && (System.currentTimeMillis() - startTime < TIMEOUT) && counter < MAX_LOOP);
        long endTime = System.currentTimeMillis();
        int numAlive = scene2.numberOfAliveCharacters();
        String reason;
        if (numAlive == 1) {
            reason = "(есть победитель)";
        } else if (numAlive == 0) {
            reason = "(нет живых)";
        } else if (counter >= MAX_LOOP) {
            reason = "(максимум циклов)";
        } else {
            reason = "(таймаут)";
        }
        System.out.println("----");
        System.out.println("Битва закончилась " + reason + " (длительность=" + ((endTime - startTime) / 1000.0) + "сек)");
        scene2.printWinner();
        try {
            GameTypeManager.selectSavedFile();
            if (GameTypeManager.getIsNeedSaveGame()) {
                scene2.saveGame();
            }
        } catch (GameSavingInterruptedException | GameSavingSelectionException e) {
            return;
        }
    }

}
