package com.mera.lesson4;

public class MigraineSpell extends Spell {
    public final static int DAMAGE = 8;

    protected MigraineSpell(String name) {
        super(name);
        power = 8;
    }

    //This spell makes a damage to all the magicians
    @Override
    public void cast(Magician magician, Scene scene) {
        GameCharacter[] characters = scene.getCharacters();
        GameCharacter characterToDamage;

        for (int i = 0; i < characters.length; i++) {
            characterToDamage = characters[i];
            if (magician.isTargetAvailableForAttack(characterToDamage) && (!isTargetMonster(characterToDamage))) {
                makeDamage(scene, magician, characterToDamage);
                if (scene.getNumOfAliveCharacters() <= 1) {
                    return;
                }
            }
        }
    }
}
