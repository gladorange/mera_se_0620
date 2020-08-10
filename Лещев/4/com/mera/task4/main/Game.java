package com.mera.task4.main;

import com.mera.task4.character.Magician;
import com.mera.task4.character.Monster;
import com.mera.task4.character.Character;
import com.mera.task4.spell.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private final static Scene SCENE = new Scene();

    private final static Spell[] SPELLS = {
            new InstantHeal(), new Lightning(), new ChainLightning(),
            new FireWall(), new FireTouch(), new Headache(), new BanMonsters()
    };

    private final static int MONSTER_MIN_HEALTH = 10;
    private final static int MONSTER_MAX_HEALTH = 200;
    private final static int MONSTER_MIN_DAMAGE = 2;
    private final static int MONSTER_MAX_DAMAGE = 50;

    private final static String[] MONSTER_NAMES = {
            "Гоблин", "Орк", "Урук-хай", "Варг", "Горлум",
            "Тролль", "Шелоб", "Назгул", "Барлог"
    };

    private final static int MAGICIAN_MIN_HEALTH = 100;
    private final static int MAGICIAN_MAX_HEALTH = 300;
    private final static int MAGICIAN_SPELL_MAX_COUNT = 3;

    private final static String[] MAGICIAN_NAMES = {
            "Гендальф Серый", "Саруман Белый", "Радагаст Бурый",
            "Галадриэль", "Король-чародей"
    };

    private static void initRandomScene(Scene scene) {
        //shuffle positions and character names (there will be no duplicates)
        Integer[] positions = generateShuffledNumbers(Scene.CHARACTER_MAX_COUNT);
        Integer[] monsterNameIndexes = generateShuffledNumbers(MONSTER_NAMES.length);
        Integer[] magicianNameIndexes = generateShuffledNumbers(MAGICIAN_NAMES.length);
        //create random amount of characters
        int characterCount = ThreadLocalRandom.current().nextInt(4, Scene.CHARACTER_MAX_COUNT);
        int monsterIndex = 0;
        int magicianIndex = 0;
        for (int i = 0; i < characterCount; i++) {
            Character character;
            if(i % 2 == 0) {
                character = generateRandomMonster(MONSTER_NAMES[monsterNameIndexes[monsterIndex++]]);
            }
            else {
                character = generateRandomMagician(MAGICIAN_NAMES[magicianNameIndexes[magicianIndex++]]);
            }
            scene.addCharacter(character, positions[i]);
        }
    }

    private static Integer[] generateShuffledNumbers(int length) {
        ArrayList<Integer> shuffled = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            shuffled.add(i);
        }
        Collections.shuffle(shuffled);
        return shuffled.toArray(Integer[]::new);
    }

    private static Monster generateRandomMonster(String name) {
        int health = ThreadLocalRandom.current().nextInt(MONSTER_MIN_HEALTH, MONSTER_MAX_HEALTH);
        int damage = ThreadLocalRandom.current().nextInt(MONSTER_MIN_DAMAGE, MONSTER_MAX_DAMAGE);
        return new Monster(name, health, damage);
    }

    private static Magician generateRandomMagician(String name) {
        int health = ThreadLocalRandom.current().nextInt(MAGICIAN_MIN_HEALTH, MAGICIAN_MAX_HEALTH);
        Integer[] spellIndexes = generateShuffledNumbers(SPELLS.length);
        Spell[] spells = new Spell[MAGICIAN_SPELL_MAX_COUNT];
        for (int i = 0; i < spells.length; i++) {
            spells[i] = SPELLS[spellIndexes[i]];
        }
        return new Magician(name, health, spells);
    }

    private static void gameLoop(Scene scene) {
        for(;;) {
            if(!scene.processTurn()) {
                System.out.println("\n");
                System.out.println(SCENE.toString());
                System.out.println("Игра завершена. Победил "
                        + scene.getAllActiveCharacters()[0].getName() + ".");
                break;
            }
        }
    }

    public static void main(String[] args) {
        initRandomScene(SCENE);
        System.out.println(SCENE.toString());
        gameLoop(SCENE);
    }
}
