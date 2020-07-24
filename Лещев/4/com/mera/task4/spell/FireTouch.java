package com.mera.task4.spell;

import com.mera.task4.character.Character;

public class FireTouch extends Spell {

    private final static String SPELL_NAME = "Огненное касание";
    private final static int SPELL_DAMAGE = 50;

    public FireTouch() {
        super(SPELL_NAME);
    }

    @Override
    public void cast(Character caster) {
        super.cast(caster);
        boolean isAnyTarget = false;
        for(Character target : caster.getScene().getAllActiveCharacters()) {
            if(Math.abs(target.getPosition() - caster.getPosition()) == 1) {
                isAnyTarget = true;
                target.causeDamage(SPELL_DAMAGE, this);
                System.out.println(String.format("Огненное касание наносит %d урона персонажу %s."
                                                 , SPELL_DAMAGE, target.getName()));
            }
        }
        if(!isAnyTarget) {
            System.out.println("Огненное касание никому не причинило вреда.");
        }
    }
}
