package com.mera.task4.spell;

import com.mera.task4.character.Character;
import java.util.concurrent.ThreadLocalRandom;

public class InstantHeal extends Spell {

    private static final int RESTORE_HEALTH_POINTS_MIN = 5;
    private static final int RESTORE_HEALTH_POINTS_MAX = 50;

    public InstantHeal() {
        super("Исцеление");
    }

    @Override
    public void cast(Character caster) {
        super.cast(caster);
        int restoredHealth = ThreadLocalRandom.current().nextInt(RESTORE_HEALTH_POINTS_MIN
                                                                 , RESTORE_HEALTH_POINTS_MAX + 1);
        caster.setHealth(caster.getHealth() + restoredHealth);
        System.out.println( String.format("Маг %s исцелен на %d. Теперь у него %d очков здоровья."
                                          , caster.getName(), restoredHealth, caster.getHealth() ) );
    }
}
