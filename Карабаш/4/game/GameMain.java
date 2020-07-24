package game;

public class GameMain {
    public static void main(String[] args) {
        final long TIMEOUT = 60_000; // 60 sec.
        final int MAX_LOOP = 100;
        long startTime = System.currentTimeMillis();
        System.out.println("Становись!");
        Scene scene = new Scene();
        scene.printSceneCharacters();
        System.out.println("В атаку!");
        int counter = 0;
        do {
            System.out.println("----");
            scene.doCycle();
            counter++;
        } while (scene.numberOfAliveCharacters() > 1 && (System.currentTimeMillis() - startTime < TIMEOUT) && counter < MAX_LOOP);
        System.out.println("----");
        System.out.println("Битва закончилась.");
        scene.printWinner();

    }
}
