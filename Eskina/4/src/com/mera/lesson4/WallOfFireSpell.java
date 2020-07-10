package com.mera.lesson4;

public class WallOfFireSpell extends Spell {
    final static int DAMAGE = 10;

    protected WallOfFireSpell(String name) {
        super(name);
        power = DAMAGE;
    }

    //This spell makes a damage to the characters on even positions
    @Override
    public void cast(Magician magician, Scene scene) {
        GameCharacter[] characters = scene.getCharacters();
        GameCharacter characterToDamage;

        for (int i = 0; i < characters.length; i += 2) {
            characterToDamage = characters[i];
            if (magician.isTargetAvailableForAttack(characterToDamage)) {
                makeDamage(scene, magician, characterToDamage);
                if (scene.getNumOfAliveCharacters() <= 1) {
                    return;
                }
            }
        }
    }
}