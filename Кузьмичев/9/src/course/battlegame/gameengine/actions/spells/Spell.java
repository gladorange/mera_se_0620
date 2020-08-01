package course.battlegame.gameengine.actions.spells;

import course.battlegame.gameengine.actions.Weapon;
import course.battlegame.gameengine.actions.WeaponDescriber;

public abstract class Spell extends Weapon {
    Spell(WeaponDescriber describer) {
        super(describer);
    }
}