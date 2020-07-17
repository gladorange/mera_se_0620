package com.mera.lesson4;

public class ExileOfMonstersSpell extends Spell {
    public final static int DAMAGE = 6;

    protected ExileOfMonstersSpell(String name) {
        super(name);
        power = DAMAGE;
    }

    //This spell makes a damage to all the monsters
    @Override
    public void cast(Magician magician, Scene scene) {
        GameCharacter[] characters = scene.getCharacters();
        GameCharacter characterToDamage;

        for (int i = 0; i < characters.length; i++) {
            characterToDamage = characters[i];
            if (magician.isTargetAvailableForAttack(characterToDamage) && isTargetMonster(characterToDamage)) {
                makeDamage(scene, magician, characterToDamage);
                if (scene.getNumOfAliveCharacters() <= 1) {
                    return;
                }
            }
        }
    }
}
