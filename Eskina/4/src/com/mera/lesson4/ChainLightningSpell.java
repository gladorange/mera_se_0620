package com.mera.lesson4;

public class ChainLightningSpell extends Spell {
    public final static int DAMAGE = 7;
    protected ChainLightningSpell(String name) {
        super(name);
        power = DAMAGE;
    }

    //This spell makes a damage to all characters except the character it's been casted by.
    @Override
    public void cast(Magician magician, Scene scene) {
        GameCharacter[] characters = scene.getCharacters();
        GameCharacter characterToDamage;

        for (int i = 0; i < characters.length; i++) {
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
