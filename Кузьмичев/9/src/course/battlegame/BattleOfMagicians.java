package course.battlegame;

import course.battlegame.gameengine.actions.Weapon;
import course.battlegame.gameengine.actions.longrangestrikes.BowShot;
import course.battlegame.gameengine.actions.spells.*;
import course.battlegame.gameengine.sceneobjects.Scene;
import course.battlegame.gameengine.sceneobjects.positionobjects.characters.Archer;
import course.battlegame.gameengine.sceneobjects.positionobjects.characters.Monster;
import course.battlegame.gameengine.sceneobjects.positionobjects.characters.Magician;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BattleOfMagicians {
    private static Integer MIN_CHARACTERS = 15;
    private static Integer MAX_CHARACTERS = 20;

    private static Integer MAX_MAGICIAN_HEALTH = 50;
    private static Integer MAX_MONSTER_HEALTH = 80;
    private static Integer MAX_ARCHERS_HEALTH = 80;

    private static Integer MIN_SPELLS = 1;
    private static Integer MAX_SPELLS = 4;

    private static Integer MAX_GAME_STEPS = 200;

    public static void main(String[] args) {
        System.out.println("BattleOfMagicians Game. 2020 Author Nikolay Kuzmichev <kuzhexyz@gmail.com>");
        Integer numOfPositions = ThreadLocalRandom.current().nextInt(MIN_CHARACTERS, MAX_CHARACTERS);
        Scene game = new Scene("Avengers", numOfPositions);

        System.out.println(String.format("Loading the server \"%s\" ...", game.getName()));
        creationScene(game, numOfPositions);
        System.out.println("Loading completed.");

        System.out.println("Starting the game.");
        Integer stepCounter = 0;
        while (++stepCounter <= MAX_GAME_STEPS) {
            System.out.println(String.format("Step: %d - Alive Players: %d.", stepCounter, game.getNumOfAliveCharacters()));
            game.gameMove();
            if (game.getEndGame()) {
                break;
            }
        }
    }

    private static void creationScene(Scene scene, Integer numOfPositions) {
        if (scene == null) {
            return;
        }

        for (Integer i = 0; i < numOfPositions; i++) {
            if (ThreadLocalRandom.current().nextBoolean()) {
                Monster monster = new Monster("monster" + i, MAX_MONSTER_HEALTH);
                scene.addCharacter(monster);
                continue;
            }

            if (ThreadLocalRandom.current().nextBoolean()) {
                Archer archer = new Archer("archer" + i, MAX_ARCHERS_HEALTH, new BowShot());
                scene.addCharacter(archer);
                continue;
            }

            Integer numOfSpells = ThreadLocalRandom.current().nextInt(MIN_SPELLS, MAX_SPELLS);
            ArrayList<Weapon> spells = new ArrayList<>();

            for (Integer j = 0; j < numOfSpells; j++) {
                SpellsList randomSpell = SpellsList.values()[ThreadLocalRandom.current().nextInt(SpellsList.values().length)];

                if(randomSpell == SpellsList.CHAINLIGHTNING) {
                    spells.add(new Chainlightning());
                }
                if(randomSpell == SpellsList.ELILEMONSTER) {
                    spells.add(new ExileMonsters());
                }
                if(randomSpell == SpellsList.FIRETOUCH) {
                    spells.add(new Firetouch());
                }
                if(randomSpell == SpellsList.FIREWALL) {
                    spells.add(new Firewall());
                }
                if(randomSpell == SpellsList.HEALLING) {
                    spells.add(new Healling());
                }
                if(randomSpell == SpellsList.LIGHTNING) {
                    spells.add(new Lightning());
                }
                if(randomSpell == SpellsList.MIGRAINE) {
                    spells.add(new Migraine());
                }
            }

            Magician magician = new Magician("mag" + i, MAX_MAGICIAN_HEALTH, spells);
            scene.addCharacter(magician);
        }
    }
}