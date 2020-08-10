package com.mera.task4.spell;

import com.mera.task4.character.Character;

import java.util.concurrent.ThreadLocalRandom;

public class Lightning extends Spell {

    private static final String SPELL_NAME = "Молния";
    private static final int SPELL_DAMAGE = 30;

    public Lightning() {
        super(SPELL_NAME);
    }

    @Override
    public void cast(Character caster) {
        super.cast(caster);
        Character[] targets = caster.getScene().getAllActiveCharacters();
        if(targets.length == 0) {
            return;
        }
        Character target;
        if(targets.length == 1) {
            target = targets[0];
        }
        else {
            int targetIndex = ThreadLocalRandom.current().nextInt(targets.length);
            target = targets[targetIndex];
        }
        target.causeDamage(SPELL_DAMAGE, this);
        System.out.println( String.format("Заклинание %s ударило по персонажу %s. Он получил %d урона."
                           , SPELL_NAME, target.getName(), SPELL_DAMAGE) );
    }
}
