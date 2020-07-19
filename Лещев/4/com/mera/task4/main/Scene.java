package com.mera.task4.main;

import com.mera.task4.character.Character;

public class Scene {

    public final static int CHARACTER_MAX_COUNT = 10;

    private Character[] characters;
    private int turnCounter = 0;

    public Scene() {
        characters = new Character[CHARACTER_MAX_COUNT];
    }

    public Character[] getAllActiveCharacters() {
        int activeCount = countActiveCharacters(characters);
        if(activeCount == 0) {
            return new Character[0];
        }

        Character[] activeCharacters = new Character[activeCount];
        int index = 0;
        for (int i = 0; i < characters.length; i++) {
            if(characters[i] != null) {
                activeCharacters[index++] = characters[i];
            }
        }
        return activeCharacters;
    }

    /**
     * Add new character on the scene.
     * This method will add new character only if position is not occupied by another character.
     * @param character Character to add
     * @param position Character's position on the scene
     * @return true on success, otherwise return false
     */
    public boolean addCharacter(Character character, int position) {
        if(character == null || position < 0 || position >= CHARACTER_MAX_COUNT) {
            throw new IllegalArgumentException();
        }
        if(characters[position] != null) {
            System.out.println("It is not possible to add character with name {" + character.getName() + "} on the scene:");
            System.out.println("Position is occupied by another character with name {" + characters[position].getName() + "};");
            System.out.println("Use removeCharacter() method to delete character from the scene.");
            return false;
        }
        characters[position] = character;
        character.setScene(this);
        character.setPosition(position);
        return true;
    }

    /**
     * Remove character from the scene
     * @param position Character's position
     */
    public void removeCharacter(int position) {
        if(position < 0 || position >= CHARACTER_MAX_COUNT) {
            throw new IllegalArgumentException();
        }
        if(characters[position] != null) {
            System.out.println("Character with name " + characters[position].getName() + " removed from the scene.");
            characters[position].setScene(null);
            characters[position] = null;
        }
    }

    /**
     * Process scene turn
     * @return true if scene is not complete, false if scene is over.
     */
    public boolean processTurn() {
        turnCounter++;
        System.out.println("Ход: " + turnCounter);
        //All characters should perform some actions
        for(Character character : characters) {
            if(character != null) {
                character.act();
                removeDeadIfAny(characters);
            }
        }
        System.out.println("----------------------");
        return (countActiveCharacters(characters) > 1);
    }

    private void removeDeadIfAny(Character[] characters) {
        for (int i = 0; i < characters.length; i++) {
            if(characters[i] != null) {
                int health = characters[i].getHealth();
                //Character is dead
                if(characters[i].getHealth() <= 0) {
                    killCharacter(i);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Обзор сцены: \n");
        for (int i = 0; i < characters.length; i++) {
            sb.append('[');
            sb.append(i);
            sb.append(']');
            if(characters[i] == null) {
                sb.append("<пусто>");
            }
            else {
                sb.append(characters[i].toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void killCharacter(int position) {
        System.out.println(characters[position].getName() + " убит!");
        characters[position] = null;
    }

    private int countActiveCharacters(Character[] characters) {
        int count = 0;
        //How many active characters left on the scene?
        for(Character character : characters) {
            if(character == null) {
                continue;
            }
            if(character.getHealth() > 0) {
                count++;
            }
        }
        return count;
    }

}
