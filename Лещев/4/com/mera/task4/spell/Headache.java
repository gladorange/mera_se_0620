package com.mera.task4.spell;

import com.mera.task4.character.Character;
import com.mera.task4.character.Magician;

public class Headache extends Spell {

    private final static String SPELL_NAME = "Мегрень";
    private final static int SPELL_DAMAGE = 25;

    public Headache() {
        super(SPELL_NAME);
    }

    @Override
    public void cast(Character caster) {
        super.cast(caster);
        Character[] targets = caster.getScene().getAllActiveCharacters();
        for(Character target : targets) {
            if(target instanceof Magician) {
                target.causeDamage(SPELL_DAMAGE, this);
            }
        }
        System.out.println(String.format("Заклинание %s наносит %d урона всем магам на сцене."
                                         , SPELL_NAME, SPELL_DAMAGE));
    }
}
