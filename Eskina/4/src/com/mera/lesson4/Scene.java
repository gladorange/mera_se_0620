package com.mera.lesson4;

import java.util.Arrays;
import java.util.Random;

public class Scene {
    public static final int MAX_NUMBER_OF_CHARACTERS;
    public static final int MIN_NUMBER_OF_CHARACTERS;
    public static final Random RAND;

    static {
        MAX_NUMBER_OF_CHARACTERS = 10;
        MIN_NUMBER_OF_CHARACTERS = 2;
        RAND = new Random();
    }

    private GameCharacter[] characters;
    private int numOfAliveCharacters;

    public Scene() {
        characters  = new GameCharacter[MAX_NUMBER_OF_CHARACTERS];
    }

    public GameCharacter[] getCharacters() {
        return characters;
    }

    public int getNumOfAliveCharacters() {
        return numOfAliveCharacters;
    }

    public GameCharacter createRandomCharacter(int position) {
        CharactersEnum characterType = CharactersEnum.generateRandomCharacter();
        switch (characterType) {
            case MAGICIAN:
                return new Magician(position);
            case MONSTER:
                return new Monster(position);
        }
        return null;
    }

    public void createCharacters() {
        //create random number of characters needed for the game to start(from 2 to 10)
        numOfAliveCharacters = RAND.nextInt(characters.length - MIN_NUMBER_OF_CHARACTERS + 1) + MIN_NUMBER_OF_CHARACTERS;
        System.out.println("Number of alive characters: " + numOfAliveCharacters);
        int randPosition;

        for (int i = 0; i < numOfAliveCharacters; i++) {
            do {
                randPosition = RAND.nextInt(characters.length);
            } while (characters[randPosition] != null);

            //if character wasn't added for some reason, repeat the iteration
            if ((characters[randPosition] = createRandomCharacter(randPosition)) == null) {
                i--;
            }
        }
    }
    public void start() {
        createCharacters();
        do {
            for (int i = 0; i < characters.length; i++) {
                if (characters[i] != null) {
                    startRound();
                }
            }
        } while (numOfAliveCharacters > 1);
        System.out.println("Game is over! Number of alive characters is " + numOfAliveCharacters);
        findWinner();
    }

    //describes the behaviour of characters in one game round.
    //Every character consistently performs an action.
    public void startRound() {
        GameCharacter character;
        for (int i = 0; i < characters.length; i++) {
            if (numOfAliveCharacters <= 1) {
                return;
            }
            character = characters[i];
            //if position on scene is empty got to the next character
            if (character == null) {
                continue;
            } else {
                //check if the character is alive(health > 0)
                if (character.isAlive()) {
                    performAction(character);
                }
            }
        }
    }

    //implements the logic of choosing and performing action
    //for the character
    private void performAction(GameCharacter character) {
        if (character instanceof Monster) {
            GameCharacter characterToAttack = findRandomTarget(character);
            Monster monster = (Monster) character;
            monster.makeDamage(characterToAttack);
            checkCharacterAfterAttack(characterToAttack);
        }
        if (character instanceof Magician) {
            Magician magician = (Magician) character;
            Spell spell = magician.getRandomSpellFromBook();
            if (spell != null) {
                spell.cast(magician, this);
            }
        }
    }

    //if target of monster's attack isn't alive, decrement counter of alive characters and set the character to null
    public void checkCharacterAfterAttack(GameCharacter character) {
        if (character.isAlive()) {
            System.out.println("Character " + character.getName() + "is alive. Health = " + character.getHealth());;
        } else {
            --numOfAliveCharacters;
            System.out.println("Character " + character.getName() + "is killed!!! Health = " + character.getHealth());;
            System.out.println("Alive: " + numOfAliveCharacters);
        }
    }


    public void findWinner() {
        for (int i = 0; i < characters.length; i++) {
            if(characters[i] != null) {
                if (characters[i].getHealth() > 0)
                {
                    System.out.println("The Winner is: ");
                }
                System.out.println(characters[i]);
            }
        }
    }

    //choose random target for the character to attack
    public GameCharacter findRandomTarget(GameCharacter character) {
        GameCharacter target;
        do {
            target = characters[RAND.nextInt(characters.length)];
        } while (!character.isTargetAvailableForAttack(target));
        return target;
    }

    public enum CharactersEnum {
        MONSTER,
        MAGICIAN;

        private static final CharactersEnum[] VALUES = values();
        private static final int SIZE = VALUES.length;

        public static CharactersEnum generateRandomCharacter() {
            return VALUES[RAND.nextInt(SIZE)];
        }
    }
}
