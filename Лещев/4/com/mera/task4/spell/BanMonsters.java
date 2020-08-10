package com.mera.task4.spell;

import com.mera.task4.character.Character;
import com.mera.task4.character.Monster;

public class BanMonsters extends Spell {

    private final static String SPELL_NAME = "Изгнание монстров";
    private final static int SPELL_DAMAGE = 15;

    public BanMonsters() {
        super(SPELL_NAME);
    }

    @Override
    public void cast(Character caster) {
        super.cast(caster);
        Character[] targets = caster.getScene().getAllActiveCharacters();
        for(Character target : targets) {
            if(target instanceof Monster) {
                target.causeDamage(SPELL_DAMAGE, this);
            }
        }
        System.out.println(String.format("Заклинание %s наносит %d урона всем монстрам на сцене."
                                         , SPELL_NAME, SPELL_DAMAGE));
    }
}
