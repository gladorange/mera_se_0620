package com.mera.task4.spell;

import com.mera.task4.character.Character;

public class FireWall extends Spell {

    private final static String SPELL_NAME = "Стена огня";
    private final static int SPELL_DAMAGE = 20;

    public FireWall() {
        super(SPELL_NAME);
    }

    @Override
    public void cast(Character caster) {
        super.cast(caster);
        Character[] targets = caster.getScene().getAllActiveCharacters();
        if(targets.length == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Заклинание ");
        sb.append(SPELL_NAME);
        sb.append(" ударяет по [ ");
        for(Character target : targets) {
            if(target.getPosition() % 2 != 0) {
                target.causeDamage(SPELL_DAMAGE, this);
                sb.append("'" + target.getName() + "' ");
            }
        }
        sb.append("]\nКаждый получает ");
        sb.append(SPELL_DAMAGE);
        sb.append(" урона.");
        System.out.println(sb.toString());
    }
}
