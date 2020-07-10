package com.mera.lesson4;

public class FireTouchSpell extends Spell {
    final static int DAMAGE = 8;

    protected FireTouchSpell(String name) {
        super(name);
        power = DAMAGE;
    }

    //This spell makes a damage to neighbours of magician it's casted by
    @Override
    public void cast(Magician magician, Scene scene) {
        GameCharacter[] characters = scene.getCharacters();
        GameCharacter characterToDamage;
        int leftNeighbourIndex = magician.getPosition() - 1;
        int rightNeighbourIndex = magician.getPosition() + 1;

        //check if right and left neighbours exist
        int targetIndex = (rightNeighbourIndex < characters.length) ? rightNeighbourIndex : leftNeighbourIndex;
        while(targetIndex > 0) {
            characterToDamage = characters[targetIndex];
            if (magician.isTargetAvailableForAttack(characterToDamage)) {
                makeDamage(scene, magician, characterToDamage);
                if (scene.getNumOfAliveCharacters() <= 1) {
                    return;
                }
            }
            targetIndex = (targetIndex == leftNeighbourIndex) ? (-1) : leftNeighbourIndex;
        }
    }
}
