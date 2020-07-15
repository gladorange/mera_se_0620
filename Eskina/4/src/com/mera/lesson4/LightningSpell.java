package com.mera.lesson4;

import java.sql.DataTruncation;
import java.util.Random;

public class LightningSpell extends Spell {
    final static int DAMAGE = 10;

    protected LightningSpell(String name) {
        super(name);
        power = DAMAGE;
    }

    //This spell makes a damage to one random character
    @Override
    public void cast(Magician magician, Scene scene) {
        Random rand = new Random();
        GameCharacter[] characters = scene.getCharacters();
        GameCharacter characterToDamage = scene.findRandomTarget(magician);
        makeDamage(scene, magician, characterToDamage);
    }
}
