package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scene {
    public final static int SCENE_LENGTH = 10;
    public Character[] scene = new Character[SCENE_LENGTH];

    protected final Random random = new Random();
    protected static int lastCharacterId = 0;

    public Scene() {
        fillScene();
    }

    protected void fillScene() {
        int numberOfCharacters = 1 + random.nextInt(SCENE_LENGTH);
        for (int i = 0; i < numberOfCharacters; i++) {
            int position = random.nextInt(SCENE_LENGTH);
            scene[position] = createRandomCharacter(position);
        }
    }

    protected Character createRandomCharacter(int position) {
        Character newCharacter;
        Scene.lastCharacterId++;
        if (random.nextBoolean()) {
            newCharacter = new Monster("Монстро_" + Scene.lastCharacterId, position);
        } else {
            newCharacter = new Magician("Магистр_" + Scene.lastCharacterId, position);
        }
        return newCharacter;
    }

    public int numberOfAliveCharacters() {
        int numberOfCharacters = 0;
        for (int i = 0; i < SCENE_LENGTH; i++) {
            if (scene[i] != null && scene[i].isAlive()) {
                numberOfCharacters++;
            }
        }
        return numberOfCharacters;
    }

    public void printSceneCharacters() {
        System.out.println("Диспозиция:");
        for (int i = 0; i < SCENE_LENGTH; i++) {
            if (scene[i] != null) {
                System.out.println(" * позиция " + i + ": " + scene[i].description());
            }
        }
    }

    public void printWinner() {
        int numberOfAlive = numberOfAliveCharacters();
        if (numberOfAlive > 1) {
            System.out.println("Больше одного персонажа живы!");
        } else if (numberOfAlive == 0) {
            System.out.println("Никто не выжил :-(");
        } else {
            for (int i = 0; i < SCENE_LENGTH; i++) {
                if (scene[i] != null && scene[i].isAlive()) {
                    System.out.println(scene[i].getTypeName() + " " + scene[i].getName() + " победил!");
                    break;
                }
            }
        }
    }

    public Character findOpponentExceptMe(int me) {
        Character[] allExceptMe = findAllExceptMe(me);
        return (allExceptMe.length == 0) ? null : allExceptMe[random.nextInt(allExceptMe.length)];
    }

    public Character findMyNeighbour(int me) {
        int neighboursNum = 0;
        Character neighbourA = null;
        Character neighbourB = null;
        if (me > 0 && scene[me - 1] != null && scene[me - 1].isAlive()) {
            neighboursNum++;
            neighbourA = scene[me - 1];
        }
        if ((me + 1) < SCENE_LENGTH && scene[me + 1] != null && scene[me + 1].isAlive()) {
            neighboursNum++;
            neighbourB = scene[me + 1];
        }
        if (neighboursNum == 0) {
            return null;
        }
        if (neighboursNum == 1) {
            return (neighbourA != null) ? neighbourA : neighbourB;
        }
        return (random.nextInt(2) == 0) ? neighbourA : neighbourB;
    }

    public Character[] findAllExceptMe(int me) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < SCENE_LENGTH; i++) {
            if (scene[i] != null && scene[i].isAlive() && (i != me)) {
                list.add(scene[i]);
            }
        }
        return list.toArray(new Character[0]);
    }

    public Character[] allEvenCharacters() {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < SCENE_LENGTH; i += 2) {
            if (scene[i] != null && scene[i].isAlive()) {
                list.add(scene[i]);
            }
        }
        return list.toArray(new Character[0]);
    }

    public Character[] findAllMagicians() {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < SCENE_LENGTH; i++) {
            if (scene[i] != null && scene[i].isAlive() && scene[i] instanceof Magician) {
                list.add(scene[i]);
            }
        }
        return list.toArray(new Character[0]);
    }

    public Character[] findAllMonsters() {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < SCENE_LENGTH; i++) {
            if (scene[i] != null && scene[i].isAlive() && scene[i] instanceof Monster) {
                list.add(scene[i]);
            }
        }
        return list.toArray(new Character[0]);
    }

    public void doCycle() {
        if (numberOfAliveCharacters() <= 1) {
            System.out.println(" нет партнеров для схватки ");
            return;
        }
        for (int i = 0; i < SCENE_LENGTH; i++) {
            if (scene[i] != null && scene[i].isAlive()) {
                scene[i].doAttackSomeone(this);
                System.out.println(".");
            }
        }
    }

    public Integer chooseSpellNumber(Integer allSpellsNumber) {
        if(allSpellsNumber == null || allSpellsNumber == 0){
            return null;
        }
        return random.nextInt(allSpellsNumber);
    }
}
