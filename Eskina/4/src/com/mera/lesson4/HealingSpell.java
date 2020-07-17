package com.mera.lesson4;

public class HealingSpell extends Spell {
    public final static int POWER = 5;

    protected HealingSpell(String name) {
        super(name);
        power = POWER;
    }

    //This spell adds health to a magician it's been casted by.
    @Override
    public void cast(Magician magician, Scene scene) {
        magician.health += POWER;
        printCast(magician.getName(), magician.getName());
        magician.isAlive();
    }
}
